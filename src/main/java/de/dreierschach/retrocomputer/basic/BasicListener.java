package de.dreierschach.retrocomputer.basic;

import de.dreierschach.retrocomputer.BasicBaseListener;
import de.dreierschach.retrocomputer.BasicParser;
import de.dreierschach.retrocomputer.FileService;
import de.dreierschach.retrocomputer.VsyncTimer;
import de.dreierschach.retrocomputer.basic.model.*;
import de.dreierschach.retrocomputer.config.HelpConfig;
import de.dreierschach.retrocomputer.ui.Renderer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static de.dreierschach.retrocomputer.basic.BasicError.Type.*;
import static de.dreierschach.retrocomputer.basic.model.Value.arrayValue;
import static de.dreierschach.retrocomputer.ui.VideoMode.videoMode;

public class BasicListener extends BasicBaseListener {
    private final Renderer renderer;
    private final RunningContext context;
    private final FileService fileService;
    private final HelpConfig helpConfig;
    private final VsyncTimer vsyncTimer;

    public BasicListener(Renderer renderer, RunningContext context, FileService fileService, HelpConfig helpConfig, VsyncTimer vsyncTimer) {
        this.renderer = renderer;
        this.context = context;
        this.fileService = fileService;
        this.helpConfig = helpConfig;
        this.vsyncTimer = vsyncTimer;
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        throw new BasicError(SYNTAX_ERROR, context.getPp());
    }

    @Override
    public void enterPrint(BasicParser.PrintContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new PrintExpression());
    }

    @Override
    public void exitPrint(BasicParser.PrintContext ctx) {
        if (context.skip()) {
            return;
        }
        var expression = (PrintExpression) (context.expressionStack().pop());
        assertTextMode();
        if (ctx.at != null) {
            var pos = expression.getValue(0).toNumber();
            if (pos < 0 || pos >= renderer.getSize()) {
                throw new BasicError(BasicError.Type.FUNCTION_ERROR, context.getPp());
            }
            renderer.setCursor(pos);
            renderer.print(expression.evaluate(1).toString(), context.getColor(), context.getBgColor());
            return;
        }
        renderer.print(expression.evaluate().toString(), context.getColor(), context.getBgColor());
    }

    @Override
    public void enterPrintln(BasicParser.PrintlnContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new PrintExpression());
    }

    @Override
    public void exitPrintln(BasicParser.PrintlnContext ctx) {
        if (context.skip()) {
            return;
        }
        assertTextMode();
        var expression = (PrintExpression) (context.expressionStack().pop());
        if (ctx.at != null) {
            var pos = expression.getValue(0).toNumber();
            if (pos < 0 || pos >= renderer.getSize()) {
                throw new BasicError(BasicError.Type.FUNCTION_ERROR, context.getPp());
            }
            renderer.setCursor(pos);
            renderer.println(expression.evaluate(1).toString(), context.getColor(), context.getBgColor());
            return;
        }
        renderer.println(expression.evaluate().toString(), context.getColor(), context.getBgColor());
    }

    @Override
    public void exitPrintNewline(BasicParser.PrintNewlineContext ctx) {
        if (context.skip()) {
            return;
        }
        assertTextMode();
        renderer.println(context.getColor(), context.getBgColor());
    }

    @Override
    public void enterAssignment(BasicParser.AssignmentContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new AssignmentExpression());
    }

    @Override
    public void exitAssignment(BasicParser.AssignmentContext ctx) {
        if (context.skip()) {
            return;
        }
        var expression = (AssignmentExpression) context.expressionStack().pop();
        var identifier = expression.identifier();
        var indexes = expression.indexes();
        var value = expression.evaluate();

        setValueByIdentifier(identifier, indexes, value);
    }

    private void setValueByIdentifier(String identifier, List<Integer> indexes, Value value) {
        if (indexes.isEmpty()) {
            context.memory().set(identifier, value);
            return;
        }
        var arrayValue = context.memory().find(identifier).map(v -> v.toType(Value.Type.ARRAY)).orElse(arrayValue(List.of()));
        var current = arrayValue;
        for (var i = 0; i < indexes.size() - 1; i++) {
            var child = current.compute(indexes.get(i), arrayValue(List.of()));
            if (child.type() != Value.Type.ARRAY) {
                child = child.toType(Value.Type.ARRAY);
                current.set(indexes.get(i), child);
            }
            current = child;
        }
        current.set(indexes.get(indexes.size() - 1), value);
        context.memory().set(identifier, arrayValue);
    }

    @Override
    public void enterInput(BasicParser.InputContext ctx) {
        if (context.skip()) {
            return;
        }
        assertTextMode();
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitInput(BasicParser.InputContext ctx) {
        if (context.skip()) {
            return;
        }
        assertTextMode();
        var expression = context.expressionStack().pop();
        var identifier = expression.getValue(0).string();
        var indexes = expression.getValue(1).array().values().stream().map(Value::toNumber).toList();
        context.activateInputLine();
        renderer.setCursorType(Renderer.CursorType.INSERT);
        var input = context.awaitInputLine();
        renderer.setCursorType(Renderer.CursorType.INVISIBLE);
        setValueByIdentifier(identifier, indexes, new Value(input));
    }

    @Override
    public void enterGoto(BasicParser.GotoContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitGoto(BasicParser.GotoContext ctx) {
        if (context.skip()) {
            return;
        }
        var lineNumber = context.expressionStack().pop().evaluate().toNumber();
        context.setNextPp(lineNumber);
    }

    @Override
    public void enterGosub(BasicParser.GosubContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitGosub(BasicParser.GosubContext ctx) {
        if (context.skip()) {
            return;
        }
        context.callStack().push(context.getNextPp());
        var lineNumber = context.expressionStack().pop().evaluate().toNumber();
        context.setNextPp(lineNumber);
    }

    @Override
    public void exitReturn(BasicParser.ReturnContext ctx) {
        if (context.skip()) {
            return;
        }
        if (context.callStack().isEmpty()) {
            throw new BasicError(RETURN_WITHOUT_GOSUB, context.getPp());
        }
        context.setNextPp(context.callStack().pop());
    }

    @Override
    public void enterIfStatement(BasicParser.IfStatementContext ctx) {
        context.expressionStack().push(new IfExpression());
    }

    @Override
    public void enterThenStatement(BasicParser.ThenStatementContext ctx) {
        context.setSkip(!context.expressionStack().peek().evaluate().bool());
        if (!context.skip() && ctx.NUMBER() != null) {
            var line = Integer.parseInt(ctx.NUMBER().getText());
            context.setNextPp(line);
        }
    }

    @Override
    public void enterElseStatement(BasicParser.ElseStatementContext ctx) {
        context.setSkip(context.expressionStack().peek().evaluate().bool());
        if (!context.skip() && ctx.NUMBER() != null) {
            var line = Integer.parseInt(ctx.NUMBER().getText());
            context.setNextPp(line);
        }
    }

    @Override
    public void exitIfStatement(BasicParser.IfStatementContext ctx) {
        context.expressionStack().pop();
        context.setSkip(false);
    }

    @Override
    public void enterForStatement(BasicParser.ForStatementContext ctx) {
        context.expressionStack().push(new ForExpression());
    }

    @Override
    public void exitForStatement(BasicParser.ForStatementContext ctx) {
        var expression = (ForExpression) context.expressionStack().peek();
        var identifier = expression.identifier();
        var indexes = expression.indexes();
        setValueByIdentifier(identifier, indexes, expression.from());
        expression.loopBody(context.getNextPp());
    }

    @Override
    public void exitNextStatement(BasicParser.NextStatementContext ctx) {
        var expression = (ForExpression) context.expressionStack().peek();
        var identifier = expression.identifier();
        var indexes = expression.indexes();
        var value = getValueByIdentifier(identifier, indexes);
        var plus = new OperatorExpression(OperatorExpression.Type.PLUS);
        plus.addValue(value);
        plus.addValue(expression.step());
        value = plus.evaluate();
        setValueByIdentifier(identifier, indexes, value);
        var compare = new OperatorExpression(OperatorExpression.Type.LE);
        compare.addValue(value);
        compare.addValue(expression.to());
        if (compare.evaluate().toBool()) {
            context.setNextPp(expression.loopBody());
        } else {
            context.expressionStack().pop();
        }
    }

    @Override
    public void exitLeftScroll(BasicParser.LeftScrollContext ctx) {
        if (context.skip()) {
            return;
        }
        assertTextMode();
        renderer.scrollLeft();
    }

    @Override
    public void exitRightScroll(BasicParser.RightScrollContext ctx) {
        if (context.skip()) {
            return;
        }
        assertTextMode();
        renderer.scrollRight();
    }

    @Override
    public void enterDelay(BasicParser.DelayContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDelay(BasicParser.DelayContext ctx) {
        if (context.skip()) {
            return;
        }
        var expression = context.expressionStack().pop();
        var delay = expression.evaluate().toDoubleNumber();
        try {
            Thread.sleep((int) (delay * 1000));
        } catch (InterruptedException e) {
            System.out.println("interrupted...");
        }
    }

    @Override
    public void exitEnd(BasicParser.EndContext ctx) {
        context.setRunning(false);
    }

    @Override
    public void exitListAll(BasicParser.ListAllContext ctx) {
        assertTextMode();
        context.memory().lines().forEach(line -> renderer.println(line, context.getColor(), context.getBgColor()));
    }

    @Override
    public void exitListOne(BasicParser.ListOneContext ctx) {
        assertTextMode();
        var lineNumber = Integer.parseInt(ctx.NUMBER().getText());
        renderer.println(context.memory().line(lineNumber), context.getColor(), context.getBgColor());
    }

    @Override
    public void exitListFrom(BasicParser.ListFromContext ctx) {
        assertTextMode();
        var from = Integer.parseInt(ctx.NUMBER().getText());
        context.memory().linesFrom(from).forEach(line -> renderer.println(line, context.getColor(), context.getBgColor()));
    }

    @Override
    public void exitListTo(BasicParser.ListToContext ctx) {
        assertTextMode();
        var to = Integer.parseInt(ctx.NUMBER().getText());
        context.memory().linesTo(to).forEach(line -> renderer.println(line, context.getColor(), context.getBgColor()));
    }

    @Override
    public void exitListFromTo(BasicParser.ListFromToContext ctx) {
        assertTextMode();
        var from = Integer.parseInt(ctx.from.getText());
        var to = Integer.parseInt(ctx.to.getText());
        context.memory().linesFromTo(from, to).forEach(line -> renderer.println(line, context.getColor(), context.getBgColor()));
    }

    @Override
    public void exitClear(BasicParser.ClearContext ctx) {
        context.memory().clearValues();
    }

    @Override
    public void exitCls(BasicParser.ClsContext ctx) {
        renderer.clear(context.getColor(), context.getBgColor());
    }

    @Override
    public void exitNew(BasicParser.NewContext ctx) {
        context.setRunning(false);
        context.memory().clearAll();
        renderer.clearText(context.getColor(), context.getBgColor());
    }

    @Override
    public void enterLoad(BasicParser.LoadContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitLoad(BasicParser.LoadContext ctx) {
        if (context.skip()) {
            return;
        }
        var name = context.expressionStack().pop().evaluate();
        if (name == Value.UNDEF) {
            renderer.println(new BasicError(BasicError.Type.SYNTAX_ERROR, context.getPp()).getMessage(), context.getColor(), context.getBgColor());
            return;
        }
        try {
            fileService.load(name.toString());
            renderer.println("\"" + name + "\" LOADED.", context.getColor(), context.getBgColor());
        } catch (Exception e) {
            renderer.println(new BasicError(BasicError.Type.LOADING_ERROR, context.getPp()).getMessage(), context.getColor(), context.getBgColor());
        }
    }

    @Override
    public void enterSave(BasicParser.SaveContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitSave(BasicParser.SaveContext ctx) {
        if (context.skip()) {
            return;
        }
        var name = context.expressionStack().pop().evaluate();
        if (name == Value.UNDEF) {
            renderer.println(new BasicError(BasicError.Type.SYNTAX_ERROR, context.getPp()).getMessage(), context.getColor(), context.getBgColor());
            return;
        }

        fileService.save(name.toString());
        try {
            renderer.println("\"" + name + "\" SAVED.", context.getColor(), context.getBgColor());
        } catch (Exception e) {
            renderer.println(new BasicError(BasicError.Type.SAVING_ERROR, context.getPp()).getMessage(), context.getColor(), context.getBgColor());
        }
    }

    @Override
    public void exitDir(BasicParser.DirContext ctx) {
        if (context.skip()) {
            return;
        }
        assertTextMode();
        fileService.dir().forEach(name -> renderer.println("- \"" + name + "\"", context.getColor(), context.getBgColor()));
    }

    @Override
    public void enterDel(BasicParser.DelContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDel(BasicParser.DelContext ctx) {
        if (context.skip()) {
            return;
        }
        var name = context.expressionStack().pop().evaluate();
        if (name == Value.UNDEF) {
            renderer.println(new BasicError(BasicError.Type.SYNTAX_ERROR, context.getPp()).getMessage(), context.getColor(), context.getBgColor());
            return;
        }
        try {
            fileService.delete(name.toString());
            renderer.println("\"" + name + "\" DELETED.", context.getColor(), context.getBgColor());
        } catch (Exception e) {
            renderer.println(new BasicError(BasicError.Type.DELETE_ERROR, context.getPp()).getMessage(), context.getColor(), context.getBgColor());
        }
    }

    @Override
    public void enterSetMode(BasicParser.SetModeContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitSetMode(BasicParser.SetModeContext ctx) {
        if (context.skip()) {
            return;
        }
        var expression = context.expressionStack().pop();
        renderer.setVideoMode(videoMode(expression.evaluate().toNumber()));
        context.setColor(1);
        context.setBgColor(0);
        renderer.clear(1, 0);
    }

    @Override
    public void enterColor(BasicParser.ColorContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitColor(BasicParser.ColorContext ctx) {
        if (context.skip()) {
            return;
        }
        var expression = context.expressionStack().pop();
        context.setColor(expression.evaluate().toNumber());
        if (ctx.bg != null) {
            context.setBgColor(expression.getValue(1).toNumber());
        }
    }

    @Override
    public void enterBgcolor(BasicParser.BgcolorContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitBgcolor(BasicParser.BgcolorContext ctx) {
        if (context.skip()) {
            return;
        }
        var expression = context.expressionStack().pop();
        context.setBgColor(expression.evaluate().toNumber());
    }

    @Override
    public void enterSet(BasicParser.SetContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitSet(BasicParser.SetContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var x = expression.getValue(0).toNumber();
        var y = expression.getValue(1).toNumber();
        var color = context.getColor();
        renderer.setPoint(x, y, color);
    }

    @Override
    public void enterDrawLine(BasicParser.DrawLineContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDrawLine(BasicParser.DrawLineContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var x0 = expression.getValue(0).toNumber();
        var y0 = expression.getValue(1).toNumber();
        var x1 = expression.getValue(2).toNumber();
        var y1 = expression.getValue(3).toNumber();
        var color = context.getColor();
        renderer.drawLine(x0, y0, x1, y1, color);
    }

    @Override
    public void enterDrawEllipse(BasicParser.DrawEllipseContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDrawEllipse(BasicParser.DrawEllipseContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var x0 = expression.getValue(0).toNumber();
        var y0 = expression.getValue(1).toNumber();
        var x1 = expression.getValue(2).toNumber();
        var y1 = expression.getValue(3).toNumber();
        var color = context.getColor();
        renderer.drawEllipse(x0, y0, x1, y1, color);
    }

    @Override
    public void enterDrawFEllipse(BasicParser.DrawFEllipseContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }


    @Override
    public void exitDrawFEllipse(BasicParser.DrawFEllipseContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var x0 = expression.getValue(0).toNumber();
        var y0 = expression.getValue(1).toNumber();
        var x1 = expression.getValue(2).toNumber();
        var y1 = expression.getValue(3).toNumber();
        var color = context.getColor();
        renderer.drawFilledEllipse(x0, y0, x1, y1, color);
    }

    @Override
    public void enterDrawRect(BasicParser.DrawRectContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDrawRect(BasicParser.DrawRectContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var x0 = expression.getValue(0).toNumber();
        var y0 = expression.getValue(1).toNumber();
        var x1 = expression.getValue(2).toNumber();
        var y1 = expression.getValue(3).toNumber();
        var color = context.getColor();
        renderer.drawRect(x0, y0, x1, y1, color);
    }

    @Override
    public void enterDrawFRect(BasicParser.DrawFRectContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDrawFRect(BasicParser.DrawFRectContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var x0 = expression.getValue(0).toNumber();
        var y0 = expression.getValue(1).toNumber();
        var x1 = expression.getValue(2).toNumber();
        var y1 = expression.getValue(3).toNumber();
        var color = context.getColor();
        renderer.drawFilledRect(x0, y0, x1, y1, color);
    }

    @Override
    public void enterDrawFace(BasicParser.DrawFaceContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDrawFace(BasicParser.DrawFaceContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var x0 = expression.getValue(0).toNumber();
        var y0 = expression.getValue(1).toNumber();
        var x1 = expression.getValue(2).toNumber();
        var y1 = expression.getValue(3).toNumber();
        var x2 = expression.getValue(4).toNumber();
        var y2 = expression.getValue(5).toNumber();
        var color = context.getColor();
        renderer.drawFace(x0, y0, x1, y1, x2, y2, color);
    }

    @Override
    public void enterDrawFFace(BasicParser.DrawFFaceContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDrawFFace(BasicParser.DrawFFaceContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var x0 = expression.getValue(0).toNumber();
        var y0 = expression.getValue(1).toNumber();
        var x1 = expression.getValue(2).toNumber();
        var y1 = expression.getValue(3).toNumber();
        var x2 = expression.getValue(4).toNumber();
        var y2 = expression.getValue(5).toNumber();
        var color = context.getColor();
        renderer.drawFilledFace(x0, y0, x1, y1, x2, y2, color);
    }

    @Override
    public void enterDrawText(BasicParser.DrawTextContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDrawText(BasicParser.DrawTextContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var text = expression.getValue(0).toString();
        var x = expression.getValue(1).toNumber();
        var y = expression.getValue(2).toNumber();
        var color = context.getColor();
        renderer.drawText(text, x, y, color, -1);
    }

    @Override
    public void enterDrawCText(BasicParser.DrawCTextContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDrawCText(BasicParser.DrawCTextContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var text = expression.getValue(0).toString();
        var x = expression.getValue(1).toNumber();
        var y = expression.getValue(2).toNumber();
        var color = context.getColor();
        renderer.centerText(text, x, y, color, -1);
    }

    @Override
    public void enterDrawFText(BasicParser.DrawFTextContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDrawFText(BasicParser.DrawFTextContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var text = expression.getValue(0).toString();
        var x = expression.getValue(1).toNumber();
        var y = expression.getValue(2).toNumber();
        renderer.drawText(text, x, y, context.getColor(), context.getBgColor());
    }

    @Override
    public void enterDrawFCText(BasicParser.DrawFCTextContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitDrawFCText(BasicParser.DrawFCTextContext ctx) {
        if (context.skip()) {
            return;
        }
        assertGfxMode();
        var expression = context.expressionStack().pop();
        var text = expression.getValue(0).toString();
        var x = expression.getValue(1).toNumber();
        var y = expression.getValue(2).toNumber();
        renderer.centerText(text, x, y, context.getColor(), context.getBgColor());
    }

    @Override
    public void exitArcade(BasicParser.ArcadeContext ctx) {
        renderer.setArcadeMode(true);
    }

    @Override
    public void exitFlip(BasicParser.FlipContext ctx) {
        renderer.flip();
    }

    @Override
    public void enterData(BasicParser.DataContext ctx) {
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitData(BasicParser.DataContext ctx) {
        var expression = context.expressionStack().pop();
        if (context.expressionStack().isEmpty()) {
            return;
        }
        expression.getValues().forEach(v -> context.expressionStack().peek().addValue(v));
    }

    @Override
    public void exitRestore(BasicParser.RestoreContext ctx) {
        if (context.skip()) {
            return;
        }
        if (ctx.NUMBER() != null) {
            context.setDp(Integer.parseInt(ctx.NUMBER().getText()));
            return;
        }
        context.setDp(0);
    }

    @Override
    public void enterRead(BasicParser.ReadContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitRead(BasicParser.ReadContext ctx) {
        if (context.skip()) {
            return;
        }
        var expression = context.expressionStack().pop();
        int i = 0;
        while (i < expression.getValues().size() - 1) {
            var identifier = expression.getValue(i).toString();
            var indexes = expression.getValue(i + 1).array().values().stream().map(Value::toNumber).toList();
            var value = getNextDataValue();
            setValueByIdentifier(identifier, indexes, value);
            i = i + 2;
        }
    }

    public Value getNextDataValue() {
        if (context.getDp().index() >= context.memory().getDataValueSize(context.getDp().line())) {
            context.setDp(context.memory().getNextDataLineNumber(context.getDp().line() + 1));
        }
        if (context.getDp().line() > context.memory().getDataValues().lastKey()) {
            throw new BasicError(OUT_OF_DATA_ERROR, context.getPp());
        }
        var value = context.memory().getDataValues().get(context.getDp().line()).get(context.getDp().index());
        context.setDp(new RunningContext.DP(context.getDp().line(), context.getDp().index() + 1));
        return value;
    }

    @Override
    public void exitHelp(BasicParser.HelpContext ctx) {
        if (context.skip()) {
            return;
        }
        var topic = Optional.ofNullable(ctx.topic).map(Token::getText).map(t -> t.substring(1, t.length() - 1))
                .flatMap(t -> Optional.ofNullable(helpConfig.getTopics().get(t))).orElse(helpConfig.getTopics().get("HELP"));
        renderer.println(">> " + topic.syntax(), context.getColor(), context.getBgColor());
        renderer.println(">> " + topic.example(), context.getColor(), context.getBgColor());
        renderer.print(topic.description(), context.getColor(), context.getBgColor());
        if (topic.syntax().startsWith("HELP")) {
            renderer.println(helpConfig.getTopics().keySet().stream().sorted().collect(Collectors.joining(", ")), context.getColor(), context.getBgColor());
        } else {
            renderer.println(context.getColor(), context.getBgColor());
        }
    }

    @Override
    public void enterVsync(BasicParser.VsyncContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());

    }

    @Override
    public void exitVsync(BasicParser.VsyncContext ctx) {
        if (context.skip()) {
            return;
        }
        if (ctx.expression() != null) {
            var ticks = context.expressionStack().pop().evaluate().toNumber();
            if (ticks <=0 || ticks >50) {
                throw new BasicError(FUNCTION_ERROR, context.getPp());
            }
            vsyncTimer.setTicks(ticks);
            return;
        }
        vsyncTimer.await();
    }

    // -------- Expressions

    @Override
    public void enterPowExpr(BasicParser.PowExprContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new OperatorExpression(OperatorExpression.Type.POW));
    }

    @Override
    public void enterMulDivModExpr(BasicParser.MulDivModExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var token = ctx.op.getText();
        var type = switch (token) {
            case "*" -> OperatorExpression.Type.MUL;
            case "/" -> OperatorExpression.Type.DIV;
            default -> OperatorExpression.Type.MOD;

        };
        context.expressionStack().push(new OperatorExpression(type));
    }

    @Override
    public void enterPlusMinusExpr(BasicParser.PlusMinusExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var token = ctx.op.getText();
        var type = "+".equals(token) ? OperatorExpression.Type.PLUS : OperatorExpression.Type.MINUS;
        context.expressionStack().push(new OperatorExpression(type));
    }

    @Override
    public void enterLogicalExpr(BasicParser.LogicalExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var token = ctx.op.getText();
        var type = switch (token) {
            case "AND" -> OperatorExpression.Type.AND;
            case "OR" -> OperatorExpression.Type.OR;
            default -> OperatorExpression.Type.XOR;

        };
        context.expressionStack().push(new OperatorExpression(type));
    }

    @Override
    public void enterCompExpr(BasicParser.CompExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var token = ctx.op.getText();
        var type = switch (token) {
            default -> OperatorExpression.Type.EQ;
            case "<>" -> OperatorExpression.Type.NEQ;
            case "<" -> OperatorExpression.Type.LT;
            case "<=" -> OperatorExpression.Type.LE;
            case ">" -> OperatorExpression.Type.GT;
            case ">=" -> OperatorExpression.Type.GE;
        };
        context.expressionStack().push(new OperatorExpression(type));
    }

    @Override
    public void enterArrayExpr(BasicParser.ArrayExprContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void enterFuncCallExpr(BasicParser.FuncCallExprContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new FuncCallExpression(ctx.functionCall().fn.getText(), renderer.modeConfig()));
    }

    @Override
    public void exitFuncCallExpr(BasicParser.FuncCallExprContext ctx) {
        if (context.skip()) {
            return;
        }
        exitExpression();
    }

    @Override
    public void enterPointExpr(BasicParser.PointExprContext ctx) {
        if (context.skip()) {
            return;
        }
        if (renderer.isTextMode()) {
            throw new BasicError(FUNCTION_ERROR, context.getPp());
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitPointExpr(BasicParser.PointExprContext ctx) {
        if (context.skip()) {
            return;
        }
        if (renderer.isTextMode()) {
            throw new BasicError(FUNCTION_ERROR, context.getPp());
        }
        var expression = context.expressionStack().pop();
        var x = expression.getValue(0).toNumber();
        var y = expression.getValue(1).toNumber();
        var c = renderer.getColorIndex(x, y);
        context.expressionStack().peek().addValue(new Value(c));
    }

    @Override
    public void exitPowExpr(BasicParser.PowExprContext ctx) {
        if (context.skip()) {
            return;
        }
        exitExpression();
    }

    @Override
    public void exitMulDivModExpr(BasicParser.MulDivModExprContext ctx) {
        if (context.skip()) {
            return;
        }
        exitExpression();
    }

    @Override
    public void exitPlusMinusExpr(BasicParser.PlusMinusExprContext ctx) {
        if (context.skip()) {
            return;
        }
        exitExpression();
    }

    @Override
    public void exitLogicalExpr(BasicParser.LogicalExprContext ctx) {
        if (context.skip()) {
            return;
        }
        exitExpression();
    }

    @Override
    public void exitCompExpr(BasicParser.CompExprContext ctx) {
        if (context.skip()) {
            return;
        }
        exitExpression();
    }

    @Override
    public void exitArrayExpr(BasicParser.ArrayExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var expression = context.expressionStack().pop();
        var result = arrayValue(expression.getValues());
        context.expressionStack().peek().addValue(result);
    }

    public void exitExpression() {
        if (context.skip()) {
            return;
        }
        var result = context.expressionStack().pop().evaluate();
        context.expressionStack().peek().addValue(result);
    }

    @Override
    public void enterIdExp(BasicParser.IdExpContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    private final static Map<String, Value> CONSTANTS = Map.of(
            "PI", new Value(Math.PI)
    );

    @Override
    public void exitIdExp(BasicParser.IdExpContext ctx) {
        if (context.skip()) {
            return;
        }
        var expression = context.expressionStack().pop();
        var identifier = expression.getValue(0).string();
        var indexes = expression.getValue(1).array().values().stream().map(Value::toNumber).toList();
        var value = getValueByIdentifier(identifier, indexes);
        context.expressionStack().peek().addValue(value);
    }

    private Value getValueByIdentifier(String identifier, List<Integer> indexes) {
        if (indexes.isEmpty()) {
            return CONSTANTS.getOrDefault(identifier, context.memory().get(identifier));
        }
        if (!context.memory().contains(identifier)) {
            return Value.UNDEF;
        }
        var current = context.memory().get(identifier);
        for (Integer index : indexes) {
            if (current.type() != Value.Type.ARRAY) {
                return Value.UNDEF;
            }
            current = current.get(index);
        }
        return current;
    }

    @Override
    public void enterIdentifier(BasicParser.IdentifierContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new IdentifierExpression());
    }

    @Override
    public void exitIdentifier(BasicParser.IdentifierContext ctx) {
        if (context.skip()) {
            return;
        }
        var identifier = ctx.IDENTIFIER().getText();
        var indexes = arrayValue(context.expressionStack().pop().getValues());

        context.expressionStack().peek().addValue(new Value(identifier));
        context.expressionStack().peek().addValue(indexes);
    }

    @Override
    public void enterNotExpr(BasicParser.NotExprContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitNotExpr(BasicParser.NotExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var v = context.expressionStack().pop().evaluate();
        context.expressionStack().peek().addValue(not(v));
    }

    private Value not(Value v) {
        return switch (v.type()) {
            case BOOL -> new Value(!v.bool());
            case DOUBLE_NUMBER -> new Value(-v.doubleNumber());
            case NUMBER -> new Value(-v.number());
            case STRING -> new Value(!v.toBool());
            case ARRAY -> v.mutate(this::not);
        };
    }

    @Override
    public void enterNegativeExpression(BasicParser.NegativeExpressionContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitNegativeExpression(BasicParser.NegativeExpressionContext ctx) {
        if (context.skip()) {
            return;
        }
        var v = context.expressionStack().pop().evaluate();
        context.expressionStack().peek().addValue(neg(v));
    }

    private Value neg(Value v) {
        return switch (v.type()) {
            case BOOL -> new Value(!v.bool());
            case DOUBLE_NUMBER -> new Value(-v.doubleNumber());
            case NUMBER -> new Value(-v.number());
            case STRING -> new Value("undefined");
            case ARRAY -> v.mutate(this::neg);
        };
    }

    @Override
    public void enterKeyboardExpr(BasicParser.KeyboardExprContext ctx) {
        if (context.skip()) {
            return;
        }
        context.expressionStack().push(new ValueExpression());
    }

    @Override
    public void exitKeyboardExpr(BasicParser.KeyboardExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var v = context.expressionStack().pop().evaluate();
        Value result;
        if (v == Value.UNDEF) {
            result = new Value(String.valueOf(context.getTypedKey()));
        } else {
            var expected = switch (v.type()) {
                case STRING -> v.toString().charAt(0);
                case BOOL -> 0;
                case NUMBER -> v.number();
                case DOUBLE_NUMBER -> v.toNumber();
                case ARRAY -> v.toNumber();
            };
            result = new Value(context.isPressedKey((char) expected));
        }
        context.expressionStack().peek().addValue(result);
    }

    // -------- literals

    @Override
    public void exitStringExpr(BasicParser.StringExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var text = ctx.STRING_LITERAL().getText();
        var value = new Value(text.substring(1, text.length() - 1));
        context.expressionStack().peek().addValue(value);
    }

    @Override
    public void exitNumExpr(BasicParser.NumExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var number = Integer.parseInt(ctx.NUMBER().getText());
        var value = new Value(number);
        context.expressionStack().peek().addValue(value);
    }

    @Override
    public void exitDoubleExpr(BasicParser.DoubleExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var doubleNumber = Double.parseDouble(ctx.DOUBLE_NUMBER().getText());
        var value = new Value(doubleNumber);
        context.expressionStack().peek().addValue(value);
    }

    @Override
    public void exitBoolExpr(BasicParser.BoolExprContext ctx) {
        if (context.skip()) {
            return;
        }
        var text = ctx.BOOL_LITERAL().getText();
        var value = new Value(text).toType(Value.Type.BOOL);
        context.expressionStack().peek().addValue(value);
    }

    private void assertTextMode() {
        if (!renderer.isTextMode()) {
            throw new BasicError(BasicError.Type.FUNCTION_ERROR, context.getPp());
        }
    }

    private void assertGfxMode() {
        if (!renderer.isGfxMode()) {
            throw new BasicError(BasicError.Type.FUNCTION_ERROR, context.getPp());
        }
    }
}

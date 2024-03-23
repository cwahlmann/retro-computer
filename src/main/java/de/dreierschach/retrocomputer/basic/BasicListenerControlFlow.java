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
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static de.dreierschach.retrocomputer.basic.BasicError.Type.*;
import static de.dreierschach.retrocomputer.basic.model.Value.arrayValue;
import static de.dreierschach.retrocomputer.ui.VideoMode.videoMode;

@Component
public class BasicListenerControlFlow extends BasicBaseListener implements BasicListenerHelper {
    private final Renderer renderer;
    private final RunningContext context;
    private final FileService fileService;
    private final HelpConfig helpConfig;
    private final VsyncTimer vsyncTimer;

    public BasicListenerControlFlow(Renderer renderer, RunningContext context, FileService fileService, HelpConfig helpConfig, VsyncTimer vsyncTimer) {
        this.renderer = renderer;
        this.context = context;
        this.fileService = fileService;
        this.helpConfig = helpConfig;
        this.vsyncTimer = vsyncTimer;
    }

    @Override
    public RunningContext getContext() {
        return context;
    }

    @Override
    public Renderer getRenderer() {
        return renderer;
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
    public void exitEnd(BasicParser.EndContext ctx) {
        context.setRunning(false);
    }
}

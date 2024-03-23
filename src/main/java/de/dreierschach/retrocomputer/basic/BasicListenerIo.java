package de.dreierschach.retrocomputer.basic;

import de.dreierschach.retrocomputer.BasicBaseListener;
import de.dreierschach.retrocomputer.BasicParser;
import de.dreierschach.retrocomputer.FileService;
import de.dreierschach.retrocomputer.VsyncTimer;
import de.dreierschach.retrocomputer.basic.model.Value;
import de.dreierschach.retrocomputer.basic.model.ValueExpression;
import de.dreierschach.retrocomputer.config.HelpConfig;
import de.dreierschach.retrocomputer.ui.Renderer;
import org.springframework.stereotype.Component;

import static de.dreierschach.retrocomputer.basic.BasicError.Type.OUT_OF_DATA_ERROR;

@Component
public class BasicListenerIo extends BasicBaseListener implements BasicListenerHelper{
    private final Renderer renderer;
    private final RunningContext context;
    private final FileService fileService;

    public BasicListenerIo(Renderer renderer, RunningContext context, FileService fileService) {
        this.renderer = renderer;
        this.context = context;
        this.fileService = fileService;
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

    private Value getNextDataValue() {
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
}

package de.dreierschach.retrocomputer.basic;

import de.dreierschach.retrocomputer.BasicBaseListener;
import de.dreierschach.retrocomputer.BasicParser;
import de.dreierschach.retrocomputer.basic.model.ValueExpression;
import de.dreierschach.retrocomputer.config.HelpConfig;
import de.dreierschach.retrocomputer.ui.Renderer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

import static de.dreierschach.retrocomputer.basic.BasicError.Type.SYNTAX_ERROR;

@Component
public class BasicListenerCommon extends BasicBaseListener implements BasicListenerHelper {
    private final Renderer renderer;
    private final RunningContext context;
    private final HelpConfig helpConfig;

    public BasicListenerCommon(Renderer renderer, RunningContext context, HelpConfig helpConfig) {
        this.renderer = renderer;
        this.context = context;
        this.helpConfig = helpConfig;
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
    public void visitErrorNode(ErrorNode node) {
        throw new BasicError(SYNTAX_ERROR, context.getPp());
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
    public void exitNew(BasicParser.NewContext ctx) {
        context.setRunning(false);
        context.memory().clearAll();
        renderer.clearText(context.getColor(), context.getBgColor());
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

}

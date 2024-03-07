package de.dreierschach.retrocomputer.basic;

import de.dreierschach.retrocomputer.BasicParser;
import de.dreierschach.retrocomputer.basic.RunningContext.PP;
import de.dreierschach.retrocomputer.ui.Renderer;
import de.dreierschach.retrocomputer.ui.VideoMode;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.*;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class BasicParseExecutor {

    private final ParseTreeListener listener;
    private final RunningContext context;
    private final Renderer renderer;
    private final SortedMap<Integer, List<BasicParser.StatementContext>> lines = new TreeMap<>();

    public BasicParseExecutor(BasicParser.ProgramContext programContext, ParseTreeListener listener, RunningContext context, Renderer renderer) {
        this.listener = listener;
        this.context = context;
        this.renderer = renderer;
        programContext.line().forEach(line -> lines.put(lineNumber(line), line.statement()));
    }

    private Integer lineNumber(BasicParser.LineContext lineContext) {
        return Integer.parseInt(lineContext.NUMBER().getText());
    }

    public void run() {
        this.run(lines.firstKey());
    }

    public void run(int lineNumber) {
        context.expressionStack().clear();
        context.callStack().clear();
        context.setRunning(true);
        context.setInterrupted(false);
        context.clearKeyBuffers();
        renderer.setCursorType(Renderer.CursorType.INVISIBLE);
        context.setPp(lineNumber);
        context.setNextPp(lineNumber);
        try {
            execute();
        } catch (BasicError e) {
            context.setRunning(false);
            renderer.setCursorType(Renderer.CursorType.INSERT);
            if (!renderer.getVideoMode().isTextType()) {
                renderer.setVideoMode(VideoMode.TEXT_GREEN);
            }
            renderer.newlineIfNeeded(context.getColor(), context.getBgColor());
            renderer.println(e.getMessage(), context.getColor(), context.getBgColor());
        }
        context.setRunning(false);
        renderer.setCursorType(Renderer.CursorType.INSERT);
    }

    public void execute() {
        while (context.isRunning() && !context.isInterrupted() && context.getNextPp().line() <= lines.lastKey()) {
            var tail = lines.tailMap(context.getNextPp().line());
            var lineNumber = tail.firstKey();
            var line = lines.get(lineNumber);
            context.setPp(PP.pp(lineNumber, context.getNextPp().command()));
            context.setNextPp(context.getPp().command() + 1 < line.size()
                    ? PP.pp(context.getPp().line(), context.getPp().command() + 1)
                    : PP.pp(context.getPp().line() + 1, 0));
            execute(line.get(context.getPp().command()));
        }
    }

    public void execute(ParseTree t) {
        if (t instanceof ErrorNode) {
            listener.visitErrorNode((ErrorNode) t);
        } else if (t instanceof TerminalNode) {
            listener.visitTerminal((TerminalNode) t);
        } else {
            RuleNode r = (RuleNode) t;
            this.enterRule(listener, r);
            int n = r.getChildCount();

            for (int i = 0; i < n; ++i) {
                this.execute(r.getChild(i));
            }
            this.exitRule(listener, r);
        }
    }

    protected void enterRule(ParseTreeListener listener, RuleNode r) {
        ParserRuleContext ctx = (ParserRuleContext) r.getRuleContext();
        listener.enterEveryRule(ctx);
        ctx.enterRule(listener);
    }

    protected void exitRule(ParseTreeListener listener, RuleNode r) {
        ParserRuleContext ctx = (ParserRuleContext) r.getRuleContext();
        ctx.exitRule(listener);
        listener.exitEveryRule(ctx);
    }
}

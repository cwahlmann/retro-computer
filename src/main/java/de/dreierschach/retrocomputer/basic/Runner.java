package de.dreierschach.retrocomputer.basic;

import de.dreierschach.retrocomputer.BasicLexer;
import de.dreierschach.retrocomputer.BasicParser;
import de.dreierschach.retrocomputer.FileService;
import de.dreierschach.retrocomputer.VsyncTimer;
import de.dreierschach.retrocomputer.basic.model.Memory;
import de.dreierschach.retrocomputer.basic.model.Value;
import de.dreierschach.retrocomputer.basic.model.ValueExpression;
import de.dreierschach.retrocomputer.config.HelpConfig;
import de.dreierschach.retrocomputer.config.VideoConfig;
import de.dreierschach.retrocomputer.ui.Renderer;
import de.dreierschach.retrocomputer.ui.VideoMode;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.BitSet;

@Component
public class Runner {
    private static final Logger log = LoggerFactory.getLogger(Runner.class);
    private final Renderer renderer;
    private final Memory memory;
    private final FileService fileService;
    private final RunningContext context;
    private BasicListener listener;
    private final HelpConfig helpConfig;
    private final VsyncTimer vsyncTimer;

    public Runner(VideoConfig config, Renderer renderer, Memory memory, FileService fileService, HelpConfig helpConfig, VsyncTimer vsyncTimer) {
        this.memory = memory;
        this.renderer = renderer;
        this.fileService = fileService;
        this.context = new RunningContext(config, memory);
        this.helpConfig = helpConfig;
        this.vsyncTimer = vsyncTimer;
    }

    public void run() {
        run(String.join("\n", memory.lines()), 0);
    }

    public void run(int lineNumber) {
        run(String.join("\n", memory.lines()), lineNumber);
    }

    public void run(String program) {
        run(program, -1);
    }

    public void run(String program, int lineNumber) {
        try {
            var bytesAsChar = CharStreams.fromString(program);
            parse(bytesAsChar);
        } catch (BasicError e) {
            renderer.newlineIfNeeded(context.getColor(), context.getBgColor());
            renderer.println(e.getMessage(), context.getColor(), context.getBgColor());
            renderer.println("READY.", context.getColor(), context.getBgColor());
            return;
        }
        startExecution(lineNumber);
        if (!renderer.getVideoMode().isTextType()) {
            renderer.setVideoMode(VideoMode.TEXT_GREEN);
        }
        if (lineNumber >= 0) {
            context.setColor(1);
            context.setBgColor(0);
        }
        renderer.setArcadeMode(false);
        renderer.newlineIfNeeded(context.getColor(), context.getBgColor());
        if (context.isInterrupted()) {
            renderer.println("?BREAK", context.getColor(), context.getBgColor());
        } else {
            renderer.println("READY.", context.getColor(), context.getBgColor());
        }
    }

    public void stop() {
        context.setInterrupted(true);
        context.setRunning(false);
    }

    public RunningContext getContext() {
        return context;
    }

    // ------------- private methods

    private void parse(CodePointCharStream bytesAsChar) {
        var errorListener = new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
                log.error("Error at line {} char {}: {}", i, i1, s);
                throw new BasicError(BasicError.Type.SYNTAX_ERROR, RunningContext.PP.pp(getLineNUmber(i)));
            }

            @Override
            public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {
                log.error("Ambiguity at line {} char {}", i, i1);
                throw new BasicError(BasicError.Type.SYNTAX_ERROR, RunningContext.PP.pp(getLineNUmber(i)));
            }

            private int getLineNUmber(int index) {
                var line = context.memory().lines().stream().skip(index - 1).findFirst().map(l -> l.split("\\s+")[0]).orElse("0");
                return Integer.parseInt(line);
            }
        };
        var lexer = new BasicLexer(bytesAsChar);
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);
        var tokens = new CommonTokenStream(lexer);
        var parser = new BasicParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        listener = new BasicListener(renderer, context, fileService, helpConfig, vsyncTimer);
        var programContext = parser.program();
        context.memory().getParseTree().clear();
        programContext.line().forEach(line -> context.memory().getParseTree().put(lineNumber(line), line.statement()));
        context.memory().getParseTree().forEach((key, value) -> {
            var values = new ArrayList<Value>();
            value.stream().filter(command -> command.data() != null).forEach(command -> {
                context.expressionStack().push(new ValueExpression());
                executeTreeNode(command.data(), listener);
                values.addAll(context.expressionStack().pop().getValues());
            });
            if (!values.isEmpty()) {
                context.memory().getDataValues().put(key, values);
            }
        });
    }

    private Integer lineNumber(BasicParser.LineContext lineContext) {
        return Integer.parseInt(lineContext.NUMBER().getText());
    }

    private void startExecution(int lineNumber) {
        context.expressionStack().clear();
        context.callStack().clear();
        context.setRunning(true);
        context.setInterrupted(false);
        context.clearKeyBuffers();
        renderer.setCursorType(Renderer.CursorType.INVISIBLE);
        context.setPp(lineNumber);
        context.setNextPp(lineNumber);
        context.setDp(0);
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

    private void execute() {
        while (context.isRunning() && !context.isInterrupted() && context.getNextPp().line() <= context.memory().getParseTree().lastKey()) {
            executeSingleStatement(context, listener);
        }
    }

    private void executeSingleStatement(RunningContext context, BasicListener listener) {
        var tail = context.memory().getParseTree().tailMap(context.getNextPp().line());
        var lineNumber = tail.firstKey();
        var line = context.memory().getParseTree().get(lineNumber);
        context.setPp(RunningContext.PP.pp(lineNumber, context.getNextPp().command()));
        context.setNextPp(context.getPp().command() + 1 < line.size()
                ? RunningContext.PP.pp(context.getPp().line(), context.getPp().command() + 1)
                : RunningContext.PP.pp(context.getPp().line() + 1, 0));
        executeTreeNode(line.get(context.getPp().command()), listener);
    }

    private void executeTreeNode(ParseTree t, BasicListener listener) {
        if (t instanceof ErrorNode) {
            listener.visitErrorNode((ErrorNode) t);
        } else if (t instanceof TerminalNode) {
            listener.visitTerminal((TerminalNode) t);
        } else {
            RuleNode r = (RuleNode) t;
            this.enterRule(listener, r);
            int n = r.getChildCount();

            for (int i = 0; i < n; ++i) {
                this.executeTreeNode(r.getChild(i), listener);
            }
            this.exitRule(listener, r);
        }
    }

    private void enterRule(ParseTreeListener listener, RuleNode r) {
        ParserRuleContext ctx = (ParserRuleContext) r.getRuleContext();
        listener.enterEveryRule(ctx);
        ctx.enterRule(listener);
    }

    private void exitRule(ParseTreeListener listener, RuleNode r) {
        ParserRuleContext ctx = (ParserRuleContext) r.getRuleContext();
        ctx.exitRule(listener);
        listener.exitEveryRule(ctx);
    }
}

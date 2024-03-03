package de.dreierschach.retrocomputer.basic;

import de.dreierschach.retrocomputer.BasicLexer;
import de.dreierschach.retrocomputer.BasicParser;
import de.dreierschach.retrocomputer.FileService;
import de.dreierschach.retrocomputer.basic.model.Memory;
import de.dreierschach.retrocomputer.config.VideoConfig;
import de.dreierschach.retrocomputer.ui.Renderer;
import de.dreierschach.retrocomputer.ui.VideoMode;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.BitSet;

@Component
public class Runner {
    private static Logger log = LoggerFactory.getLogger(Runner.class);
    private final Renderer renderer;
    private final Memory memory;
    private final FileService fileService;
    private final RunningContext context;

    public Runner(VideoConfig config, Renderer renderer, Memory memory, FileService fileService) {
        this.memory = memory;
        this.renderer = renderer;
        this.fileService = fileService;
        this.context = new RunningContext(config, memory);
    }

    public void run() {
        run(String.join("\n", memory.lines()));
    }

    public void run(int lineNumber) {
        run(String.join("\n", memory.lines()), lineNumber);
    }

    public void run(String program) {
        run(program, 0);
    }

    public void run(String program, int lineNumber) {
        BasicParseExecutor executor;
        try {
            var bytesAsChar = CharStreams.fromString(program);
            executor = getExecutor(bytesAsChar);
        } catch (BasicError e) {
            renderer.newlineIfNeeded();
            renderer.println(e.getMessage());
            renderer.println("READY.");
            return;
        }
        executor.run(lineNumber);
        if (!renderer.getVideoMode().isTextType()) {
            renderer.setVideoMode(VideoMode.TEXT_GREEN);
            renderer.clear();
        }
        renderer.setArcadeMode(false);
        renderer.newlineIfNeeded();
        if (context.isInterrupted()) {
            renderer.println("?BREAK");
        } else {
            renderer.println("READY.");
        }
    }

    private BasicParseExecutor getExecutor(CodePointCharStream bytesAsChar) {
        var errorListener = new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
                log.error("Error at line {} char {}: {}", i, i1, s);
                var line = getLineNUmber(i);
                throw new BasicError(BasicError.Type.SYNTAX_ERROR, RunningContext.PP.pp(getLineNUmber(i)));
            }

            @Override
            public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {
                log.error("Ambiguity at line {} char {}", i, i1);
                throw new BasicError(BasicError.Type.SYNTAX_ERROR, RunningContext.PP.pp(getLineNUmber(i)));
            }

            private int getLineNUmber(int index) {
                var line = context.memory().lines().stream().skip(index - 1).findFirst().map(l -> l.split("\s+")[0]).orElse("0");
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
        var listener = new BasicListener(renderer, context, fileService);
        var programContext = parser.program();
        return new BasicParseExecutor(programContext, listener, context, renderer);
    }

    public void stop() {
        context.setInterrupted(true);
        context.setRunning(false);
    }

    public RunningContext getContext() {
        return context;
    }
}

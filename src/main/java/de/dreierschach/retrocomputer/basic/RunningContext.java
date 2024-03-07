package de.dreierschach.retrocomputer.basic;

import de.dreierschach.retrocomputer.basic.model.Expression;
import de.dreierschach.retrocomputer.basic.model.Memory;
import de.dreierschach.retrocomputer.basic.model.Stack;
import de.dreierschach.retrocomputer.config.VideoConfig;

import java.util.Deque;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class RunningContext {
    public record PP(int line, int command) {
        public static PP pp(int line) {
            return new PP(line, 0);
        }

        public static PP pp(int line, int command) {
            return new PP(line, command);
        }
    }

    private boolean running;
    private boolean interrupted;
    private PP pp;
    private PP nextPp;
    private final Memory memory;
    private final VideoConfig config;

    private final Stack<Expression> expressionStack = new Stack<>();
    private final Stack<RunningContext.PP> callStack = new Stack<>();
    private boolean skip;

    private CompletableFuture<String> inputLineBuffer = null;
    private final Deque<Character> keyTypedBuffer = new ConcurrentLinkedDeque<>();
    private final Set<Character> pressedKeys;
    private Mode inputMode = Mode.EDIT;

    public enum Mode {
        EDIT, RUN, RUN_INPUT
    }

    public int color = 1;
    public int bgColor = 0;

    public RunningContext(VideoConfig config, Memory memory) {
        this.config = config;
        this.memory = memory;
        var keyMap = new ConcurrentHashMap<Character, Object>();
        this.pressedKeys = keyMap.keySet("");
    }

    public VideoConfig getConfig() {
        return config;
    }

    public Mode getInputMode() {
        return inputMode;
    }

    public void setInputMode(Mode inputMode) {
        this.inputMode = inputMode;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
        setInputMode(running ? Mode.RUN : Mode.EDIT);
    }

    public boolean isInterrupted() {
        return interrupted;
    }

    public void setInterrupted(boolean interrupted) {
        this.interrupted = interrupted;
    }

    public PP getPp() {
        return pp;
    }

    public void setPp(PP pp) {
        this.pp = pp;
    }

    public void setPp(int line) {
        this.pp = PP.pp(line);
    }

    public PP getNextPp() {
        return nextPp;
    }

    public void setNextPp(PP nextPp) {
        this.nextPp = nextPp;
    }

    public void setNextPp(int line) {
        this.nextPp = PP.pp(line);
    }

    public Memory memory() {
        return memory;
    }

    public Stack<Expression> expressionStack() {
        return expressionStack;
    }

    public Stack<PP> callStack() {
        return callStack;
    }

    public boolean skip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String awaitInputLine() {
        try {
            var result = inputLineBuffer.get();
            this.setInputMode(Mode.RUN);
            return result;
        } catch (Exception e) {
            this.setInputMode(Mode.RUN);
            return "";
        }
    }

    public Character getTypedKey() {
        return Optional.ofNullable(keyTypedBuffer.poll()).orElse((char)0);
    }

    public void addTypedKey(Character c) {
        keyTypedBuffer.addLast(c);
    }

    public void setPressedKey(Character c, int code) {
        var ch = c != 65535 ? c : (char) code;
        if (Character.isAlphabetic(c)) {
            ch = String.valueOf(ch).toUpperCase().charAt(0);
        }
        pressedKeys.add(ch);
    }

    public void removePressedKey(Character c, int code) {
        var ch = c != 65535 ? c : (char) code;
        if (Character.isAlphabetic(c)) {
            ch = String.valueOf(ch).toUpperCase().charAt(0);
        }
        pressedKeys.remove(ch);
    }

    public boolean isPressedKey(Character c) {
        return pressedKeys.contains(c);
    }

    public void clearKeyBuffers() {
        pressedKeys.clear();
        keyTypedBuffer.clear();
    }

    public void setInputLine(String inputLine) {
        inputLineBuffer.complete(inputLine);
    }

    public void activateInputLine() {
        this.inputLineBuffer = new CompletableFuture<>();
        this.setInputMode(Mode.RUN_INPUT);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }
}

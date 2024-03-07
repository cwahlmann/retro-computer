package de.dreierschach.retrocomputer.ui;

import de.dreierschach.retrocomputer.basic.Runner;
import de.dreierschach.retrocomputer.basic.RunningContext;
import de.dreierschach.retrocomputer.basic.model.Memory;
import de.dreierschach.retrocomputer.config.VideoConfig;
import de.dreierschach.retrocomputer.ui.frame.Key;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.concurrent.CompletableFuture.runAsync;

@Component
public class InputHandler {
    private final Set<Key> pressedKeys = ConcurrentHashMap.newKeySet();

    private final Renderer renderer;
    private final Runner runner;
    private final Memory memory;
    private final VideoConfig videoConfig;
    private int inputSize = 0;
    private int inputPosition = 0;

    public InputHandler(Renderer renderer, Runner runner, Memory memory, VideoConfig videoConfig) {
        this.renderer = renderer;
        this.runner = runner;
        this.memory = memory;
        this.videoConfig = videoConfig;
    }

    public final void _onKeyPressed(KeyEvent e) {
        pressedKeys.add(new Key(e.getKeyCode(), e.getExtendedKeyCode()));
        if (runner.getContext().getInputMode() == RunningContext.Mode.RUN) {
            runner.getContext().setPressedKey(e.getKeyChar(), e.getKeyCode());
        }
        onKeyTyped(e);
    }

    public final void _onKeyReleased(KeyEvent e) {
        if (runner.getContext().getInputMode() == RunningContext.Mode.RUN) {
            runner.getContext().removePressedKey(e.getKeyChar(), e.getKeyCode());
        }
        pressedKeys.remove(new Key(e.getKeyCode(), e.getExtendedKeyCode()));
    }

    public final void _onKeyTyped(KeyEvent e) {
    }

    public boolean isKeyPressed(Key key) {
        return pressedKeys.contains(key);
    }

    public void onKeyTyped(KeyEvent keyEvent) {
        var c = keyEvent.getKeyChar();
        var code = keyEvent.getKeyCode();
        var extended = keyEvent.getExtendedKeyCode();
//        System.out.println(((int) c)+": "+code+"/"+extended);
        if (inputSize == 0) {
            inputPosition = renderer.getCursor();
        }
        if (runner.getContext().getInputMode() == RunningContext.Mode.RUN) {
            runner.getContext().addTypedKey(c);
        }
        if (c >= ' ' && c != 0x7f && c != 65535) {
            if (runner.getContext().getInputMode() != RunningContext.Mode.RUN) {
                if (inputPosition + inputSize >= renderer.getSize()) {
                    renderer.scrollUp(runner.getContext().getColor(), runner.getContext().getBgColor());
                    inputPosition -= videoConfig.getModes().get(0).getWidth();
                }
                renderer.insertAtCursor(new Renderer.Char(Character.toUpperCase(c), runner.getContext().getColor(), runner.getContext().getBgColor()), inputSize - (renderer.getCursor() - inputPosition));
                inputSize++;
            }
            return;
        }
        if (c == 0x03) {
            if (runner.getContext().getInputMode() != RunningContext.Mode.EDIT) {
                runner.stop();
            }
        }
        if (c == 0x0a) {
            if (runner.getContext().getInputMode() == RunningContext.Mode.EDIT) {
                var input = renderer.get(inputPosition, inputSize);
                renderer.setCursor(inputPosition + inputSize);
                renderer.println(runner.getContext().getColor(), runner.getContext().getBgColor());
                if (matchesRunCommand(input)) {
                    var s = input.substring(input.indexOf('N') + 1).trim();
                    if (StringUtils.isEmpty(s)) {
                        memory.clearValues();
                        runAsync(runner::run);
                    } else {
                        var lineNumber = Integer.parseInt(s);
                        runAsync(() -> runner.run(lineNumber));
                    }
                } else if (matchesEditCommand(input)) {
                    var s = input.substring(input.indexOf('T') + 1).trim();
                    var lineNumber = Integer.parseInt(s);
                    var line = memory.line(lineNumber);
                    renderer.print(line, runner.getContext().getColor(), runner.getContext().getBgColor());
                    inputSize = line.length();
                    inputPosition = renderer.getCursor() - line.length();
                    return;
                } else if (matchesRemoveLine(input)) {
                    memory.removeLine(Integer.parseInt(input.trim()));
                } else if (matchesStoreLine(input)) {
                    memory.withLines(input);
                } else {
                    runAsync(() -> runner.run("0 " + input));
                }
                inputSize = 0;
            } else if (runner.getContext().getInputMode() == RunningContext.Mode.RUN_INPUT) {
                var input = renderer.get(inputPosition, inputSize);
                runner.getContext().setInputLine(input);
                renderer.println(runner.getContext().getColor(), runner.getContext().getBgColor());
                inputSize = 0;
            }
            return;
        }
        if (c == 0x08) { // backspace
            if (runner.getContext().getInputMode() != RunningContext.Mode.RUN) {
                if (renderer.getCursor() == inputPosition || inputSize == 0) {
                    return;
                }
                renderer.moveLeft();
                renderer.deleteAtCursor(inputSize - (renderer.getCursor() - inputPosition));
                inputSize--;
            }
            return;
        }
        if (c == 0x7f) { // remove
            if (runner.getContext().getInputMode() != RunningContext.Mode.RUN) {
                if (renderer.getCursor() == inputPosition + inputSize || inputSize == 0) {
                    return;
                }
                renderer.deleteAtCursor(inputSize - (renderer.getCursor() - inputPosition));
                inputSize--;
            }
            return;
        }
        if (code == 0x25) { // left
            if (runner.getContext().getInputMode() != RunningContext.Mode.RUN) {
                if (renderer.getCursor() > inputPosition) {
                    renderer.moveLeft();
                }
            }
            return;
        }
        if (code == 0x27) { // right
            if (runner.getContext().getInputMode() != RunningContext.Mode.RUN) {
                if (renderer.getCursor() < inputPosition + inputSize) {
                    renderer.moveRight(runner.getContext().getColor(), runner.getContext().getBgColor());
                }
            }
            return;
        }
        if (code == 0x26) { // up
            return;
        }
        if (code == 0x28) { // down
            return;
        }
        if (code == 0x24) { // pos1
            return;
        }
        if (code == 0x23) { // end
            return;
        }
    }

    private boolean matchesRunCommand(String input) {
        return input.matches("[\s]*RUN([\s]+[0-9]+)?\s*");
    }

    private boolean matchesEditCommand(String input) {
        return input.matches("[\s]*EDIT[\s]+[0-9]+\s*");
    }

    private boolean matchesStoreLine(String input) {
        return input.matches("[\s]*[0-9]+[\s]+.+");
    }

    private boolean matchesRemoveLine(String input) {
        return input.matches("[\s]*[0-9]+[\s]*");
    }

}

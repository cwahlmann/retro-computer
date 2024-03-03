package de.dreierschach.retrocomputer.ui;

import de.dreierschach.retrocomputer.config.VideoConfig;
import de.dreierschach.retrocomputer.ui.frame.Frame;
import org.springframework.stereotype.Component;

@Component
public class RetroUi {
    private final Frame frame;

    public RetroUi(VideoConfig videoConfig, Renderer renderer, InputHandler inputHandler) {
        this.frame = new Frame(videoConfig, renderer, inputHandler);
        frame.setVisible(true);
    }
}

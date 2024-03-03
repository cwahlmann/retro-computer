package de.dreierschach.retrocomputer.ui;

import java.util.Arrays;

public enum VideoMode {
    TEXT_GREEN(0, true), TEXT_OCHER(1, true), HIRES(2, false), HIRES_OCHER(3, false), LORES1(4, false), LORES2(5, false), HYAND(6, false);
    private final int mode;
    private final boolean textType;

    VideoMode(int mode, boolean textType) {
        this.mode = mode;
        this.textType = textType;
    }

    public int getMode() {
        return mode;
    }

    public boolean isTextType() {
        return textType;
    }

    public static VideoMode videoMode(int mode) {
        return Arrays.stream(values()).filter(v -> v.mode == mode).findAny().orElse(VideoMode.TEXT_GREEN);
    }
}

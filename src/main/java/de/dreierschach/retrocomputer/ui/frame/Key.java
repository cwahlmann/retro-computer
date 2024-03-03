package de.dreierschach.retrocomputer.ui.frame;

public record Key(int keyCode, int extendedKeyCode) {
    public static Key key(int keyCode) {
        return new Key(keyCode, keyCode);
    }

    public static Key key(int keyCode, int extendedKeyCode) {
        return new Key(keyCode, extendedKeyCode);
    }
}

package de.dreierschach.retrocomputer.ui.frame;

import de.dreierschach.retrocomputer.config.VideoConfig;
import de.dreierschach.retrocomputer.ui.InputHandler;
import de.dreierschach.retrocomputer.ui.Renderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame {
    private final MainCanvas mainCanvas;

    public Frame(VideoConfig config, Renderer renderer, InputHandler inputHandler) {
        super("Retro Computer");
        if (config.isFullscreen()) {
            GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(this);
        } else {
            setSize(config.getWidth(), config.getHeight());
        }
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                mainCanvas.setSize(e.getComponent().getSize());
                mainCanvas.repaint();
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                inputHandler._onKeyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                inputHandler._onKeyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                inputHandler._onKeyReleased(e);
            }
        });

        mainCanvas = new MainCanvas(renderer);
        renderer.setRepaintCallback(this::repaint);
        add(mainCanvas);
        renderer.imprint(1, 0);
    }

    public static class MainCanvas extends JPanel {
        private final Renderer renderer;

        public MainCanvas(Renderer renderer) {
            super(false);
            this.renderer = renderer;
            grabFocus();
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            renderer.onPaint((Graphics2D) g);
            setCursor(null);
        }
    }
}

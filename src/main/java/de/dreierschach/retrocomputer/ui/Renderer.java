package de.dreierschach.retrocomputer.ui;

import de.dreierschach.retrocomputer.config.GfxModeConfig;
import de.dreierschach.retrocomputer.config.VideoConfig;
import de.dreierschach.retrocomputer.ui.frame.RepaintCallback;
import org.apache.commons.lang3.exception.UncheckedException;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

@Component
public class Renderer {
    private final VideoConfig config;
    private Font gfxFont;
    private RepaintCallback repaintCallback = () -> {
    };

    private BufferedImage[] canvas;
    private int actualPage;
    private List<Color> gfxColors;

    private VideoMode videoMode = VideoMode.TEXT_GREEN;

    private char[][] textScreen;
    private double charWidth;
    private double charHeight;
    private Font textFont;
    private int cursor;
    private Renderer.CursorType cursorType = Renderer.CursorType.INSERT;
    private boolean arcadeMode;

    public Renderer(VideoConfig config) throws Exception {
        this.config = config;
        initVideoMode(VideoMode.HIRES);
        setVideoMode(VideoMode.TEXT_GREEN);
        clear();
    }


    public void setVideoMode(VideoMode videoMode) {
        initVideoMode(videoMode);
        this.videoMode = videoMode;
        this.arcadeMode = false;
        clear();
    }

    public boolean isTextMode() {
        return getVideoMode().isTextType();
    }

    public boolean isGfxMode() {
        return !getVideoMode().isTextType();
    }

    public boolean isArcadeMode() {
        return arcadeMode;
    }

    public void setArcadeMode(boolean arcadeMode) {
        this.arcadeMode = arcadeMode;
    }

    private void initVideoMode(VideoMode videoMode) throws UncheckedException {
        var config = modeConfig(videoMode);
        gfxColors = config.getColors().stream().map(c -> new Color(Integer.parseInt(c, 16))).toList();
        try {
            if (videoMode.isTextType()) {
                textFont = Font.createFont(Font.TRUETYPE_FONT, Renderer.class.getResourceAsStream(config.getFont()));
                textScreen = new char[2][config.getWidth() * config.getHeight()];
                return;
            }
            gfxFont = Font.createFont(Font.TRUETYPE_FONT, Renderer.class.getResourceAsStream(config.getFont())).deriveFont(config.getFontSize());
            canvas = new BufferedImage[]{new BufferedImage(config.getWidth(), config.getHeight(), BufferedImage.TYPE_INT_RGB),
                    new BufferedImage(config.getWidth(), config.getHeight(), BufferedImage.TYPE_INT_RGB)};
            actualPage = 0;
        } catch (Exception e) {
            throw new UncheckedException(e);
        }
    }

    public GfxModeConfig modeConfig(VideoMode videoMode) {
        return config.getModes().get(videoMode.getMode());
    }

    public GfxModeConfig modeConfig() {
        return config.getModes().get(videoMode.getMode());
    }

    public void setRepaintCallback(RepaintCallback repaintCallback) {
        this.repaintCallback = repaintCallback;
    }

    public void repaint() {
        if (!isArcadeMode()) {
            repaintCallback.repaint();
        }
    }

    public void flip() {
        if (!isArcadeMode()) {
            return;
        }
        actualPage = 1 - actualPage;
        repaintCallback.repaint();
        if (isGfxMode()) {
            var g2 = (Graphics2D) (canvas[1 - actualPage].getGraphics());
            g2.drawImage(canvas[actualPage], 0, 0, null);
        } else {
            System.arraycopy(textScreen[actualPage], 0, textScreen[1 - actualPage], 0, textScreen[actualPage].length);
        }
    }

    public VideoMode getVideoMode() {
        return videoMode;
    }

    public void clear() {
        if (videoMode.isTextType()) {
            clearText();
        } else {
            clearGfx();
        }
    }


    public void onPaint(Graphics2D g2) {
        if (videoMode.isTextType()) {
            onPaintText(g2);
            return;
        }
        onPaintGfx(g2);
    }

// gfx-mode

     BufferedImage image2draw() {
        return canvas[isArcadeMode() ? 1-actualPage: actualPage];
     }

    public void clearGfx() {
        var g2 = (Graphics2D) image2draw().getGraphics();
        g2.setColor(gfxColors.get(0));
        g2.fillRect(0, 0, modeConfig().getWidth(), modeConfig().getHeight());
        repaint();
    }

    public void setPoint(int x, int y, int color) {
        var g2 = (Graphics2D) image2draw().getGraphics();
        g2.setColor(gfxColors.get(color % gfxColors.size()));
        g2.fillRect(x, y, 1, 1);
        repaint();
    }

    public void drawLine(int x0, int y0, int x1, int y1, int color) {
        var g2 = (Graphics2D) image2draw().getGraphics();
        g2.setColor(gfxColors.get(color % gfxColors.size()));
        g2.drawLine(x0, y0, x1, y1);
        repaint();
    }

    public void drawEllipse(int x0, int y0, int x1, int y1, int color) {
        var g2 = (Graphics2D) image2draw().getGraphics();
        g2.setColor(gfxColors.get(color % gfxColors.size()));
        g2.drawOval(x0, y0, x1 - x0 + 1, y1 - y0 + 1);
        repaint();
    }

    public void drawFilledEllipse(int x0, int y0, int x1, int y1, int color) {
        var g2 = (Graphics2D) image2draw().getGraphics();
        g2.setColor(gfxColors.get(color % gfxColors.size()));
        g2.fillOval(x0, y0, x1 - x0 + 1, y1 - y0 + 1);
        repaint();
    }

    public void drawRect(int x0, int y0, int x1, int y1, int color) {
        var g2 = (Graphics2D) image2draw().getGraphics();
        g2.setColor(gfxColors.get(color % gfxColors.size()));
        g2.drawRect(x0, y0, x1 - x0 + 1, y1 - y0 + 1);
        repaint();
    }

    public void drawFilledRect(int x0, int y0, int x1, int y1, int color) {
        var g2 = (Graphics2D) image2draw().getGraphics();
        g2.setColor(gfxColors.get(color % gfxColors.size()));
        g2.fillRect(x0, y0, x1 - x0 + 1, y1 - y0 + 1);
        repaint();
    }

    public void drawText(String text, int x, int y, int color) {
        var g2 = (Graphics2D) image2draw().getGraphics();
        var asc = gfxFont.getLineMetrics(text, g2.getFontRenderContext()).getAscent();
        g2.setColor(gfxColors.get(color % gfxColors.size()));
        g2.setFont(gfxFont);
        g2.drawString(text, x, y + asc);
        repaint();
    }

    public void centerText(String text, int x, int y, int color) {
        var g2 = (Graphics2D) image2draw().getGraphics();
        var asc = gfxFont.getLineMetrics(text, g2.getFontRenderContext()).getAscent();
        var bounds = gfxFont.getStringBounds(text, g2.getFontRenderContext()).getBounds2D();
        var height = bounds.getHeight();
        var width = bounds.getWidth();
        g2.setColor(gfxColors.get(color % gfxColors.size()));
        g2.setFont(gfxFont);
        g2.drawString(text, (float) (x - width / 2), (float) (y - height / 2 + asc));
        repaint();
    }

    public void onPaintGfx(Graphics2D g2) {
        var config = modeConfig();
        g2.setBackground(new Color(Integer.parseInt(config.getFrameColor(), 16)));
        g2.clearRect(g2.getClipBounds().x, g2.getClipBounds().y, g2.getClipBounds().width, g2.getClipBounds().height);
        var zoom = calculateZoom(g2, config);
        var offsetx = (g2.getClipBounds().width - zoom * config.getWidth()) / 2;
        var offsety = (g2.getClipBounds().height - zoom * config.getHeight()) / 2;
        g2.drawImage(canvas[actualPage],
                (int) (g2.getClipBounds().x + offsetx),
                (int) (g2.getClipBounds().y + offsety),
                (int) (zoom * config.getWidth()),
                (int) (zoom * config.getHeight()),
                null
        );
    }

    public double calculateZoom(Graphics2D g2, GfxModeConfig config) {
        var zoomX = (double) g2.getClipBounds().width / (config.getWidth() + 2 * config.getFrameWidth());
        var zoomY = (double) g2.getClipBounds().height / (config.getHeight() + 2 * config.getFrameHeight());
        return Math.min(zoomX, zoomY);
    }

// text-Mode

    public char[] page2draw() {
        return textScreen[isArcadeMode() ? 1 - actualPage : actualPage];
    }

    public Renderer.CursorType getCursorType() {
        return cursorType;
    }

    public void setCursorType(Renderer.CursorType cursorType) {
        this.cursorType = cursorType;
    }

    public void clearText() {
        Arrays.fill(page2draw(), ' ');
        cursor = 0;
    }

    public void imprint() {
        clearText();
        println("PEANUT SOFTWARE TECHNOLOGIES (R)");
        println("BASIC VERSION 2.0");
        println();
        println("READY.");
    }

    public void print(String s) {
        for (int i = 0; i < s.length(); i++) {
            page2draw()[cursor] = s.charAt(i);
            moveRight();
        }
        repaint();
    }

    public void println(String s) {
        print(s);
        println();
    }

    public void scrollUp() {
        var config = modeConfig();
        for (int i = 0; i < page2draw().length - config.getWidth(); i++) {
            page2draw()[i] = page2draw()[i + config.getWidth()];
        }
        Arrays.fill(page2draw(), page2draw().length - config.getWidth(), page2draw().length, ' ');
        cursor -= config.getWidth();
        repaint();
    }

    public void scrollLeft() {
        var config = modeConfig();
        for (int i = 0; i < page2draw().length - 1; i++) {
            page2draw()[i] = page2draw()[i + 1];
        }
        for (int j = 0; j < config.getHeight(); j++) {
            page2draw()[(j + 1) * config.getWidth() - 1] = ' ';
        }
        repaint();
    }

    public void scrollRight() {
        var config = modeConfig();

        for (int i = page2draw().length - 1; i > 0; i--) {
            page2draw()[i] = page2draw()[i - 1];
        }
        for (int j = 0; j < config.getHeight(); j++) {
            page2draw()[j * config.getWidth()] = ' ';
        }
        repaint();
    }

    public int getCursor() {
        return cursor;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
        repaint();
    }

    public int getSize() {
        return page2draw().length;
    }

    public String get(int pos, int size) {
        if (pos >= page2draw().length) {
            return "";
        }
        var s = pos + size > page2draw().length ? page2draw().length - pos : size;
        return new String(Arrays.copyOfRange(page2draw(), pos, pos + s));
    }

    public void moveRight() {
        cursor = cursor + 1;
        if (cursor >= page2draw().length) {
            scrollUp();
        }
        repaint();
    }

    public void moveLeft() {
        if (cursor == 0) {
            return;
        }
        cursor = cursor - 1;
        repaint();
    }

    public void deleteAtCursor(int size) {
        for (int i = 0; i < size - 1; i++) {
            page2draw()[cursor + i] = page2draw()[cursor + i + 1];
        }
        page2draw()[cursor + size - 1] = ' ';
        repaint();
    }

    public void insertAtCursor(char c, int size) {
        for (int i = size; i > 0; i--) {
            page2draw()[cursor + i] = page2draw()[cursor + i - 1];
        }
        page2draw()[cursor] = c;
        cursor++;
        repaint();
    }

    public void newlineIfNeeded() {
        if (cursor % modeConfig().getWidth() > 0) {
            println();
        }
    }

    public void println() {
        var config = modeConfig();

        var line = cursor - cursor % config.getWidth();
        cursor = line + config.getWidth();
        if (line + config.getWidth() < page2draw().length) {
            repaint();
            return;
        }
        scrollUp();
        repaint();
    }

    public void onPaintText(Graphics2D g2) {
        var config = modeConfig();

        var f = scaleTextFont(g2, config);
        g2.setFont(f);
        g2.setColor(new Color(Integer.parseInt(config.getFrameColor(), 16)));
        g2.fillRect(g2.getClipBounds().x, g2.getClipBounds().y, g2.getClipBounds().width, g2.getClipBounds().height);

        var width = (int) (config.getWidth() * charWidth);
        var height = (int) (config.getHeight() * charHeight);
        var offsetX = (int) (config.getFrameWidth() * charWidth);
        var offsetY = (int) (config.getFrameHeight() * charHeight);
        offsetX += (g2.getClipBounds().width - 2 * offsetX - width) / 2;
        offsetY += (g2.getClipBounds().height - 2 * offsetY - height) / 2;
        g2.setColor(gfxColors.get(0));
        g2.fillRect(offsetX, offsetY, width, height);

        g2.setColor(gfxColors.get(1));
        for (int j = 0; j < config.getHeight(); j++) {
            for (int i = 0; i < config.getWidth(); i++) {
                var c = textScreen[actualPage][j * config.getWidth() + i] + "";
                g2.drawString(c, (int) (charWidth * i + offsetX), (int) (charHeight * j + offsetY + f.getLineMetrics(c, g2.getFontRenderContext()).getAscent()));
            }
        }
        var px = (int) ((cursor % config.getWidth()) * charWidth + offsetX);
        var py = (int) ((cursor / config.getWidth()) * charHeight + offsetY);
        switch (cursorType) {
            case INSERT -> g2.drawLine(px, py, px, py + (int) charHeight);
            case OVERWRITE ->
                    g2.drawLine(px, py + (int) charHeight - 1, px + (int) charWidth, py + (int) charHeight - 1);
        }
    }

    private Font scaleTextFont(Graphics2D g2, GfxModeConfig config) {
        charWidth = (double) g2.getClipBounds().width / (config.getWidth() + 2 * config.getFrameWidth());
        charHeight = (double) g2.getClipBounds().height / (config.getHeight() + 2 * config.getFrameHeight());
        var metrics = textFont.getStringBounds("Q", g2.getFontRenderContext()).getBounds2D();
        var w = metrics.getWidth() * 0.7;
        var h = metrics.getHeight();
        var fx = charWidth / w;
        var fy = charHeight / h;
        float f;
        if (fx < fy) {
            f = (float) fx;
            charHeight = f * h;
        } else {
            f = (float) fy;
            charWidth = f * w;
        }
        return textFont.deriveFont(textFont.getSize2D() * f);
    }

    public enum CursorType {
        INVISIBLE, INSERT, OVERWRITE
    }
}

package de.dreierschach.retrocomputer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.List;

@ConfigurationProperties("video")
public class VideoConfig {
    private int width = 800;
    private int height = 600;
    private boolean fullscreen = false;

    @NestedConfigurationProperty
    private List<GfxModeConfig> modes;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isFullscreen() {
        return fullscreen;
    }

    public void setFullscreen(boolean fullscreen) {
        this.fullscreen = fullscreen;
    }

    public List<GfxModeConfig> getModes() {
        return modes;
    }

    public void setModes(List<GfxModeConfig> gfxmode) {
        this.modes = gfxmode;
    }
}

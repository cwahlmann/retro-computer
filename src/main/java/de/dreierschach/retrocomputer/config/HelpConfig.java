package de.dreierschach.retrocomputer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties("help")
public class HelpConfig {

    private Map<String, HelpItem> topics;

    public Map<String, HelpItem> getTopics() {
        return topics;
    }

    public void setTopics(Map<String, HelpItem> topics) {
        this.topics = topics;
    }

    public record HelpItem(String syntax, String example, String description) {
    }
}

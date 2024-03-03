package de.dreierschach.retrocomputer.context;

import de.dreierschach.retrocomputer.config.VideoConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({VideoConfig.class})
public class RetroComputerContext {
}

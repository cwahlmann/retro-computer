package de.dreierschach.retrocomputer.context;

import de.dreierschach.retrocomputer.config.HelpConfig;
import de.dreierschach.retrocomputer.config.VideoConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

@Configuration
@EnableConfigurationProperties({VideoConfig.class, HelpConfig.class})
public class RetroComputerContext {
}

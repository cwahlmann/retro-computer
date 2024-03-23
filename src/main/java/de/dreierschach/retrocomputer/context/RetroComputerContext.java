package de.dreierschach.retrocomputer.context;

import de.dreierschach.retrocomputer.BasicListener;
import de.dreierschach.retrocomputer.DelegateProxy;
import de.dreierschach.retrocomputer.basic.*;
import de.dreierschach.retrocomputer.config.HelpConfig;
import de.dreierschach.retrocomputer.config.VideoConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableConfigurationProperties({VideoConfig.class, HelpConfig.class})
public class RetroComputerContext {
    @Bean("basicListenerProxy")
    public BasicListener basicListenerProxy(BasicListenerCommon common, BasicListenerControlFlow controlFlow,
                                            BasicListenerExpressions expressions, BasicListenerIo io,
                                            BasicListenerUi ui) {
        return DelegateProxy.instance(BasicListener.class, List.of(common, controlFlow, expressions, io, ui));
    }
}

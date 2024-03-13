package de.dreierschach.retrocomputer;

import de.dreierschach.retrocomputer.config.VideoConfig;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;

@Component("vsyncTimer")
public class VsyncTimer {
    private CompletableFuture<Boolean> vsyncFlag;

    public VsyncTimer(VideoConfig videoConfig) {
        vsyncFlag = new CompletableFuture<>();
        var timer = new Timer();
        timer.scheduleAtFixedRate(
                new TimerTask() {
                    @Override
                    public void run() {
                        vsyncFlag.complete(true);
                    }
                }
                , 0L, (long) (1000 / videoConfig.getVsync()));
    }

    public void await() {
        vsyncFlag.join();
        vsyncFlag = new CompletableFuture<>();
    }
}

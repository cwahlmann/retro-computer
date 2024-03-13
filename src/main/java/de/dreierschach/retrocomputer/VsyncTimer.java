package de.dreierschach.retrocomputer;

import de.dreierschach.retrocomputer.config.VideoConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Component("vsyncTimer")
public class VsyncTimer {
    private static final Logger log = LoggerFactory.getLogger(VsyncTimer.class);
    private CountDownLatch vsyncFlag;
    private int ticks;

    public VsyncTimer(VideoConfig videoConfig) {
        ticks = 1;
        vsyncFlag = new CountDownLatch(ticks);
        var timer = new Timer();
        timer.scheduleAtFixedRate(
                new TimerTask() {
                    @Override
                    public void run() {
                        vsyncFlag.countDown();
                        ;
                    }
                }
                , 0L, (long) (1000 / videoConfig.getVsync()));
    }

    public void await() {
        try {
            vsyncFlag.await(1200, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            log.warn("Await vsync interrupter", e);
            Thread.currentThread().interrupt();
        }
        reset();
    }

    public void setTicks(int ticks) {
        this.ticks = ticks;
    }

    public void reset() {
        vsyncFlag = new CountDownLatch(ticks);
    }
}

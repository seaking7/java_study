package com.springtour.example.ch11schedule.schedule;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ScheduledTask {

    private AtomicInteger atomicInteger = new AtomicInteger();

    //    @Scheduled(fixedRate = 1000L)
    //    @Scheduled(cron = "0/10 * * * * ?")
    @Scheduled(fixedRate= 1000)
    public void triggerEvent() {
        int i = atomicInteger.addAndGet(1);
        log.info("Triggered Event : #{}", i);
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

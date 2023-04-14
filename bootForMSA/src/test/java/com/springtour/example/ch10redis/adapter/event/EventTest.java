package com.springtour.example.ch10redis.adapter.event;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EventTest {

    @Autowired
    private EventPublisher eventPublisher;

    @Test
    public void testPubSub() throws InterruptedException {
        eventPublisher.sendMessage(new EventMessage("test"));
        TimeUnit.SECONDS.sleep(3);
    }
}

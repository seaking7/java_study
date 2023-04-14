package com.springtour.example.ch10redis.adapter.event;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EventPublisher {

    private final RedisTemplate<String, String> eventRedisTemplate;
    private final ChannelTopic eventTopic;

    public EventPublisher(RedisTemplate<String, String> eventRedisTemplate, ChannelTopic eventTopic) {
        this.eventRedisTemplate = eventRedisTemplate;
        this.eventTopic = eventTopic;
    }

    public void sendMessage(EventMessage eventMessage) {
        eventRedisTemplate.convertAndSend(eventTopic.getTopic(), eventMessage);
    }
}

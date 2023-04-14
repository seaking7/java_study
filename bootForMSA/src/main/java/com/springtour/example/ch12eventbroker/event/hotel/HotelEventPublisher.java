package com.springtour.example.ch12eventbroker.event.hotel;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HotelEventPublisher {

    private ApplicationEventPublisher applicationEventPublisher;

    public HotelEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishHotelCreated(Long hotelId, String address) {
        HotelCreateEvent event = HotelCreateEvent.of(hotelId, address);
        log.info("Publish hotel created event.");
        applicationEventPublisher.publishEvent(event);
    }

}

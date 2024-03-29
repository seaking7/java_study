package com.springtour.example.ch12eventbroker.event.hotel;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.springtour.example.ch12eventbroker.service.PropagationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HotelEventListener {

    private PropagationService propagationService;

    public HotelEventListener(PropagationService propagationService) {
        this.propagationService = propagationService;
    }

    @Async
    @Order(1)
    @EventListener(value = HotelCreateEvent.class)
    public void handleHotelCreateEvent(HotelCreateEvent hotelCreateEvent) {
        log.info("handle HotelCreatedEvent : {}", hotelCreateEvent);
        propagationService.propagateHotelEvent();

    }

    @Async
    @Order(2)
    @EventListener(value = HotelCreateEvent.class)
    public void handleResourceCreateEvent(HotelCreateEvent hotelCreateEvent) {
        log.info("handle resourceCreatedEvent : {}", hotelCreateEvent);
        propagationService.propagateResourceEvent();
    }
}

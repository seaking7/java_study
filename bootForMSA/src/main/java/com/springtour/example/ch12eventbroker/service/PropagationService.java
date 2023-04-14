package com.springtour.example.ch12eventbroker.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PropagationService {

    public void propagateHotelEvent() {
        log.info("propagation of hotel event");
    }

    public void propagateResourceEvent() {
        log.info("propagation of resource event");
    }
}

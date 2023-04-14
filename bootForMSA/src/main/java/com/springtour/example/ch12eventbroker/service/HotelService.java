package com.springtour.example.ch12eventbroker.service;

import org.springframework.stereotype.Service;

import com.springtour.example.ch12eventbroker.event.hotel.HotelEventPublisher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HotelService {

    private final HotelEventPublisher hotelEventPublisher;

    public HotelService(HotelEventPublisher hotelEventPublisher) {
        this.hotelEventPublisher = hotelEventPublisher;
    }

    public Boolean createHotel(String hotelName, String hotelAddress) {
        // 호텔 생성 로직 생략
        log.info("created hotel. {}, {}", hotelName, hotelAddress);
        hotelEventPublisher.publishHotelCreated(999111222L, hotelAddress);
        log.info("done create hotel");
        return Boolean.TRUE;
    }
}

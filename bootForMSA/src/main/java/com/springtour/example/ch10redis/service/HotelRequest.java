package com.springtour.example.ch10redis.service;

import org.springframework.cache.annotation.Cacheable;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Cacheable
public class HotelRequest {
    private Long hotelId;

    public HotelRequest(Long hotelId) {
        this.hotelId = hotelId;
    }
}

package com.springtour.example.ch07test.controller;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class HotelRequest {
    private String hotelName;

    public HotelRequest() {
    }

    public HotelRequest(String hotelName) {
        this.hotelName = hotelName;
    }
}

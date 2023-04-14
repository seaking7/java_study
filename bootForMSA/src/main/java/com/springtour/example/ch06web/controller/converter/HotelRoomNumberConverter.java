package com.springtour.example.ch06web.controller.converter;

import org.springframework.core.convert.converter.Converter;

import com.springtour.example.ch06web.domain.HotelRoomNumber;

public class HotelRoomNumberConverter implements Converter<String, HotelRoomNumber> {

    @Override
    public HotelRoomNumber convert(String source) {
        return HotelRoomNumber.parse(source);
    }
}

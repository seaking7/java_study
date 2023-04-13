package com.springtour.example.chapter06.controller.converter;

import org.springframework.core.convert.converter.Converter;

import com.springtour.example.chapter06.domain.HotelRoomNumber;

public class HotelRoomNumberConverter implements Converter<String, HotelRoomNumber> {

    @Override
    public HotelRoomNumber convert(String source) {
        return HotelRoomNumber.parse(source);
    }
}

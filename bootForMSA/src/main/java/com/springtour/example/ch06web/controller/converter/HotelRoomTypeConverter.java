package com.springtour.example.ch06web.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.springtour.example.ch06web.controller.HotelRoomType;

@Component
public class HotelRoomTypeConverter implements Converter<String, HotelRoomType> {

    @Override
    public HotelRoomType convert(String source) {
        return HotelRoomType.fromParam(source);
    }
}

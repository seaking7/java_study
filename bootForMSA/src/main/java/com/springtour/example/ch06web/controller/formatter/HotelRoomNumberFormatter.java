package com.springtour.example.ch06web.controller.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.springtour.example.ch06web.domain.HotelRoomNumber;

//@Component
public class HotelRoomNumberFormatter implements Formatter<HotelRoomNumber> {

    @Override
    public HotelRoomNumber parse(String text, Locale locale) throws ParseException {
        return HotelRoomNumber.parse(text);
    }

    @Override
    public String print(HotelRoomNumber hotelRoomNumber, Locale locale) {
        return hotelRoomNumber.toString();
    }
}

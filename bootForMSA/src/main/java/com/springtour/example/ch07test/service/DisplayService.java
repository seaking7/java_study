package com.springtour.example.ch07test.service;

import java.util.List;

import com.springtour.example.ch07test.controller.HotelRequest;
import com.springtour.example.ch07test.controller.HotelResponse;

public interface DisplayService {

    List<HotelResponse> getHotelsByName(HotelRequest hotelRequest);
}

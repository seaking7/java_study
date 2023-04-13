package com.springtour.example.chapter07.service;

import java.util.List;

import com.springtour.example.chapter07.controller.HotelRequest;
import com.springtour.example.chapter07.controller.HotelResponse;

public interface DisplayService {

    List<HotelResponse> getHotelsByName(HotelRequest hotelRequest);
}

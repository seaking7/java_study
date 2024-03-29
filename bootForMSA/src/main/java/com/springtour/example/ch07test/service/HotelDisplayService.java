package com.springtour.example.ch07test.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.springtour.example.ch07test.aspect.ElapseLoggable;
import com.springtour.example.ch07test.controller.HotelRequest;
import com.springtour.example.ch07test.controller.HotelResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HotelDisplayService implements DisplayService {

    @Override
    @ElapseLoggable
    public List<HotelResponse> getHotelsByName(HotelRequest hotelRequest) {

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            log.error("error", e);
        }

        return List.of(
                new HotelResponse(1000L,
                        "Ragged Point Inn",
                        "18091 CA-1, San Simeon, CA 93452",
                        "+18885846374"
                )
        );
    }
}

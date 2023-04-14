package com.springtour.example.ch07test.service;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.springtour.example.ch07test.controller.HotelRoomResponse;
import com.springtour.example.ch07test.domain.HotelRoomEntity;
import com.springtour.example.ch07test.repository.HotelRoomRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HotelRoomDisplayService {

    private final HotelRoomRepository hotelRoomRepository;
    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public HotelRoomDisplayService(HotelRoomRepository hotelRoomRepository,
                                   ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        this.hotelRoomRepository = hotelRoomRepository;
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
    }

    public HotelRoomResponse getHotelRoomById(Long id) {
        HotelRoomEntity hotelRoomEntity = hotelRoomRepository.findById(id);
        threadPoolTaskExecutor.execute(() -> log.warn("entity :{}", hotelRoomEntity.toString()));
        return HotelRoomResponse.from(hotelRoomEntity);
    }
}

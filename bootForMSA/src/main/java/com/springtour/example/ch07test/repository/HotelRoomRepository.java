package com.springtour.example.ch07test.repository;

import org.springframework.stereotype.Repository;

import com.springtour.example.ch07test.domain.HotelRoomEntity;

@Repository
public class HotelRoomRepository {

    public HotelRoomEntity findById(Long id) {
        return new HotelRoomEntity(id, "EAST-1902", 19, 2, 1);
    }
}

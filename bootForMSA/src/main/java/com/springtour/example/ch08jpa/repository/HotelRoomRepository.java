package com.springtour.example.ch08jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springtour.example.ch08jpa.domain.HotelRoomEntity;

@Repository
public interface HotelRoomRepository extends JpaRepository<HotelRoomEntity, Long> {

    List<HotelRoomEntity> findByHotelId(Long hotelId);

}

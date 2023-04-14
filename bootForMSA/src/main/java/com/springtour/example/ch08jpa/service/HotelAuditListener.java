package com.springtour.example.ch08jpa.service;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

import com.springtour.example.ch08jpa.domain.HotelEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HotelAuditListener {

    @PostPersist
    public void logWhenCreated(HotelEntity hotelEntity){
        log.info("hotel created. id:{}", hotelEntity.getHotelId());
    }

    @PostUpdate
    @PostRemove
    public void logWhenChanged(HotelEntity hotelEntity) {
        log.info("hotel changed. id:{}, name:{}", hotelEntity.getHotelId(), hotelEntity.getName());
    }
}

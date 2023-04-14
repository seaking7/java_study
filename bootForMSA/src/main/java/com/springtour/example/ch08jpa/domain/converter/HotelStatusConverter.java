package com.springtour.example.ch08jpa.domain.converter;

import java.util.Objects;

import javax.persistence.AttributeConverter;

import com.springtour.example.ch08jpa.domain.HotelStatus;

public class HotelStatusConverter implements AttributeConverter<HotelStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(HotelStatus attribute) {
        if (Objects.isNull(attribute))
            return null;

        return attribute.getValue();
    }

    @Override
    public HotelStatus convertToEntityAttribute(Integer dbData) {

        if (Objects.isNull(dbData))
            return null;

        return HotelStatus.fromValue(dbData);
    }
}

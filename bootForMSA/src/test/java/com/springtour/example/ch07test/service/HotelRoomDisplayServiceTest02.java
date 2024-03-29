package com.springtour.example.ch07test.service;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springtour.example.ch07test.controller.HotelRoomResponse;
import com.springtour.example.ch07test.domain.HotelRoomEntity;
import com.springtour.example.ch07test.repository.HotelRoomRepository;

@SpringBootTest
public class HotelRoomDisplayServiceTest02 {

    @Autowired
    private HotelRoomDisplayService hotelRoomDisplayService;

    @MockBean
    private HotelRoomRepository hotelRoomRepository;

    @Test
    public void testMockBean() {

        given(this.hotelRoomRepository.findById(any()))
                .willReturn(new HotelRoomEntity(10L, "test", 1, 1, 1));

        HotelRoomResponse hotelRoomResponse = hotelRoomDisplayService.getHotelRoomById(1L);

        Assertions.assertNotNull(hotelRoomResponse);
        Assertions.assertEquals(10L, hotelRoomResponse.getHotelRoomId());
    }
}

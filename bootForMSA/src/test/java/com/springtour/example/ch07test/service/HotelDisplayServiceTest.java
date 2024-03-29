package com.springtour.example.ch07test.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.springtour.example.ch07test.controller.HotelRequest;
import com.springtour.example.ch07test.controller.HotelResponse;

@SpringBootTest
class HotelDisplayServiceTest {

    private final HotelDisplayService hotelDisplayService;
    private final ApplicationContext applicationContext;

    @Autowired
    public HotelDisplayServiceTest(HotelDisplayService hotelDisplayService,
                                   ApplicationContext applicationContext) {
        this.hotelDisplayService = hotelDisplayService;
        this.applicationContext = applicationContext;
    }

    @Test
    public void testReturnOneHotelWhenRequestIsHotelName() {

        // Given
        HotelRequest hotelRequest = new HotelRequest("Line hotel");
        // When
        List<HotelResponse> hotelResponses = hotelDisplayService.getHotelsByName(hotelRequest);
        // Then
        Assertions.assertNotNull(hotelResponses);
        Assertions.assertEquals(1, hotelResponses.size());
    }

    @Test
    public void testApplicationContext() {
        DisplayService displayService = applicationContext.getBean(DisplayService.class);

        Assertions.assertNotNull(displayService);
        Assertions.assertTrue(HotelDisplayService.class.isInstance(displayService));
    }

}

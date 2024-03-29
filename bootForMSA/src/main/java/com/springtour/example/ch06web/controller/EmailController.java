package com.springtour.example.ch06web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springtour.example.ch06web.domain.email.EmailAddress;
import com.springtour.example.ch06web.domain.email.EmailService;

@Controller
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping(path = "/hotels/{hotelId}/rooms/{roomNumber}/reservations/{reservationId}/send-email")
    public ResponseEntity<Void> sendEmailByReservation(
            @PathVariable Long hotelId,
            @PathVariable String roomNumber,
            @PathVariable Long reservationId) {

        emailService.sendEmail(
                new EmailAddress("Byungboo Kim", "byungboor", "naver.com")
        );

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

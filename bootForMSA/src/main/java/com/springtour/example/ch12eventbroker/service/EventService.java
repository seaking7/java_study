package com.springtour.example.ch12eventbroker.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EventService {

    public void sendEventMail(String emailAddress) {
        // 이메일 발송 로직
        log.info("Send Email attached welcome coupons. {}", emailAddress);
    }
}

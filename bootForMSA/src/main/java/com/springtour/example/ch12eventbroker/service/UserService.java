package com.springtour.example.ch12eventbroker.service;

import org.springframework.stereotype.Service;

import com.springtour.example.ch12eventbroker.event.user.UserEventPublisher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

    private final UserEventPublisher userEventPublisher;

    public UserService(UserEventPublisher userEventPublisher) {
        this.userEventPublisher = userEventPublisher;
    }

    public Boolean createUser(String userName, String emailAddress) {
        // 사용자 생성 로직 생략
        log.info("created user. {}, {}", userName, emailAddress);
        userEventPublisher.publishUserCreated(1239876L, emailAddress);
        log.info("done create user");
        return Boolean.TRUE;
    }
}

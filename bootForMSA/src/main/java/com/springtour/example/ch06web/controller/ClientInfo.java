package com.springtour.example.ch06web.controller;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ClientInfo {

    private final String channel;
    private final String clientAddress;

    public ClientInfo(String channel, String clientAddress) {
        this.channel = channel;
        this.clientAddress = clientAddress;
    }
}

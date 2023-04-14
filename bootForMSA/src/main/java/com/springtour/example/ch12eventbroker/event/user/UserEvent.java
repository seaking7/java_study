package com.springtour.example.ch12eventbroker.event.user;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class UserEvent extends ApplicationEvent {

    private Type type;
    private Long userId;
    private String emailAddress;

    private UserEvent(Object source, Type type, Long userId, String emailAddress) {
        super(source);
        this.type = type;
        this.userId = userId;
        this.emailAddress = emailAddress;
    }

    public static UserEvent created(Object source, Long userId, String emailAddress) {
        return new UserEvent(source, Type.CREATE, userId, emailAddress);
    }

    public enum Type {
        CREATE, DELETE
    }
}

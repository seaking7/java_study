package com.springtour.example.ch06web.domain.email;

import java.util.Objects;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EmailAddress {

    private static final String AT = "@";

    private String name;
    private String domainPart;
    private String localPart;

    public EmailAddress(String name, String localPart, String domainPart) {
        this.name = name;
        this.domainPart = domainPart;
        this.localPart = localPart;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (Objects.nonNull(name))
            sb.append(name).append(" ");

        return sb.append("<").append(localPart).append(AT).append(domainPart).append(">").toString();
    }
}

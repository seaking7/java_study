package com.springtour.example.ch09restapi.controller;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateCodeResponse {

    private List<Long> codes;

    public static CreateCodeResponse of(List<Long> codes) {
        CreateCodeResponse response = new CreateCodeResponse();
        response.codes = codes;
        return response;
    }
}

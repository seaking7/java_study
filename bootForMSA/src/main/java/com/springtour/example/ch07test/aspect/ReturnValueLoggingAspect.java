package com.springtour.example.ch07test.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springtour.example.ch07test.controller.HotelResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
@Order(1)
public class ReturnValueLoggingAspect {

    @AfterReturning(pointcut = "execution(* getHotelsByName(..))", returning = "retVals")
    public void printReturnObject(JoinPoint joinPoint, List<HotelResponse> retVals) throws Throwable {
        retVals.stream()
                .forEach(response -> log.info("return value : {}", response));
    }

    @AfterThrowing(pointcut = "execution(* getHotelsByName(..))", throwing = "th")
    public void printThrowable(JoinPoint joinPoint, Throwable th) throws Throwable {
        log.error("error processing", th);
    }

}

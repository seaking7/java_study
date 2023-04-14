package com.springtour.example.ch06web.server;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoggingFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws
        IOException,
        ServletException {
        System.out.println("선처리 작업");
        filterChain.doFilter(request, response);
        System.out.println("후처리 작업");

    }
}

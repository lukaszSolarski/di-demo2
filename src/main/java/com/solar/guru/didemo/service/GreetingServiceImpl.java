package com.solar.guru.didemo.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    public static final String HELLO_CONTENT = "Hello, this is your " + GreetingServiceImpl.class.getName();

    @Override
    public String sayHello() {
        return HELLO_CONTENT;
    }
}

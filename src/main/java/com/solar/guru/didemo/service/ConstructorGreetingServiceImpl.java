package com.solar.guru.didemo.service;

import org.springframework.stereotype.Service;

@Service
public class ConstructorGreetingServiceImpl implements GreetingService {

    public static final String HELLO_CONTENT = "Hello, this is your " + ConstructorGreetingServiceImpl.class.getName();

    @Override
    public String sayHello() {
        return HELLO_CONTENT;
    }
}

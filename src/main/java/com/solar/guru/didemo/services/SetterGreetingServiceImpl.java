package com.solar.guru.didemo.services;

import org.springframework.stereotype.Service;

@Service
public class SetterGreetingServiceImpl implements GreetingService {

    public static final String HELLO_CONTENT = "Hello, this is your " + SetterGreetingServiceImpl.class.getName();

    @Override
    public String sayHello() {
        return HELLO_CONTENT;
    }
}

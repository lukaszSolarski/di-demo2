package com.solar.guru.didemo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PrimaryGreetingServiceImpl implements GreetingService {

    private final String HELLO = "Hello, this is your ".concat(PrimaryGreetingServiceImpl.class.getName());

    @Override
    public String sayHello() {
        return HELLO;
    }
}

package com.solar.guru.didemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile({"default", "en"})
public class PrimaryGreetingServiceImpl implements GreetingService {

    private final String HELLO = "Hello, this is your ".concat(PrimaryGreetingServiceImpl.class.getName());

    @Override
    public String sayHello() {
        return HELLO;
    }
}

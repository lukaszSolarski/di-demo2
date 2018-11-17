package com.solar.guru.didemo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile("pl")
public class PrimaryPolishGreetingServiceImpl implements GreetingService {

    private final String HELLO = "Cześć, tu twój: ".concat(PrimaryPolishGreetingServiceImpl.class.getName());

    @Override
    public String sayHello() {
        return HELLO;
    }
}

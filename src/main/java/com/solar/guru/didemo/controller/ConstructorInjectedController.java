package com.solar.guru.didemo.controller;

import com.solar.guru.didemo.service.ConstructorGreetingServiceImpl;
import com.solar.guru.didemo.service.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {
    private GreetingService greetingService;


    public ConstructorInjectedController(@Qualifier("constructorGreetingServiceImpl") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return this.greetingService.sayHello();
    }
}

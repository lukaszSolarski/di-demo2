package com.solar.guru.didemo.controllers;

import com.solar.guru.didemo.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

    private GreetingService greetingService;

    public HelloController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String hello() {
        return greetingService.sayHello();
    }
}

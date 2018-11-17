package com.solar.guru.didemo.controller;

import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
    public void hello() {
        System.out.println("Hello, this is your first controller created using DI in Spring! Good Job!\nYou didn't have to put 'new' operator!");
    }
}

package com.solar.guru.didemo;

import com.solar.guru.didemo.controller.ConstructorInjectedController;
import com.solar.guru.didemo.controller.HelloController;
import com.solar.guru.didemo.controller.PropertyInjectedController;
import com.solar.guru.didemo.controller.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(DiDemoApplication.class, args);
        HelloController helloController = context.getBean(HelloController.class);
        helloController.hello();

        System.out.println(context.getBean(PropertyInjectedController.class).sayHello());
        System.out.println(context.getBean(SetterInjectedController.class).sayHello());
        System.out.println(context.getBean(ConstructorInjectedController.class).sayHello());
    }

}

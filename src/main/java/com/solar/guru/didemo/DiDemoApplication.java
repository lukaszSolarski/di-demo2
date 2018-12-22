package com.solar.guru.didemo;

import com.solar.guru.didemo.controller.ConstructorInjectedController;
import com.solar.guru.didemo.controller.HelloController;
import com.solar.guru.didemo.controller.PropertyInjectedController;
import com.solar.guru.didemo.controller.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


/*
@SpringBootApplication specifies main class, but also specifies that default Component Scanning will be performed
on the package where this class is localized. So, in this case it automatically adds annotation:
@ComponentScan(basePackages = "com.solar.guru.didemo")
This declaration says that the specified package and all packages laying down this package will be scanned for finding
the Spring Components
 */
@SpringBootApplication

public class DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(DiDemoApplication.class, args);
        HelloController helloController = context.getBean(HelloController.class);

        System.out.println(helloController.hello());
        System.out.println(context.getBean(PropertyInjectedController.class).sayHello());
        System.out.println(context.getBean(SetterInjectedController.class).sayHello());
        System.out.println(context.getBean(ConstructorInjectedController.class).sayHello());
    }

}

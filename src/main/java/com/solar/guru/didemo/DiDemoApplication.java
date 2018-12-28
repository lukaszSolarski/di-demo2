package com.solar.guru.didemo;

import com.solar.guru.didemo.controllers.ConstructorInjectedController;
import com.solar.guru.didemo.controllers.HelloController;
import com.solar.guru.didemo.controllers.PropertyInjectedController;
import com.solar.guru.didemo.controllers.SetterInjectedController;
import com.solar.guru.didemo.examplebeans.FakeDataSource;
import com.solar.guru.didemo.examplebeans.FakeDataSourceFromEnv;
import com.solar.guru.didemo.examplebeans.SecondFakeDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


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
        System.out.println("\nExternal properties - Property Source (from external file): ");
        FakeDataSource fakeDataSource = context.getBean(FakeDataSource.class);
        System.out.println("Data source from file: username: " + fakeDataSource.getUsername() +
                ", pass: " + fakeDataSource.getPassword());
        SecondFakeDataSource secondFakeDataSource = context.getBean(SecondFakeDataSource.class);
        System.out.println("Data source from second file: username: " + secondFakeDataSource.getUsername() +
                ", pass: " + secondFakeDataSource.getPassword());
        FakeDataSourceFromEnv fakeDataSourceFromEnv = context.getBean(FakeDataSourceFromEnv.class);
        System.out.println("Data source from file and from env: username: " + fakeDataSourceFromEnv.getUsername() +
                ", pass: " + fakeDataSourceFromEnv.getPassword());
    }
}

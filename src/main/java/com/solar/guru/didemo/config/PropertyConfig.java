package com.solar.guru.didemo.config;

import com.solar.guru.didemo.examplebeans.FakeDataSource;
import com.solar.guru.didemo.examplebeans.SecondFakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/*
There are 2 ways to specify more than one Source Property. One of them is commented, but both will work fine.
 */
@Configuration
//@PropertySource({"classpath:fakedatasource.properties", "classpath:secondfakedatasource.properties"})
@PropertySources({
        @PropertySource("classpath:fakedatasource.properties"),
        @PropertySource("classpath:secondfakedatasource.properties")
})
public class PropertyConfig {

    @Value("${solar.username}")
    private String username;

    @Value("${solar.password}")
    private String password;

    @Value("${solar.second.username}")
    private String secondUsername;

    @Value("${solar.second.password}")
    private String secondPassword;

    @Bean
    public FakeDataSource getFakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        return fakeDataSource;
    }

    @Bean
    public SecondFakeDataSource getSecondFakeDataSource() {
        SecondFakeDataSource secondFakeDataSource = new SecondFakeDataSource();
        secondFakeDataSource.setUsername(secondUsername);
        secondFakeDataSource.setPassword(secondPassword);
        return secondFakeDataSource;
    }
    /*
    This method seems to be unnecessary in this application, because it uses Spring Boot and Spring Boot is
    auto-configuring one. But in a non spring boot application you need to create such a bean.
    Here's a quote from @PropertySource JavaDoc:
    In order to resolve ${...} placeholders in <bean> definitions or @Value annotations using properties from
    a PropertySource, one must register a PropertySourcesPlaceholderConfigurer. This happens automatically when using
    <context:property-placeholder> in XML, but must be explicitly registered using a static @Bean method when using
    @Configuration classes.
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}

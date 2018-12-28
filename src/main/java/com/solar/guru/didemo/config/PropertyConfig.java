package com.solar.guru.didemo.config;

import com.solar.guru.didemo.examplebeans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

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

    @Autowired
    private Environment env;

    @Value("${solar.username}")
    private String username;

    @Value("${solar.password}")
    private String password;

    @Value("${solar.second.username}")
    private String secondUsername;

    @Value("${solar.second.password}")
    private String secondPassword;

    @Value("${solar.third.username}")
    private String usernameFromDefaultAppProp;

    @Value("${solar.forth.username}")
    private String usernameFromYAML;
    /*
    The 'username' variable will be overrode, when you create in Environment the environment variable called "SOLAR_USERNAME"
     */
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

    @Bean
    public FakeDataSourceFromDefaultAppProp getFakeDataSourceFromDefaultAppProp() {
        FakeDataSourceFromDefaultAppProp fakeDataSourceFromDefaultAppProp = new FakeDataSourceFromDefaultAppProp();
        fakeDataSourceFromDefaultAppProp.setUsername(usernameFromDefaultAppProp);
        return fakeDataSourceFromDefaultAppProp;
    }
    /*
    When you create in Environment the environment variable called "MYSPECIFIC_USERNAME", the 'username' will become
    from that variable
    Password will be null;
     */
    @Bean
    public FakeDataSourceFromEnv getFakeDataSourceFromEnv() {
        FakeDataSourceFromEnv fakeDataSourceFromEnv = new FakeDataSourceFromEnv();
        fakeDataSourceFromEnv.setUsername(env.getProperty("MYSPECIFIC_USERNAME"));
        return  fakeDataSourceFromEnv;
    }

    @Bean
    public FakeDataSourceFromYAML getFakeDataSourceFromYAML() {
        FakeDataSourceFromYAML fakeDataSourceFromYAML = new FakeDataSourceFromYAML();
        fakeDataSourceFromYAML.setUsername(usernameFromYAML);
        return fakeDataSourceFromYAML;
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

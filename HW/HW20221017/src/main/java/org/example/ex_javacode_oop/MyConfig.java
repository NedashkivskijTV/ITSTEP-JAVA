package org.example.ex_javacode_oop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:myApp.properties")
public class MyConfig {

    @Bean
    public Address address(){
        return new Address();
    }

    @Bean
    public User user(){
        return new User(address());
    }
}

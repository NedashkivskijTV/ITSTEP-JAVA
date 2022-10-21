package org.example.ex13;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public Pet cat(){
        System.out.println("catBean");
        return new Cat();
    }

//    @Bean
//    public Person person(){
//        System.out.println("personBean");
//        return new Person(cat());
//    }


}

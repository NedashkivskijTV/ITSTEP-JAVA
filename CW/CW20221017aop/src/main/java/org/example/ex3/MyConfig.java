package org.example.ex3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.example.ex3")
@EnableAspectJAutoProxy // включає службову логіку
public class MyConfig {

}

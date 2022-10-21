package org.example.ex8;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.example.ex8")
@EnableAspectJAutoProxy // включає службову логіку
public class MyConfig {

}

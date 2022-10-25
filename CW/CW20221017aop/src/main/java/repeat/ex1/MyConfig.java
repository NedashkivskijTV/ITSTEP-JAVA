package repeat.ex1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("repeat.ex1")
@EnableAspectJAutoProxy // активує роботу службової логіки - надає дозвіл на роботу з методами основної бізнес-логіки (ВАЖЛИВО!!! - без даної анотації не працюватиме)
public class MyConfig {
}

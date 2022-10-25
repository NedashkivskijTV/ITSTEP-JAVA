package repeat.ex5;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("repeat.ex5")
@EnableAspectJAutoProxy // активує роботу службової логіки - надає дозвіл на роботу з методами основної бізнес-логіки (ВАЖЛИВО!!! - без даної анотації не працюватиме)
public class MyConfig {
}

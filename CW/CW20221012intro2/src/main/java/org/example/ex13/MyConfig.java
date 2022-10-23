package org.example.ex13;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration // на клас, що виконує роль конфігураційного файлу (при цьому конфігураційний файл XML відсутній !!!)
//@PropertySource("classpath:myApp.properties") // на клас - конфігураційний файл - для підключення файлу з даними до конфігураційного файлу, приймає ключове слово classpath: (переменная среди) та після двокрапки - назву файлу з даними
public class MyConfig {
    @Bean // на метод в класі, що виконує функції configuration file - вказує на те, що в методі описано створення біна, а назва методу = id даного біна
    @Scope("prototype")
    public Pet catBean(){ // метод, що відповідає за створення біна
        System.out.println("catBean");
        return new Cat();
    }

    @Bean
    public Person personBean(){
        System.out.println("personBean");
        return new Person(catBean()); // впровадження залежності за допомогою біна Cat
    }
}

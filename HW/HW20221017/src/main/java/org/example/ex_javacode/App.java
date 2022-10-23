package org.example.ex_javacode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "\nКонфігурування configuration file за допомогою Java code\n" );
        // При створенні об'єкта Address та для його наповнення даними з файлу використовується конструктор з параметрами
        // При створенні об'єкта User використовується конструктор за замовчуванням
        // для реалізації DI використовується сетер
        // для наповнення об'єкта даними з файлу - поля

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

//        Address address = context.getBean("address", Address.class);
//        System.out.println(address);
//        System.out.println("street - " + address.getStreet());

        User user = context.getBean("user", User.class);
        System.out.println(user);
        System.out.println("user street - " + user.getAddress().getStreet());

        context.close();
    }
}

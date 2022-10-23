package org.example.ex_annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "\nКонфігурування configuration file за допомогою Annotation\n" );
        // При створенні об'єкта Address та для його наповнення з файлу використовується конструктор з параметрами
        // При створенні об'єкта User використовується конструктор за замовчуванням
        // для реалізації DI та наповнення об'єкта даними з файлу - сетери

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_annotation.xml");

//        Address address = context.getBean("address", Address.class);
//        System.out.println(address);
//        System.out.println("street - " + address.getStreet());

        User user = context.getBean("user", User.class);
        System.out.println(user);
        System.out.println("user street - " + user.getAddress().getStreet());

        context.close();
    }
}

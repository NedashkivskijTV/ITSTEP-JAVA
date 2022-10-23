package org.example.ex_javacode_oop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "\nКонфігурування configuration file за допомогою Java code (ООП)\n" );
        // При створенні об'єкта Address
        // використовується конструктор за замовчуванням (без параметрів)
        // для наповнення об'єкта Address даними з файлу використовується сетери
        // При створенні об'єкта User
        // для реалізації DI використовується конструктор для впровадження залежності (приймає бін Address)
        // для наповнення об'єкта даними з файлу - сетери

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

//        Address address = context.getBean("address", Address.class);
//        System.out.println(address);
//        System.out.println("street - " + address.getStreet());

        User user = context.getBean("user", User.class);
        System.out.println(user);
        System.out.println("\nuser street - " + user.getAddress().getStreet());

        context.close();
    }

}

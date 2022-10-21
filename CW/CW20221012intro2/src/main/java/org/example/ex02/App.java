package org.example.ex02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Створення об'єктів за допомогою Spring Container -
        // конфігурування configuration file – XML, DI – через сеттери
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext02.xml"); // реалізація Spring Container для роботи з XML
        Person person =  context.getBean("person", Person.class);
        person.callPet();
    }
}

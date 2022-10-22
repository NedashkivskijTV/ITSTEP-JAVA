package org.example.ex08;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Створення об'єктів за допомогою Spring Container
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext08.xml"); // реалізація Spring Container для роботи з XML

        System.out.println("- person ------------------------------------");
        Person person = context.getBean("person", Person.class);
        person.callPet();

        context.close();// Кінець роботи SpringContainer - сигнал для завершення роботи бінів зі scope Singleton
    }
}

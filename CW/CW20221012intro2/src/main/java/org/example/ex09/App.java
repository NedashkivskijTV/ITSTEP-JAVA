package org.example.ex09;

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
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext09.xml"); // реалізація Spring Container для роботи з XML

        System.out.println("- person ------------------------------------");
        Person person = context.getBean("person", Person.class);
        person.callPet();
        System.out.println(person.getFullName());
        System.out.println(person.getAge());

        context.close();// Кінець роботи SpringContainer - сигнал для завершення роботи бінів зі scope Singleton
    }
}

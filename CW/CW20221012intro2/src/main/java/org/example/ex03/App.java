package org.example.ex03;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.ls.LSOutput;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Створення об'єктів за допомогою Spring Container
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext03.xml"); // реалізація Spring Container для роботи з XML
        System.out.println();

        Person person =  context.getBean("person", Person.class);
        person.callPet();
        System.out.println(person.getFullName());
        System.out.println(person.getAge());
    }
}

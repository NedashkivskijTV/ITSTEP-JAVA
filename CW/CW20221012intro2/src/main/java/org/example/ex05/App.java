package org.example.ex05;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // реалізація Spring Container для роботи з XML
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext05.xml");

        System.out.println("----------------------------");
        // Застосовується scope singleton - створюється 1 об'єкт, щоразу повертається посилання на нього
        Cat cat1 = context.getBean("catS", Cat.class);
        cat1.voice();

        System.out.println("----------------------------");
        // Застосовується scope prototype - кожного разу створюється новий об'єкт, при цьому кожен об’єкт даного scope створюється після виклику
        Cat cat2 = context.getBean("catP", Cat.class);
        cat2.voice();
        cat2.destroy();
        System.out.println("----------------------------");

        context.close(); // Кінець роботи SpringContainer
    }
}

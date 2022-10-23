package org.example.ex13;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // реалізація Spring Container для роботи з Java code + Annotation
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("------------------------------");

        Cat cat1 = (Cat) context.getBean("catBean");
        Cat cat2 = (Cat) context.getBean("catBean");

        Person person = context.getBean("personBean", Person.class);
        person.callPet();

        System.out.println("------------------------------");
        context.close(); // Кінець роботи SpringContainer - сигнал для завершення роботи бінів зі scope Singleton
    }
}

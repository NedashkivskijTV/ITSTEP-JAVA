package org.example.ex12;

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

        Cat cat1 = (Cat) context.getBean("cat");
        cat1.voice();

        System.out.println("------------------------------");
        context.close(); // Кінець роботи SpringContainer - сигнал для завершення роботи бінів зі scope Singleton
    }
}

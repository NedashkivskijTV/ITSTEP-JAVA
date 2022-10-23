package org.example.ex11;

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
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext11.xml");
        System.out.println("------------------------------");

        // Застосовується scope singleton - створюється 1 об'єкт, щоразу повертається посилання на нього
        Cat cat1 = (Cat) context.getBean("cat");
        Cat cat2 = (Cat) context.getBean("cat");

        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat1 == cat2);

        System.out.println("------------------------------");
        context.close(); // Кінець роботи SpringContainer - сигнал для завершення роботи бінів зі scope Singleton
    }
}

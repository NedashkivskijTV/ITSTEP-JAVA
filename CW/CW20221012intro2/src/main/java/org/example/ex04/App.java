package org.example.ex04;

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
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext04.xml");

        // Застосовується scope singleton - створюється 1 об'єкт, щоразу повертається посилання на нього
        Cat cat1 = (Cat) context.getBean("catS");
        Cat cat2 = (Cat) context.getBean("catS");
        cat1.setName("Daimon");
        cat2.setName("Marsik");

        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat1 == cat2);

        System.out.println("----------------------------------------------------");
        // Застосовується scope prototype - кожного разу створюється новий об'єкт, при цьому кожен об’єкт даного scope створюється після виклику
        Cat cat3 = (Cat) context.getBean("catP");
        Cat cat4 = (Cat) context.getBean("catP");
        cat3.setName("Daimon");
        cat4.setName("Marsik");

        System.out.println(cat3);
        System.out.println(cat4);
        System.out.println(cat3 == cat4);

    }
}

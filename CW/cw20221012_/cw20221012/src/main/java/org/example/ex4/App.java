package org.example.ex4;

import org.example.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext4.xml");

        Cat cat1 = (Cat) context.getBean("cat");
        Cat cat2 = (Cat) context.getBean("cat");

        cat1.setName("Tom");
        cat2.setName("Mars");

        System.out.println(cat1);
        System.out.println(cat2);

        System.out.println(cat1 == cat2);
    }
}

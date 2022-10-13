package org.example.ex5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext5.xml");

        Cat cat = (Cat) context.getBean("cat");
        cat.voice();

        context.close();
    }
}

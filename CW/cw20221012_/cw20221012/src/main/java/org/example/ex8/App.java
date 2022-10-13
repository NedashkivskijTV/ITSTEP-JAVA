package org.example.ex8;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext8.xml");

        //Pet pet = context.getBean("myCat", Pet.class);
//        Pet pet = context.getBean("cat", Pet.class);
//        pet.voice();

        Person person = context.getBean("person", Person.class);
        person.callPet();

        context.close();
    }
}

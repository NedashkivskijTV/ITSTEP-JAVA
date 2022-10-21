package org.example.ex11;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext11.xml");

        //Pet pet = context.getBean("myCat", Pet.class);
//        Pet pet = context.getBean("cat", Pet.class);
//        pet.voice();

        Person person = context.getBean("person", Person.class);
        person.callPet();

        System.out.println(person.getFullName());

        context.close();
    }
}

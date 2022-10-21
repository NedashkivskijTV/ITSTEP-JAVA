package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //Profile profile = context.getBean("profileSetters", Profile.class); // створення bean-а з використанням хардкоду через сетери
        //Profile profile = context.getBean("profileConstructor", Profile.class); // створення bean-а з використанням хардкоду через конструктор
        //Profile profile = context.getBean("profileFromFile", Profile.class); // створення bean-а з використанням файлу myApp.properties через сетери - поелементне завантаження
        Profile profile = context.getBean("profileFromFileOllCollection", Profile.class); // створення bean-а з використанням файлу myApp.properties через сетери - завантаження колекції
        System.out.println(profile);

        System.out.println();System.out.println("All programming languages:");
        //List<String> languages = profile.getProgrammingLanguages();
        List<String> languages = Arrays.asList(profile.getProgrammingLanguages());
        for (String language : languages) {
            System.out.println(language);
        }

    }
}

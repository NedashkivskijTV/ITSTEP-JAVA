package org.example.ex8;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        //SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        University university = (University) context.getBean("university");

        university.fillStudents();

        List<Student> students = university.getStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

package org.example.ex6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        schoolLibrary.getBook();
        schoolLibrary.getMagazine(2);
        schoolLibrary.setBook();
        schoolLibrary.addBook();
        schoolLibrary.removeBook();

    }
}

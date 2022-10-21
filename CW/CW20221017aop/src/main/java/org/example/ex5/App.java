package org.example.ex5;

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
        UniversityLibrary universityLibrary = context.getBean("universityLibrary", UniversityLibrary.class);

        universityLibrary.getBook();
        //universityLibrary.getMagazine(1);
        universityLibrary.getMagazine();
        universityLibrary.addBookById();
        universityLibrary.setBook();
        universityLibrary.addBook();
        universityLibrary.removeBook();

        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        schoolLibrary.getBook();
        schoolLibrary.getMagazine(2);
        schoolLibrary.setBook();

    }
}

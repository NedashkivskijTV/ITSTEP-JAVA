package repeat.ex2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(MyConfig.class);
        UniversityLibrary universityLibrary = context.getBean("universityLibrary", UniversityLibrary.class);
        universityLibrary.getBook();
        universityLibrary.getMagazine(1);
        universityLibrary.getNewspaper();
        universityLibrary.addBookById(2);
        universityLibrary.addBook();

        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        schoolLibrary.getBook();
        schoolLibrary.getMagazine(4);
        schoolLibrary.getMagazine("Spiderman");

        context.close();
    }
}

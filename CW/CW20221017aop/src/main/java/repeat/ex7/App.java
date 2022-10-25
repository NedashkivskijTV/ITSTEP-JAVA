package repeat.ex7;

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

        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        schoolLibrary.getBook();
        schoolLibrary.getMagazine(4);
        schoolLibrary.getMagazine("Spiderman");
        schoolLibrary.setBook();
        schoolLibrary.addBook();
        schoolLibrary.removeBook();

        context.close();
    }
}

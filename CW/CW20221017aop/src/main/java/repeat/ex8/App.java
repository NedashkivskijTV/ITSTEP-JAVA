package repeat.ex8;

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
        AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(MyConfig.class);

        University university = (University) context.getBean("university");
        university.fillStudents();

        List<Student> students = university.getStudents();
        for (Student student : students) {
            System.out.println(student);
        }

        context.close();
    }
}

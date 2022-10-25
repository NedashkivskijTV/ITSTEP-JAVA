package org.example;

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

        //User user = new User();
        User user = context.getBean("user", User.class);
        user.setFirstName("Ivan");
        user.setLastName("Ivanenko");
        System.out.println(user.getLastName());
        System.out.println(user);
        user.setFirstName("Anton");
        user.setLastName("Antonenko");
        System.out.println(user.getLastName());
        System.out.println(user);

        context.close();
    }
}

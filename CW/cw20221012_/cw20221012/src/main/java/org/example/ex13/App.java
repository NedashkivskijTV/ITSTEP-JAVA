package org.example.ex13;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Cat cat1 = (Cat) context.getBean("cat");
        Cat cat2 = (Cat) context.getBean("cat");
        //cat1.voice();


        context.close();
    }
}

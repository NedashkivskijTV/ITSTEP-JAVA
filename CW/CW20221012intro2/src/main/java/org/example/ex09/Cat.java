package org.example.ex09;

import org.springframework.stereotype.Component;

//@Component // спеціальний маркер, яким помічається той клас, з котрого потрібно буде створити bean (з параметром "bean_id" / без параметрів)
@Component("myCat") // спеціальний маркер, яким помічається той клас, з котрого потрібно буде створити bean (з параметром "bean_id" / без параметрів)
public class Cat implements Pet {
    public Cat() {
        System.out.println("Cat");
    }
    @Override
    public void voice() {
        System.out.println("Mau");
    }
}

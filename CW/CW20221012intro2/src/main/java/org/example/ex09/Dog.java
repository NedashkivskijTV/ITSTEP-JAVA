package org.example.ex09;

import org.springframework.stereotype.Component;

@Component // спеціальний маркер, яким помічається той клас, з котрого потрібно буде створити bean (з параметром "bean_id" / без параметрів)
public class Dog implements Pet {
    public Dog() {
        System.out.println("Dog");
    }

    @Override
    public void voice() {
        System.out.println("Woof");
    }
}

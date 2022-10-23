package org.example.ex12;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // спеціальний маркер, яким помічається той клас, з котрого потрібно буде створити bean (з параметром "bean_id" / без параметрів)
@Scope("singleton") // до класу – при няавності анотації @Component, яка вказує на необхідність створення біна, задає область видимості – SCOPE для даного біна – приймає параметр – рядок, де вказується singleton або prototype
//@Scope("prototype") // до класу – при няавності анотації @Component, яка вказує на необхідність створення біна, задає область видимості – SCOPE для даного біна – приймає параметр – рядок, де вказується singleton або prototype
public class Cat {
    private String name;

    public Cat() {
        System.out.println("Cat");
    }

    public void voice() {
        System.out.println("Mau");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}

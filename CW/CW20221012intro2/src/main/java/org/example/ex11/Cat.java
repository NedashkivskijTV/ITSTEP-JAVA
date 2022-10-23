package org.example.ex11;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
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

    // назва методу довільна, загальноприйнято init
    // модифікатор доступу будь-який
    // тип поверненого значення будь-який, але при використанні Scope Singleton він ігноруватиметься (оскільки викливається автоматично)
    @PostConstruct // до методу – для забезпечення виконання методу у якості метода init() - потребує підключення окремої бібліотеки javax.annotation-api
    public void init(){
        System.out.println("init");
    }

    // назва методу довільна, загальноприйнято destroy
    // модифікатор доступу будь-який
    // тип поверненого значення будь-який, при Scope Prototype може доприкладу повертати boolean значення (вдале/невдале відпрацювання)
    @PreDestroy // до методу – для забезпечення виконання методу у якості метода destroy() - потребує підключення окремої бібліотеки javax.annotation-api
    public void destroy(){
        System.out.println("destroy");
    }
}

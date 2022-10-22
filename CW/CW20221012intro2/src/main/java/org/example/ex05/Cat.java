package org.example.ex05;

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

    // назва класу довільна, загальноприйнято init
    // модифікатор доступу будь-який
    // тип поверненого значення будь-який, але при використанні Scope Singleton він ігноруватиметься (оскільки викливається автоматично)
    public void init(){
        System.out.println("init");
    }

    // назва класу довільна, загальноприйнято destroy
    // модифікатор доступу будь-який
    // тип поверненого значення будь-який, при Scope Prototype може доприкладу повертати boolean значення (вдале/невдале відпрацювання)
    public void destroy(){
        System.out.println("destroy");
    }
}

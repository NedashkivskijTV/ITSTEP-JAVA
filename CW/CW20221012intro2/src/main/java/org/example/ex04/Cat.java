package org.example.ex04;

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

    public void init(){
        System.out.println("init");
    }

    public void destroy(){
        System.out.println("destroy");
    }
}

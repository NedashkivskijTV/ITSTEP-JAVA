package edu.itstep.cw20220909.inner_classes.nested;

public class Main {
    public static void main(String[] args) {
        //ВЛОЖЕНІ КЛАСИ
        //створення екземпляра класу з іншого пекеджа
        //edu.itstep.hw20220909.inner_classes.inner.Outer outer1 = new edu.itstep.hw20220909.inner_classes.inner.Outer();

        Outer outer = new Outer();                  // створення ЕЗК
        outer.outerMethod();
        System.out.println("-----------------------------------------------------");

        Outer.Nested nested = new Outer.Nested();   // створення ЕВК - единий спосіб створення ЕВК
        nested.innerNested();
    }
}

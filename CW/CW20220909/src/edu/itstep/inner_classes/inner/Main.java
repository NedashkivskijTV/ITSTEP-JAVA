package edu.itstep.inner_classes.inner;

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        System.out.println("-----------------");
        Outer.Inner inner = outer.new Inner();
        inner.innerMethod();

    }
}

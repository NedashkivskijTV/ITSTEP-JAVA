package edu.itstep.inner_classes.inner;

import java.sql.SQLOutput;

public class Outer {
    private String outerPrivateField;
    public String outerPublicField;
    public String test = "OUTER";

    public Outer() {
        System.out.println(this);
        System.out.println("Outer");
        Inner inner = new Inner();
    }

    public void outerInner() {
//        System.out.println(innerPrivateField);
//        System.out.println(innerPublicField);
        Inner inner = new Inner();
        System.out.println(inner.innerPrivateField);
        System.out.println(inner.innerPublicField);
    }

    public class Inner {
        private String innerPrivateField;
        public String innerPublicField;
        public String test = "INNER";


        public Inner() {
            System.out.println(this);
            System.out.println("Inner");
        }
        public void innerMethod(){
            System.out.println(outerPrivateField);
            System.out.println(outerPublicField);
            System.out.println(test);
            System.out.println(Outer.this.test);
        }
    }
}

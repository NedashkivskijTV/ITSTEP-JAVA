package edu.itstep.inner_classes.nested;

public class Outer {
    private String outerPrivateField;
    public String outerPublicField;
    private static int privateStaticOuterField = 777;
    public String test = "OUTER";

    public Outer() {
        System.out.println(this);
        System.out.println("Outer");
//        Inner inner = new Inner();
    }

    public void outerMethod() {
//        System.out.println(nestedPrivateField);
//        System.out.println(nestedPublicField);
        Nested nested = new Nested();
        System.out.println(nested.nestedPrivateField);
        System.out.println(nested.nestedPublicField);
    }

    public static class Nested {
        private String nestedPrivateField;
        public String nestedPublicField;
        public String test = "NESTED";


        public Nested() {
            System.out.println(this);
            System.out.println("Nested");
        }
        public void nestedMethod(){
//            System.out.println(outerPrivateField);
//            System.out.println(outerPublicField);
            System.out.println(privateStaticOuterField);
//            System.out.println(test);
//            System.out.println(Outer.this.test);
        }
    }
}

package edu.itstep.inner_classes.local;

public class Outer {
    private String instanceVariable = "instanceVariable";

    public Object start(){
        String localVariable = "localVariable";
        // модифікатори доступу заборонені
        class Inner{
            private String privateInnerField = "private";
            public String publicInnerField = "public";

            public void innerMethod() {
                System.out.println(privateInnerField);
                System.out.println(privateInnerField);
                System.out.println(instanceVariable);
                System.out.println(localVariable);
            }
        }

        Inner inner = new Inner();
        System.out.println(inner.privateInnerField);
        System.out.println(inner.publicInnerField);

        return inner;
    }
}

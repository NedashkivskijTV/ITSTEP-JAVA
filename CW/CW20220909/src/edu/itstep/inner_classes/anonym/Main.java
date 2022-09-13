package edu.itstep.inner_classes.anonym;

public class Main {
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.showName();

        Parent anonym = new Parent(){
            @Override
            public void showName() {
                //super.showName();
                System.out.println("anonymous");
            }
        };
        anonym.showName();

        Parent parent1 = new Parent();
        Child child = new Child();
        parent1.showName();
        child.showName();

    }
}

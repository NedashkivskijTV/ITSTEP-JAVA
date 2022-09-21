package edu.itstep.cw20220914.generics;

public class Main {
    public static void main(String[] args) {
//        Passport passport1 = new Passport("777");
//        Passport passport2 = new Passport("CM123456");

        Passport<Integer> passport1 = new Passport<Integer>(777);
        Passport<String> passport2 = new Passport<String>("CM123456");

        int id1 = passport1.getId();
        String id2 = passport2.getId();

    }
}

package edu.itstep.cw20220909.blocks;

public class Main {
    public static void main(String[] args) {
        //System.out.println(Parent.staticPublicParent);
        System.out.println("--------------------------------------");

        Child child = new Child();

        System.out.println("--------------------------------------");
        Alphabet alphabet = new Alphabet();
        System.out.println(alphabet.getLetters()); //abcdefghijklmnopqrstuvwxyz
    }
}

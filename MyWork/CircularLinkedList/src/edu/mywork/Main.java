package edu.mywork;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        System.out.println(list.size());
        System.out.println(list);
    }
}

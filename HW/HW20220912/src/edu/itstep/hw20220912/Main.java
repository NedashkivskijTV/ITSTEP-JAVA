package edu.itstep.hw20220912;

public class Main {
    public static void main(String[] args) {
        TestForwardList();
    }

    public static void TestForwardList(){
        ForwardListInteger list = new ForwardListInteger();

        list.addToHead(1);
        list.deleteFromHead();
        list.addToHead(2);
        list.deleteFromTail();
        list.addToHead(3);
        list.addToHead(4);
        list.addToHead(5);
        list.showList();

        list.addToTail(0);
        list.addToTail(-1);
        list.addToTail(-2);
        list.showList();

//        list.deleteFromTail();
//        list.deleteFromTail();
//        list.deleteFromTail();
//        list.deleteFromTail();
//        list.deleteFromTail();
//        list.deleteFromTail();
//        list.deleteFromTail();
        list.deleteFromHead();
        list.deleteFromHead();
        list.deleteFromHead();
        list.deleteFromHead();
        list.deleteFromHead();
        list.showList();
        list.deleteFromHead();
        list.deleteFromHead();
        list.showList();

        list.addToTail(888);
        list.showList();
        list.deleteFromTail();
        list.showList();

        ForwardListInteger list2 = new ForwardListInteger(5,4,3,2,1);
        list2.showList();
    }
}

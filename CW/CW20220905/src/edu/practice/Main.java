package edu.practice;

public class Main {
    public static void main(String[] args) {
//        int[] arr = {1, 1, 1};
//        System.out.println(arr[0]);
        // +1 екземпляр

        ArrayListInt arrayListInt = new ArrayListInt();

        arrayListInt.add(7);
        arrayListInt.add(77);
        arrayListInt.add(777);
        arrayListInt.add(8);

        arrayListInt.print();

    }
}

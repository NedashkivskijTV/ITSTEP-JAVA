package edu.practice;

public class ArrayListInt {
    private int[] data;
    public int size = 0;

    public ArrayListInt() {
        data = new int[size];
    }

    public void add(int value){
        int[] temp = new int[size + 1];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        temp[size] = value;
        data = temp;
        size++;
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
    }
}

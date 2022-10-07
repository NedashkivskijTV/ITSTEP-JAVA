package edu.itstep.hw20220919_analysis.exceptions;

public class Main {
    public static void main(String[] args) {
        // unchecked
        System.out.println("start");
        int[] arr = new int[3];
        System.out.println(arr.length);
        int index = 7;
        //System.out.println(arr[index]); // вихід за межі масиву
        System.out.println("end");

        System.out.println("====================================================");
        String s  = null;
        //System.out.println(s.toUpperCase()); // зміна рядка із значенням null
        System.out.println();

        System.out.println("====================================================");
        int a = 1;
        int b = 0;
        //System.out.println(a / b); // математична помилка - ділення на 0
    }
}

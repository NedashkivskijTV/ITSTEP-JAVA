package edu.itstep.firstproject;

public class Main11 {
    public static void main(String[] args) {
        // масиви - завжди ініціалізовані 0 - ссилочний тип даних
        int size = 5;   //  розмір може бути визначений під час виконання, яле змінити його у подальшому
                        // неможливо (створюєтся новий масив, ппереписуються дані)
        int[] arr = new int[size]; // оголошення масива
        System.out.println(arr); // поверне посилання
        System.out.println(arr[0]);
        System.out.println(arr.length);

        System.out.println("------------------------------------------------");

        int [] arr1 = {1,2,3,4,5,6,7}; // оголошення з ініціалізацією 

        // itar
        for (int i = 0; i < arr1.length; i++) {
            //int i1 = arr1[i];
            System.out.println(arr1[i]);
        }

        System.out.println("------------------------------------------------");
        // iter
        for (int i : arr1) {
            System.out.println(i); // змінна і - локальна копія відповідного значення - не змінюється у циклі
        }


    }
}

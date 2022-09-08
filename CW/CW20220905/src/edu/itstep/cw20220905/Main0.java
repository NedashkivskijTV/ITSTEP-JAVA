package edu.itstep.cw20220905;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main0 {
    public static void main(String[] args) {
        // примітивні типи vs ссилочні типи
        // память Stack(обмежений - ~ 1МБ - обробляється швидко)
        //        Heap(необмежений)

        int number = 5; // примітив - зберігається у Stack (у памяті зберігається сам обєкт)
        System.out.println(number);

        changeInt(number); // значення примітива у методі не змінюється
        System.out.println(number);

        int[] arr = {1,1,1}; // ссилочний тип даних - зберігається у Heap (у памяті - ссилка)
        System.out.println(arr); // на екрані - ссилка
        System.out.println(Arrays.toString(arr)); // роздрук вмісту масива у вигляді рядка
        int[] arr1 = arr;
        System.out.println(arr1); // на екрані - ссилка
        System.out.println(Arrays.toString(arr1));

        changeArr(arr); //  значення змінних ссилочного типу можна змінити в методі
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));

        System.out.println("-------------------");
        int [][] arr2 = new int[2][3]; // конструкція для роздруку двомірного масива
        for (int[] item : arr2) {
            System.out.println(Arrays.toString(item));
        }


    }

    // допоміжні методи
    public static void changeInt(int number){
        //System.out.println("Hello");
        number = 6;
    }

    public  static void changeArr(int[] copy){
        copy[0] = 2;
        copy[1] = 2;
        copy[2] = 2;
    }

}

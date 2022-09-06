package edu.itstep.cw20220905;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main0 {
    public static void main(String[] args) {
        // примітивні типи vs ссилочні типи
        // память Stack(обмежений - ~ 1МБ - обробляється швидко)
        //        Heap(необмежений)

        int number = 5;
        System.out.println(number);

        int[] arr = {1,1,1};
        //System.out.println(arr);
        System.out.println(Arrays.toString(arr));
        changeArr(arr);
        System.out.println(Arrays.toString(arr));

        changeInt(number);
        System.out.println(number);


        for (int item : arr) {
            //System.out.println(Arrays.toString(item));
        }


    }

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

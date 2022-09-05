package edu.itstep.hw20220901;

public class Main01 {
    public static void main(String[] args) {
        int rows = 4, cols = 4;
        int[][] arr = new int[rows][cols];
        int count = 0;

        // виведення створеного масиву
//        for (int i = 0; i < cols; i++) {
//            for (int j = 0; j < rows; j++) {
//                System.out.print(arr[i][j] + "  ");
//            }
//            System.out.println();
//        }

        // заповнення масиву звичайне
/*
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                arr[i][j] = ++count;
            }
        }
*/
        // заповнення масиву змійкою
        for (int i = 0; i < cols; i++) {
            if(i % 2 == 0) {
                for (int j = 0; j < rows; j++) {
                    arr[i][j] = ++count;
                }
            } else {
                for (int j = rows - 1; j >= 0 ; j--) {
                    arr[i][j] = ++count;
                }
            }
        }

        // виведення заповненого масиву
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }

    }
}

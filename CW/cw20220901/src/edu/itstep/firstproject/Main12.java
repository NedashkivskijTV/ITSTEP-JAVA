package edu.itstep.firstproject;

public class Main12 {
    public static void main(String[] args) {
        // багатомірні масиви
        int[][] arr =  new int[2][3];
        arr [0][0] = 7;
        arr [1][2] = 77;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }
}

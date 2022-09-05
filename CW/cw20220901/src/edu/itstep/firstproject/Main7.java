package edu.itstep.firstproject;

public class Main7 {
    public static void main(String[] args) {
        // логічні оператори
        // ?? || !
        System.out.println(3 > 1 && 2 == 2); // з рядками не працює

        int count = 1;
        int a = 1;
        int b = 2;
        if(a == b && count++ > 10){ // подвійна перевірка, друга умова не перевірятиметься
            System.out.println("work");
        }
        System.out.println(count);

        System.out.println("--------------------------------------------------------------");
        boolean isFinished = true;
        System.out.println(isFinished);
        System.out.println(!isFinished);

    }
}

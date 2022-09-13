package edu.itstep.cw20220912.higher_order_function;

import edu.itstep.cw20220912.lambda.Calculator;

public class Main {
    public static void main(String[] args) {
        calc((x, y) -> x + y);
        calc((x, y) -> x * y);
        calc((x, y) -> x + x + y + y);
    }

    public static void calc(Calculator calculator) {
        System.out.println("start");
        // дані отримує сам метод
        double a = 5;
        double b = 2;
        System.out.println(calculator.execute(a, b));
        //????

        System.out.println("end");
        System.out.println("-----------------------------------");
    }
}

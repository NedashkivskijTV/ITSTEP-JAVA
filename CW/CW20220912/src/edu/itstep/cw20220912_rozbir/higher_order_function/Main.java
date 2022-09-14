package edu.itstep.cw20220912_rozbir.higher_order_function;

import edu.itstep.cw20220912_rozbir.lambda.Calculator;

public class Main {
    public static void main(String[] args) {
        calc((x, y) -> x + y);
        calc((x, y) -> x - y);
        calc((x, y) -> x * y);
        calc((x, y) -> {
            if (y == 0) {
                System.out.println("На 0 ділити не можна");
                return 0;
            }
            return x / y;
        });
        calc((x, y) -> x + x + y + y);
    }

    public static void calc(Calculator calculator) {
        System.out.println("start");

        // дані отримує сам метод
        double a = 5;
        double b = 2;
        System.out.println(calculator.execute(a, b));

        //що робити з даними метод не знає

        System.out.println("end");
    }
}

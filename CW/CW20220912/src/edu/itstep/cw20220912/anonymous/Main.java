package edu.itstep.cw20220912.anonymous;

import edu.itstep.cw20220912.lambda.Calculator;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator() {
            @Override
            public double execute(double a, double b) {
                return a + b;
            }
        };

        Calculator calculator2 = (a, b) -> a + b;

        System.out.println(calculator.execute(2, 2));
        System.out.println(calculator2.execute(2, 2));
    }
}

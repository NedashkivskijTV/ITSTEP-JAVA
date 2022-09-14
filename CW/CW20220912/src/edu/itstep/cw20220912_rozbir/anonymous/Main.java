package edu.itstep.cw20220912_rozbir.anonymous;

import edu.itstep.cw20220912_rozbir.lambda.Calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator() {
            @Override
            public double execute(double a, double b) {
                return a + b;
            }
        };
        Calculator calculator2 = (a, b) -> a + b;

        // у змінній calculator та calculator2 зберігається посилання на
        // екземпляр анонімного класу, який імплементує (реалізує)
        // інтерфейс Calculator
        // (безпосередньо у тілі класу реалізовано метод execute)
    }
}

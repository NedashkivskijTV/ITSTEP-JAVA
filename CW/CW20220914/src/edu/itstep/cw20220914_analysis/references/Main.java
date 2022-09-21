package edu.itstep.cw20220914_analysis.references;

public class Main {
    public static void main(String[] args) {
        // 1 - виклик методу через створення класу
        calk(new CalculatorImpl()); // +

        // інший варіант виклику
        Calculator calculator1 = new CalculatorImpl(); // +
        System.out.println(calculator1.execute(5, 2));
        System.out.println("-------------------------------------------------------");

        // 2 - виклик методу через створення екземпляра анонімного класу
        calk(new Calculator() {
            @Override
            public double execute(int a, int b) {
                return a - b;
            }
        }); // -

        // інший варіант виклику
        Calculator calculator2 = new Calculator() {
            @Override
            public double execute(int a, int b) {
                return a - b;
            }
        }; // -
        System.out.println(calculator2.execute(5, 2)); // -
        System.out.println("-------------------------------------------------------");

        // 3 - виклик методу через передачу лямбди (реалізація абстрактного методу функціонального інтерфейсу)
        calk((x, y) -> 1.0 * x / y); // /
        // інший варіант виклику
        Calculator calculator3 = (x, y) -> 1.0 * x / y; // /
        System.out.println(calculator3.execute(5, 2));
        System.out.println("-------------------------------------------------------");

        // 4 - через посилання на метод (функцію)
        // посилання на статичний метод (стан недоступний)
        calk(CalcUtil::multiplication); // *
        //посилання на нестатичний метод, що викликається через створення
        //екземпляра класу (може використовувати стан екземпляра)
        calk(new CalcUtil()::multiplicationNonStatic); // *

        // інший варіант виклику
        Calculator calculator4 = CalcUtil::multiplication; // *
        Calculator calculator4_1 = new CalcUtil()::multiplicationNonStatic; // *
        System.out.println(calculator4.execute(5, 2));
        System.out.println(calculator4_1.execute(5, 2));
        System.out.println("-------------------------------------------------------");
        // використання стану обєкту класу при передачі посилання на нестатичний метод
        System.out.println("посилання на нестатичний метод - використання контексту");
        Calculator calculator4_21 = new CalcUtilOperator("+")::calc;
        Calculator calculator4_22 = new CalcUtilOperator("-")::calc;
        Calculator calculator4_23 = new CalcUtilOperator("*")::calc;
        Calculator calculator4_24 = new CalcUtilOperator("/")::calc;
        //calk(new CalcUtilOperator("+")::calc);
        System.out.println(calculator4_21.execute(2, 4)); // + =6.0
        System.out.println(calculator4_22.execute(2, 4)); // - =-2.0
        System.out.println(calculator4_23.execute(2, 4)); // * =8.0
        System.out.println(calculator4_24.execute(2, 4)); // / =0.5
        System.out.println("-------------------------------------------------------");

        System.out.println(calculator1.execute(5, 1));
        System.out.println(calculator2.execute(5, 1));
        System.out.println(calculator3.execute(5, 1));
        System.out.println(calculator4.execute(5, 1));
        System.out.println("-------------------------------------------------------");

        // виклик методу з параметрами та посиланням на нестатичний метод
        calk(5, 5, new CalcUtilOperator("*")::calc);
    }

    public static void calk(Calculator calculator) {
        int v1 = 5;
        int v2 = 2;
        double result = calculator.execute(v1, v2);
        System.out.println(result);
    }

    // перегружений метод з параметрами
    public static void calk(int value1, int value2, Calculator calculator) {
        double result = calculator.execute(value1, value2);
        System.out.println(result);
    }
}

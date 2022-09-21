package edu.itstep.cw20220914.references;

public class Main {
    public static void main(String[] args) {
//        CalculatorImpl calculator1 = new CalculatorImpl();
//        calc(new CalculatorImpl()); // +
//
//        calc(new Calculator() {
//            @Override
//            public double execute(double a, double b) {
//                return a - b;
//            }
//        }); // -
//
//        calc((x, y) -> x / y); // /

//        calc(CalcUtil::multiplication);

        Calculator calculator1 = (x, y) -> x / y;
        Calculator calculator2 = CalcUtil::multiplication;
        Calculator calculator3 = new Calculator() {
            @Override
            public double execute(int a, int b) {
                return 0;
            }
        };
        Calculator calculator4 = new CalculatorImpl();


    }

    public static void calc(Calculator calculator) {
        int v1 = 5;
        int v2 = 2;
        System.out.println(calculator.execute(v1, v2));
    }


}

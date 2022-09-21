package edu.itstep.cw20220914_analysis.references;

public class CalcUtilOperator {
    private String operator;

    public CalcUtilOperator(String operator) {
        this.operator = operator;
    }

    public static double multiplication(int value1, int value2) {
        return 1.0 * value1 * value2;
    }

    public double calc(int value1, int value2) {
        if (operator.equals("*")) {
            return 1.0 * value1 * value2;
        } else if(operator.equals("+")){
            return 1.0 * value1 + value2;
        } else if(operator.equals("-")){
            return 1.0 * value1 - value2;
        } else{
            if(value2 == 0){
                System.out.println("Can't divide by 0");
                return 0;
            }
            return 1.0 * value1 / value2;
        }
    }
}

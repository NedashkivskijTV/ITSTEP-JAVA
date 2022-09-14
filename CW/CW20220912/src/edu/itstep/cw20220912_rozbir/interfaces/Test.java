package edu.itstep.cw20220912_rozbir.interfaces;

public class Test {
    public static void main(String[] args) {
        sum(1);
        sum(1, 2);
        sum(1, 2, 3);
        sum();
        sum(new int[]{1,2,3,4,5,6});
    }
    public static void sum(int... numbers){
        System.out.println(numbers.length);
    }
}

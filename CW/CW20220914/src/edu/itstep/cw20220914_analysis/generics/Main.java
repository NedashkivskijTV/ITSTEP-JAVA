package edu.itstep.cw20220914_analysis.generics;

public class Main {
    public static void main(String[] args) {
        Passport<Integer> passport1 = new Passport<>(777);
        Passport<String> passport2 = new Passport<>("CM123456");

        int id1 = passport1.getId();
        System.out.println(id1 + 100);
        String id2 = passport2.getId();
        System.out.println(id2 + 100);

//        Процеси:
//        -	Автоматична упаковка
        // примітив зберігається як ссилочний ти даних (у кучі а не у стеку)
        int number = 1;
        Integer integer = number;
        System.out.println(integer);


//        -	Автоматична розпаковка
        Integer integer1 = 777;
        int i = integer1;
        System.out.println(i);
        

    }
}

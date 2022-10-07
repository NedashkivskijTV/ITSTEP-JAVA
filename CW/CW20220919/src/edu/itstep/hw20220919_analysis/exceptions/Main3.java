package edu.itstep.hw20220919_analysis.exceptions;

public class Main3 {
    public static void main(String[] args) {

        // checked
        try {
            Controller.start(555);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            System.err.println("ПОМИЛКА ! Що робитимеш ?");
        }
        System.out.println("finish");

    }

}

package edu.itstep.hw20220919_analysis.exceptions;

public class Controller {
    public static void start(int key) throws Exception {

        if(key < 0){
            throw new Exception("ключ не має бути < 0");
        }
    }
}

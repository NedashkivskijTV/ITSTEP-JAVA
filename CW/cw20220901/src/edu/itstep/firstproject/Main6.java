package edu.itstep.firstproject;

public class Main6 {
    public static void main(String[] args) {
        // switch - перемикач
        int number = 2;
        switch (number){ // працює з типами : char, byte, short, int, Character, Byte, Integer, String, enum
            case 1:
            {
                System.out.println("one");
                break;
            }
            case 2:
            {
                System.out.println("two");
                break;
            }
            default:
            {
                System.out.println("don't No");
                break;
            }
        }

    }
}

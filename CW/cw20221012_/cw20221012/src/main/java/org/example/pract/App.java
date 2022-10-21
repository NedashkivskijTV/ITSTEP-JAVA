package org.example.pract;

import org.example.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //System.out.println("Hello");

        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("11");
        strings.add("111");
        strings.add("1111111");
        strings.add("111");
        strings.add("111111111111");
        strings.add("111111");
        strings.add("11111111111111");
        strings.add("11111111");
        strings.add("11111");
        strings.add("111111111111");

        System.out.print("Введіть кількість рядків - ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        int masCount = strings.size() / choice + 1;

        String[] strMas = new String[masCount];
        strings.forEach(System.out::println); // виведення первинного масиву

        int mass = 0;
        int countLines = 1;
        List<List<String>> listLines = new ArrayList<>();
        for (String string : strings) {
            System.out.println("mas = " + mass + "; countLines = " + countLines);
            if (countLines == 1) {
                List<String> newRow = new ArrayList<>();
                listLines.add(newRow);
            }
            listLines.get(mass).add(string);
            //if(countLines != 0 && countLines % choice == 0){
            if (countLines % choice == 0) {
                mass++;
                countLines = 1;
            } else {
                countLines++;
            }
            //System.out.println("mas = " + mass + "; countLines = " + countLines);
        }

        System.out.println("------------------------------------------------------------------");
        for (List<String> listLine : listLines) {
            for (String s : listLine) {
                System.out.print(s);
                System.out.print("   ");
            }
            System.out.println("-------------");
        }
        System.out.println("------------------------------------------------------------------");

        int column = 0;
        int sizeLine = 0;
        for (int i = 0; i < choice; i++) {
            //column = 0;
            for (List<String> listLine : listLines) {
                if (listLine.size() > column) {
                    sizeLine = maxLine(listLine) - listLine.get(column).length();
                    System.out.print(listLine.get(column));
                    for (int j = 0; j <= sizeLine; j++) {
                        System.out.print(" ");
                    }
                        //System.out.print("sizeLine = " + sizeLine + " ");
                }
            }
            System.out.println();
            column++;
        }


//        for (int i = 0; i < strings.size(); i++) {
//            strMas[mass] = strings.get(i);
//            if(i % choice == 0){
//                mass++;
//            }
//        }

    }

    public static int maxLine(List<String> strings) {
        //int max = 0;
        int size = 0;
        for (String string : strings) {
            int sizeString = string.length();
            if (sizeString > size) {
                size = sizeString;
            }
        }
        return size;
    }

}

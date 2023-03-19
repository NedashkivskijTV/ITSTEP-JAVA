package edu.itstep.cw20220921repeat2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main09 {
    public static void main(String[] args) {
        String exit = "###exit###";

        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("one", "один");
        dictionary.put("two", "два");
        dictionary.put("three", "три");
        dictionary.put("four", "чотири");
        dictionary.put("five", "п'ять");
        dictionary.put("six", "шість");
        dictionary.put("seven", "сім");
        dictionary.put("eight", "вісім");
        dictionary.put("nine", "дев'ять");
        dictionary.put("ten", "десять");

        Scanner scanner = new Scanner(System.in);
        String userChoice = "", wordInEnglish = "";

        do {
            System.out.println();
            System.out.print("Enter word - ");

            userChoice = scanner.nextLine();

            if (userChoice.equals(exit)){
                break;
            }

            wordInEnglish = dictionary.get(userChoice);
            System.out.println(wordInEnglish == null ? "The word is absent in the dictionary": "A translation of a word - " + wordInEnglish);
        }while(true);

        System.out.println("\nThe program is completed");
    }
}

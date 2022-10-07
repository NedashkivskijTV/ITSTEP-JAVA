package edu.itstep.cw20220921.pr;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {
    Map<String, String> dictionary = new HashMap<>();

    public Dictionary() {
        dictionary.put("word", "слово");
        dictionary.put("conversation", "розмова");
        dictionary.put("class", "клас");
        dictionary.put("scheme", "схема");
        dictionary.put("advertisement", "оголошення");
        dictionary.put("phone", "телефон");
        dictionary.put("parameter", "параметр");
        dictionary.put("work", "робота");
        dictionary.put("reality", "дійсність");
        dictionary.put("appointment", "призначення");
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String exitText = "###exit###", choiceWord;

        do {
            System.out.print("Введіть слово англійською - ");
            choiceWord = scanner.nextLine();

            if (dictionary.get(choiceWord) == null) {
                System.out.println("Таке слово у словнику відсутнє");
            } else {
                System.out.println(dictionary.get(choiceWord));
            }

            System.out.println("Бажаєте вийти з програми? \n- для виходу наберіть ###exit###\n- для продовження - інший текст ");
        } while (!scanner.nextLine().equals(exitText));
    }
}

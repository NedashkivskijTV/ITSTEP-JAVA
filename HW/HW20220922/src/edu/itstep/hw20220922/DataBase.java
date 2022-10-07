package edu.itstep.hw20220922;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataBase {
    public static List<Question> getQuestion() {
        List<Question> questions = new ArrayList<>();
        String line;
        int startPos = 0, endPos;
        ArrayList<String> questionArr = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileInputStream("./src/edu/itstep/hw20220922/questions_base/questions.txt"));
            while (scanner.hasNextLine()) {
                questionArr.clear();
                line = scanner.nextLine();
                for (int i = 0; i < 5; i++) {
                    endPos = line.indexOf(";", startPos);
                    questionArr.add(line.substring(startPos, endPos));
                    startPos = endPos + 1;
                }
                startPos = 0;
                questions.add(new Question(questionArr.get(0), questionArr.get(1), questionArr.get(2), questionArr.get(3), questionArr.get(4)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return questions;
    }

}

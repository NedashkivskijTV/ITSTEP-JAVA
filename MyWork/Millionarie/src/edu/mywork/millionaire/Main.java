package edu.mywork.millionaire;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    public static void migrateQuestionsFromFileToDatabase() {
        //DataBase.createMillionaireQuestionsTable();
        DataBase.insertQuestionsFromFileToDatabase();

        List<Question> questionList = DataBase.getQuestionsFromDatabase();
        questionList.forEach(System.out::println);
    }
}

package edu.mywork.millionaire;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataBase {
    // Шлях до файлу, що зберігає список питань
    private final static String FILE_NAME = "./questions_base/questions.txt";

    // Параметри БД, що містять колекцію питань
    private final static String URL = "jdbc:postgresql://localhost/millionaire";
    private final static String USER_DB = "postgres";
    private final static String PASSWORD = "7777";


    /**
     * Отримання колекції питань з файлу
     *
     * @return - List<Question> - колекція питань
     */
    public static List<Question> getQuestionFromFile() {
        List<Question> questions = new ArrayList<>();
        String line;
        int startPos = 0, endPos;
        ArrayList<String> questionArr = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileInputStream(FILE_NAME));
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


    /**
     * Створення таблиці у БД
     */
    public static void createMillionaireQuestionsTable() {
        try (Connection connection = DriverManager.getConnection(URL, USER_DB, PASSWORD);
             Statement statement = connection.createStatement();) {
            statement.execute("CREATE TABLE IF NOT EXISTS millionaire_questions(id BIGSERIAL PRIMARY KEY NOT NULL, question VARCHAR NOT NULL, correctans VARCHAR NOT NULL, ans1 VARCHAR NOT NULL, ans2 VARCHAR NOT NULL, ans3 VARCHAR NOT NULL)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Додавання питання до БД
     *
     * @param question - об'єкт, який потрібно додати
     */
    public static void insertQuestion(Question question) {
        try (Connection connection = DriverManager.getConnection(URL, USER_DB, PASSWORD);
             Statement statement = connection.createStatement();) {
            String sql = String.format("INSERT INTO millionaire_questions(question, correctans, ans1, ans2, ans3) VALUES('%s','%s','%s','%s','%s')",
                    question.getQuestion(),
                    question.getRightAnswer(),
                    question.getAnswer1(),
                    question.getAnswer2(),
                    question.getAnswer3()
            );
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Перенос колекції питань з файлу до БД
     */
    public static void insertQuestionsFromFileToDatabase() {
        // Створення (у разі її відсутності) таблиці (для зберігання питань) в БД
        createMillionaireQuestionsTable();

        // Отримання колекції питань з файлу
        List<Question> questions = getQuestionFromFile();

        // Поелементне завантаження елементів, отриманих з файлу до БД
        for (Question question : questions) {
            insertQuestion(question);
        }
    }


    /**
     * Отримання колекції питань з бази даних
     * - має бути створено PostgreSQL БД з назвою millionaire
     *
     * @return - List<Question> - колекція об'єктів Question
     */
    public static List<Question> getQuestionsFromDatabase() {
        List<Question> questions = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER_DB, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM millionaire_questions");) {

            /** Опитування (опрос) об'єкта ResultSet, який містить елементи, зчитані з БД */
            while (resultSet.next()) {
                String question = resultSet.getString("question");
                String correctAns = resultSet.getString("correctans");
                String ans1 = resultSet.getString("ans1");
                String ans2 = resultSet.getString("ans2");
                String ans3 = resultSet.getString("ans3");

                questions.add(new Question(question, correctAns, ans1, ans2, ans3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questions;
    }

}

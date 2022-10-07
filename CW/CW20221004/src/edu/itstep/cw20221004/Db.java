package edu.itstep.cw20221004;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Db {
    private final static String URL = "jdbc:postgres://localhost/java";
    private final static String USER_DB = "postgres";
    private final static String PASSWORD = "7777";

    public static void createUsersTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USER_DB, PASSWORD);
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS users(id BIGSERIAL PRIMARY KEY NOT NULL, firstName VARCHAR(25) NOT NULL, lastName VARCHAR(25) NOT NULL)");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public static void insertUser(User user) {
        try (Connection connection = DriverManager.getConnection(URL, USER_DB, PASSWORD);
             Statement statement = connection.createStatement()) {

            statement.execute("INSERT INTO users(firstName, lastName)VALUES('" + user.getFirstName() + "', '" + user.getLastName() + "')");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<User> getOllUsers(){
        List<User> users = new ArrayList<>();


        return users;
    }

    //"UPDATE users SET firstName = '" + user.getFirstName() + "', lastName = '" + user.getLastName() + "' WHERE id = " + user.getId()


}

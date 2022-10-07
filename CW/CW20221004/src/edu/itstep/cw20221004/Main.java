package edu.itstep.cw20221004;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello !!!");

        Db.createUsersTable();
        User user = new User("Ivan", "Ivanenko");
    }
}

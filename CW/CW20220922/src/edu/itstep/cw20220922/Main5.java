package edu.itstep.cw20220922;

import java.io.*;

public class Main5 {
    public static void main(String[] args) {
/*
        User user = new User("Petro", "Petrenko");
        try {
            ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("./user.dat"));
            objectOutput.writeObject(user);

        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("./user.dat"));
            User user = (User) inputStream.readObject();
            System.out.println(user.getName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }
}

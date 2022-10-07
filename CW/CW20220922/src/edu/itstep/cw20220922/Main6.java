package edu.itstep.cw20220922;

import java.io.*;

public class Main6 {
    public static void main(String[] args) {
        User user = new User("Petro", "Petrenko");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(user);

        } catch (IOException e) {
            e.printStackTrace();
        }

/*
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream));
            User user = (User) inputStream.readObject();
            System.out.println(user.getName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
*/

    }
}

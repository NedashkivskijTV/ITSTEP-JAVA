package edu.itstep.cw20220922;

import com.google.gson.Gson;

public class Main4 {
    public static void main(String[] args) {
        // java maven repository

        Gson gson = new Gson();
        User user = new User("Ivan", "Ivanenko");

        String jsonUser = gson.toJson(user);
        System.out.println(jsonUser);

        user = null;

        User newUser = gson.fromJson(jsonUser, User.class);
        System.out.println(newUser.getSurName());
    }
}

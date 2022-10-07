package edu.itstep.cw20220922_repeat;

import com.google.gson.Gson;

public class Main06 {
    public static void main(String[] args) {
        Gson gson = new Gson();
        User user = new User("Ivan", "Ivanenko");

        String jsonUser = gson.toJson(user); // серіалізація - отримання інф про користувача у форматі json
        System.out.println(jsonUser); // {"firstName":"Ivan","lastName":"Ivanenko"}

        user = null; // видалення інф про користувача

        User newUser = gson.fromJson(jsonUser, User.class); // десеріалізація - створення об'єкта з послідовності байтів
        System.out.println(newUser.getFirstName()); // Ivan
    }
}

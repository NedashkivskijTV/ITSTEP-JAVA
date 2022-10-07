package edu.itstep.cw20221003.reflection;

import java.lang.reflect.Field;

public class Main1 {
    public static void main(String[] args) {
        User user = new User("Stepan", "Bandera");
        //System.out.println(user.firstName);
//        System.out.println(user.getLastName());
//        System.out.println(user.lastName);

        Class<? extends User> userClass = user.getClass();

        try {
            Field field = userClass.getDeclaredField("firstName");
            field.setAccessible(true);
            System.out.println(field.get(user));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

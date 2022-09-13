package edu.itstep.statics;

public class User {
    private String firstName;
    private String lastName;

    private static int count = 0;
    private int id;

    public User() {
        this.id = ++count;
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }
}

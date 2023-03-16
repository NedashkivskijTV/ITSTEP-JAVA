package edu.itstep.cw20220921repeat2;

import java.util.Set;
import java.util.TreeSet;

public class Main07 {
    public static void main(String[] args) {

        /** Використання колекції TreeSet для розміщення складних об'єктів */
        Set<User> users = new TreeSet<>();
        User user1 = new User("Ivan", "Ivanenko");
        User user2 = new User("Semen", "Semenenko");
        User user3 = new User("Ivan", "Ivanenko");
        User user4 = new User("Anton", "Ivanenko");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        System.out.println(users);

        /** Використання ітератора дає змогу перебрати колекцію у циклі */
        for (User user : users) {
            System.out.println(user);
        }

    }
}

class User implements Comparable<User>{
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    /** Реалізований метод, що застосовується при порівнянні екземплярів класу
     * - має бути пеалізований при реалізації інтерфейсу Comparable<> */
    @Override
    public int compareTo(User o) {
        return (this.lastName + this.firstName).compareTo(o.lastName + o.firstName);
    }
}
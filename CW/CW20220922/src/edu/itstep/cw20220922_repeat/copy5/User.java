package edu.itstep.cw20220922_repeat.copy5;

public class User {
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

    // фабричний метод - створює об'єкт на основі якихось даних
    public static User copy(User user){
        return new User(user.firstName, user.lastName);
    }
}

package edu.itstep.cw20220922_repeat.copy3;

public class User {
    private String firstName;
    private String lastName;
    private Address address;

    public User(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
    public User(User user) {
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        //this.address = user.address; // ПОМИЛКА !!! - копіює посилання замість створення об'єкта
                                     // - для виправлення у відповідному об'єкті також створити конструктор копіювання
        this.address = new Address(user.address);
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}

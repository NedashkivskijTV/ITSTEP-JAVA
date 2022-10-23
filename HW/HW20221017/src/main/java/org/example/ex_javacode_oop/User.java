package org.example.ex_javacode_oop;

import org.springframework.beans.factory.annotation.Value;

public class User {
    private String firstName;
    private String lastName;
    private Address address;

    public User(Address address) { // конструктор для впровадження залежності при використанні Java code (ООП)
        this.address = address;
    }

    public User(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    @Value("${user.firstName}")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Value("${user.lastName}")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}

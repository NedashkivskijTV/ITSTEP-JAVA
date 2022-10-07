package edu.itstep.cw20220922.copy3;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String surName;
    private Address address;

    public User(String name, String surName, Address address) {
        this.name = name;
        this.surName = surName;
        this.address = address;
    }

    public User(User user) {
        this.name = user.getName();
        this.surName = user.getSurName();
        this.address = new Address(user.address);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}

package edu.itstep.cw20220922.copy4;

import java.io.Serializable;

public class User implements Cloneable {
    private String name;
    private String surName;

    public User(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }
    public User(User user) {
        this.name = user.getName();
        this.surName = user.getSurName();
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

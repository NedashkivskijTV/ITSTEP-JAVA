package org.example;

import java.util.Arrays;

public class Profile {
    private String firstName;
    private String lastName;
    private String[] programmingLanguages;

    public Profile() {
    }

    public Profile(String firstName, String lastName, String[] programmingLanguages) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.programmingLanguages = programmingLanguages;
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

    public String[] getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(String[] programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", programmingLanguages=" + Arrays.toString(programmingLanguages) +
                '}';
    }
}

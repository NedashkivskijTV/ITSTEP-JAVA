package edu.itstep.hw20220914.comparator.Class;

import java.util.ArrayList;
import java.util.Arrays;

public class User {
    private String firstName;
    private String lastName;
    private Address address;
    private ArrayList<String> phoneNumbers;

    public User(String firstName, String lastName,
                String city, String streetAddress, int postalCode,
                String... phoneNumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = new Address(city, streetAddress, postalCode);
        this.phoneNumbers = new ArrayList<>();
        this.phoneNumbers.addAll(Arrays.asList(phoneNumbers));
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

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(ArrayList<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", \naddress=" + address +
                ", \nphoneNumbers=" + phoneNumbers +
                '}';
    }
}

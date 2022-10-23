package org.example.ex_javacode_oop;

import org.springframework.beans.factory.annotation.Value;

public class Address {
    private String city;
    private String street;
    private String buildingNumber;

    public Address() {
    }

    public Address(String city, String street, String buildingNumber) {
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
    }

    public String getCity() {
        return city;
    }

    @Value("${address.city}")
    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    @Value("${address.street}")
    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    @Value("${address.buildingNumber}")
    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                '}';
    }
}

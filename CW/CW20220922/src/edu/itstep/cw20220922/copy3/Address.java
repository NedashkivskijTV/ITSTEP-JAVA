package edu.itstep.cw20220922.copy3;

public class Address {
    private String name;
    private String number;

    public Address(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Address(Address address) {
        this.name = address.name;
        this.number = address.number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

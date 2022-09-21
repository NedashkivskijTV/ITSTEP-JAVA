package edu.itstep.hw20220914.comparator.anonymous_class;

public class Address {
    private String city;
    private String streetAddress;
    private int postalCode;

    public Address(String city, String streetAddress, int postalCode) {
        this.city = city;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}

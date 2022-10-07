package edu.itstep.hw20220921;

public class User {
    private String fullName;
    private int age;
    private Gender gender;
    private String email;
    private Country country;

    public User(String fullName, int age, Gender gender, String email, Country country) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.country = country;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", country=" + country +
                '}';
    }
}

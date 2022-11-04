package edu.itstep.mvc;

import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.Map;

public class User {

    @Size(min = 2, message = "first name must be min 2 symbols")
    @Pattern(regexp = "[A-Za-zА-Яа-яЁёҐґ]+")
    private String firstName;

    @NotBlank(message = "last name is required field")
    private String lastName;

    @Min(value = 16)
    @Max(value = 150)
    private int age;

    private Map<String, String> cities = new HashMap<>();

    private Map<String, String> genders = new HashMap<>();

    private Map<String, String> languages = new HashMap<>();

    {
        cities.put("Dn", "Dnepr");
        cities.put("Mr", "Mariupol");
        cities.put("Chb", "Chornobaevka");
        cities.put("Zt", "Zhytomyr");
        cities.put("Sev", "Sevastopol");

        genders.put("male", "male");
        genders.put("female", "female");
        genders.put("other", "other");

        languages.put("English", "En");
        languages.put("Ukrainian", "Uk");
        languages.put("Polish", "Pl");
    }

    private String city;
    private String gender;

    private String[] language;

    public User() {
    }

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public void setCities(Map<String, String> cities) {
        this.cities = cities;
    }

    public Map<String, String> getGenders() {
        return genders;
    }

    public void setGenders(Map<String, String> genders) {
        this.genders = genders;
    }

    public Map<String, String> getLanguages() {
        return languages;
    }

    public void setLanguages(Map<String, String> languages) {
        this.languages = languages;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getLanguage() {
        return language;
    }

    public void setLanguage(String[] language) {
        this.language = language;
    }
}

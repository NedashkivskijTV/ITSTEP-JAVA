package edu.itstep.mvc;

import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class User {
    @Size(min = 2, max = 50, message = "First  name mast be in 2 symbols")
    @NotBlank(message = "First name is required field")
    @Pattern(regexp = "([A-Za-zА-Яа-яЁё]+)")
    private String firstName;
    @NotBlank(message = "Last name is required field")
    private String lastName;
    @Min(value = 16)
    @Max(value = 100)
    private int age;

    //----------- другорядні поля - не включені до параметрів конструктора ---------------------------------------------
    private String city;

    @NotBlank(message = "Field is required")
    private String gender;

    private String[] languages;

    //----------- допоміжні поля, блоки ініціалізації, гетери/сетери для передачі вмісту випадаючих списків - імітація звернення до БД ---------------------
//    // надмірність (избыточность) - поле ддя передачі в моделі списку міст для вибору у випадаючому списку представлення (form - select - options)
/*
    private Map<String, String> cities = new HashMap<>();
    private Map<String, String> genders = new HashMap<>();
    private Map<String, String> languagesList = new HashMap<>();
*/
/*
    { // надмірність (избыточность) - блок ініціалізації списку міст - імітація отримання даних з БД
        cities.put("Dnipro", "Dn");
        cities.put("Mariupol", "Mr");
        cities.put("Chornobaivka", "Chb");
        cities.put("Zhytomyr", "Zt");
        cities.put("Sevastopol", "Sev");
    }
*/

    // надмірність (избыточность) - використовуються при підключенні поля Map<String, String> cities та його використанні для передачі списку міст у моделі
/*    public Map<String, String> getCities() {
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

    public Map<String, String> getLanguagesList() {
        return languagesList;
    }

    public void setLanguagesList(Map<String, String> languagesList) {
        this.languagesList = languagesList;
    }*/
    //------------------------------------------------------------------------------------------------------------------

    public User() {
    }

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

        //this.cities = DataBase.getCities(); // варіант наповнення колекції для випадаючого списка міст - звернення до БД відбудеться при створенні об'єкта User
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

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", gender='" + gender + '\'' +
                ", languages=" + Arrays.toString(languages) +
                '}';
    }
}

package edu.itstep.mvc;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
    public static Map<String, String> getCities(){
        Map<String, String> cities = new HashMap<>();
        cities.put("Dnipro", "Dn");
        cities.put("Mariupol", "Mr");
        cities.put("Chornobaivka", "Chb");
        cities.put("Zhytomyr", "Zt");
        cities.put("Sevastopol", "Sev");
        return cities;
    }

    public static Map<String, String> getGenders(){
        Map<String, String> genders = new HashMap<>();
        genders.put("male", "male");
        genders.put("female", "female");
        genders.put("other", "other");
        return genders;
    }

    public static Map<String, String> getLanguages(){
        Map<String, String> languages = new HashMap<>();
        languages.put("English", "En");
        languages.put("Ukrainian", "Ukr");
        languages.put("Deutsch", "Dch");
        languages.put("Francais", "Fra");
        languages.put("Espanol", "Esp");
        return languages;
    }

}

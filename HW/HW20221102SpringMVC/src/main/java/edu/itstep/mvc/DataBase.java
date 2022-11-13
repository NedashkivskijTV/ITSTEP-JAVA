package edu.itstep.mvc;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
    public static Map<String, String> getGenders(){
        Map<String, String> genders = new HashMap<>();
        genders.put("other", "other");
        genders.put("female", "female");
        genders.put("male", "male");
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
    public static Map<String, String> getInfoSources(){
        Map<String, String> infoSources = new HashMap<>();
        infoSources.put("", " ");
        infoSources.put("advertising", "advertising");
        infoSources.put("mass media", "mass media");
        infoSources.put("Internet", "Internet");
        infoSources.put("friends", "friends");
        infoSources.put("other", "other");
        return infoSources;
    }

}

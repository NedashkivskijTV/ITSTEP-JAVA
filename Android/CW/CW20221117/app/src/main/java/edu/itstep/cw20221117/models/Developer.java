package edu.itstep.cw20221117.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Developer implements Serializable {
    private String tagline;
    private String gender = "male";
    private List<String> softSkills = new ArrayList<>();

    public Developer() {
    }

    public void addSkills(String skill){
        softSkills.add(skill);
    }

//    public void dellSkill(String skill){
//        softSkills.add(skill);
//    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getSoftSkills() {
        return softSkills;
    }

    public void setSoftSkills(List<String> softSkills) {
        this.softSkills = softSkills;
    }
}

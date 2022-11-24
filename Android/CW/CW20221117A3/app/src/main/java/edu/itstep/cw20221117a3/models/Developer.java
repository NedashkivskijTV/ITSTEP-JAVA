package edu.itstep.cw20221117a3.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Developer implements Serializable {
    private String tagLine;
    private String gender;
    private List<String> softSkills = new ArrayList<>();

    public Developer() {
    }

    public String getTagLine() {
        return tagLine;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
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

    public void addSkill(String skill){
        softSkills.add(skill);
    }
}

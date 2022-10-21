package org.example.ex7;

public class Student {
    private String fullName;
    private int age;
    private double avgGrade;

    public Student(String fullName, int age, double avgGrade) {
        this.fullName = fullName;
        this.age = age;
        this.avgGrade = avgGrade;
    }


    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", avgGrade=" + avgGrade +
                '}';
    }
}

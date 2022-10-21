package org.example.ex8;

public class Student {
    private String fullName;
    private int age;
    private double avgGrade;

    public Student(String fullName, int age, double avgGrade) {
        this.fullName = fullName;
        this.age = age;
        this.avgGrade = avgGrade;
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

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
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

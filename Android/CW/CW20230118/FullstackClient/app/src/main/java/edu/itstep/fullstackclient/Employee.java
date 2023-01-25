package edu.itstep.fullstackclient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employee {

    @Expose // анотація вказує, що поле буде серіалізуватись
    @SerializedName("id") // назва поля може відрізнятись від назви, вказаної у JSON - вказується яке саме поле з JSON відповідатиме полю в класі
    private int id;

    @Expose // анотація вказує, що поле буде серіалізуватись
    @SerializedName("firstName") // назва поля може відрізнятись від назви, вказаної у JSON - вказується яке саме поле з JSON відповідатиме полю в класі
    private String firstName;

    @Expose // анотація вказує, що поле буде серіалізуватись
    @SerializedName("lastName") // назва поля може відрізнятись від назви, вказаної у JSON - вказується яке саме поле з JSON відповідатиме полю в класі
    private String lastName;

    @Expose // анотація вказує, що поле буде серіалізуватись
    @SerializedName("department") // назва поля може відрізнятись від назви, вказаної у JSON - вказується яке саме поле з JSON відповідатиме полю в класі
    private String department;

    @Expose // анотація вказує, що поле буде серіалізуватись
    @SerializedName("salary") // назва поля може відрізнятись від назви, вказаної у JSON - вказується яке саме поле з JSON відповідатиме полю в класі
    private int salary;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

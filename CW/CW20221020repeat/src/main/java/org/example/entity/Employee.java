package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // анотація потрібна при наявності зв'язків з іншими таблицями, (може бути відсутня при 1 таблиці)
    // має атрибут strategy, де обирається тип стратегії - яким саме чином будуть створюватись ці айдішники
    // є 4 варіанти стратегій - TABLE - неефективний - для id створюється службова таблиця
    // SEQUENCE - допомагає робити діапазони (id від 1 до 10 та повторюється, але не унікальний)
    // IDENTITY - самий розповсюджений - внутрішній механізм роботи інкременту
    // AUTO - автоматичний вибір в залежності від обраної СУБД - на сьогоднішній день для MySQL відповідатиме (скоріше за все) IDENTITY
    private int id;
    @Column(name="first_name")
    private String  firstName;
    @Column(name="last_name")
    private String  lastName;
    @Column(name="department")
    private String  department;
    @Column(name="salary")
    private int  salary;

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

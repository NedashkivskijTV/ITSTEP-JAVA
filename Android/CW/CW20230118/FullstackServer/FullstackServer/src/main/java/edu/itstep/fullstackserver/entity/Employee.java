package edu.itstep.fullstackserver.entity;

import jakarta.persistence.*;

@Entity // вказує, що даний клас матиме відображення у БД - на основі класу було створено відповідну сутність
@Table(name = "employees") // вказання назви таблиці до якої буде прив’язано клас (у разі відсутності атрибута name буде шукати таблицю відповідно до імені класу без урахування регістра)
public class Employee {

    @Id // вказує, що в БД є колонка, пов’язана з даним полем, та являється primary key (первинним ключем)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // анотація потрібна при наявності зв'язків з іншими таблицями, (може бути відсутня при 1 таблиці) – має атрибут strategy, де обирається тип стратегії - яким саме чином будуть створюватись ці айдішники є 4 варіанти стратегій
    @Column(name = "id") // з’єднання полів класу з колонками таблиці - якщо назва поля та колонки співпадають може вказуватимь без параметрів
    private int id;

    @Column(name = "first_name") // з’єднання полів класу з колонками таблиці - якщо назва поля та колонки співпадають може вказуватимь без параметрів
    private String firstName;

    @Column(name = "last_name") // з’єднання полів класу з колонками таблиці - якщо назва поля та колонки співпадають може вказуватимь без параметрів
    private String lastName;

    @Column(name = "department") // з’єднання полів класу з колонками таблиці - якщо назва поля та колонки співпадають може вказуватимь без параметрів
    private String department;

    @Column(name = "salary") // з’єднання полів класу з колонками таблиці - якщо назва поля та колонки співпадають може вказуватимь без параметрів
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

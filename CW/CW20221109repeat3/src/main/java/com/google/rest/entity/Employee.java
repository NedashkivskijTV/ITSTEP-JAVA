package com.google.rest.entity;

import javax.persistence.*;

@Entity  // – позначає сутність - на основі даного об'єкта буде створено бін, планується зв'зок даної сутності з БД
@Table(name = "employees") // – зв'язок сутності з таблицею БД
public class Employee {
    @Id // – позначає первинний ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) // – визначає стратегію генерації унікального ідентифікатора - id (IDENTITY - стратегія (найпопулярніша), що реалізується/пропонується в самій БД за замовчуванням)
    @Column(name = "id") // –  зв'язок поля з колонкою таблиці (якщо назва поля та колонки співпадають дозволяється використовувати без атрибута - @Column)
    private int id;

    @Column(name = "first_name") // –  зв'язок поля з колонкою таблиці (якщо назва поля та колонки співпадають дозволяється використовувати без атрибута - @Column)
    private String firstname;

    @Column(name = "last_name") // –  зв'язок поля з колонкою таблиці (якщо назва поля та колонки співпадають дозволяється використовувати без атрибута - @Column)
    private String lastname;

    @Column(name = "department") // –  зв'язок поля з колонкою таблиці (якщо назва поля та колонки співпадають дозволяється використовувати без атрибута - @Column)
    private String department;

    @Column(name = "salary") // –  зв'язок поля з колонкою таблиці (якщо назва поля та колонки співпадають дозволяється використовувати без атрибута - @Column)
    private int salary;

    public Employee() {
    }

    public Employee(String firstname, String lastname, String department, int salary) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

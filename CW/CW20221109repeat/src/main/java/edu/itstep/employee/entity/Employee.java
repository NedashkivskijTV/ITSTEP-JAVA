package edu.itstep.employee.entity;

import javax.persistence.*;

@Entity  // – позначає сутність - на основі даного об'єкта буде створено бін, планується зв'зок даної сутності з БД
@Table(name = "employees") // – зв'язок сутності з таблицею БД
public class Employee {
    @Id // – позначає первинний ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) // – визначає стратегію генерації унікального ідентифікатора - id (IDENTITY - стратегія (найпопулярніша), що реалізується/пропонується в самій БД за замовчуванням)
    @Column(name = "id") // –  зв'язок поля з колонкою таблиці (якщо назва поля та колонки співпадають дозволяється використовувати без атрибута - @Column)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "department")
    private String department;

    @Column(name = "salary")
    private int salary;

    public Employee(String firstName, String lastName, String department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

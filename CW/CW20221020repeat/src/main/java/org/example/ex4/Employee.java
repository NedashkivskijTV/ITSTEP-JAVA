package org.example.ex4;

import javax.persistence.*;

@Entity // позначає сутність - на основі даного об'єкта буде створено бін
@Table(name = "employees") // зв'язок сутності з таблицею
public class Employee {

    @Id // позначає первинний ключ
    @Column(name = "id") // зв'язок поля з колонкою таблиці
    @GeneratedValue(strategy = GenerationType.IDENTITY) // визначає стратегію генерації унікального ідентифікатора - id (IDENTITY - стратегія (найпопулярніша), що реалізується в БД за замовчуванням)
    private int id;

    @Column(name = "first_name") // зв'язок поля з колонкою таблиці
    private String firstName;

    @Column(name = "last_name") // зв'язок поля з колонкою таблиці
    private String lastName;

    @Column(name = "price") // зв'язок поля з колонкою таблиці
    private int price;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    // вид зв'язків, що використовуються між таблицями Employee та Department -
    // слід розуміти, що має бути обрана анотація, що відображає зв'язок від поточного класу (Employee) до пов'язаного класу (Department)
    // тобто багато працівників можуть працювати у одному відділі (у класі Department буде обрано @OneToMany)
    // При обранні типу каскадності cascade = CascadeType.ALL не підійде, оскільки при видаленні департаменту видаляться усі пов'язані працівники
    // слід використовувати масив типів окрім REMOVE, ALL
    @JoinColumn(name = "departments_id") // принцип об'єднання таблиць (вторинний ключ) - по якому полю (колонка в таблиці employees в БД) таблиця Employee зв'язується з табл departments (атрибут name = "departments_id" приймає назву колонки з БД
    // анотація @JoinColumn вказується у класі, що відповідає таблиці в БД, де вказано вторинний ключ. У іншій таблиці до анотації @OneToMany буде додано атрибут mappedBy = "department"
    private Department department;

    public Employee() {
    }

    public Employee(String firstName, String lastName, int price) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", price=" + price +
                '}';
    }
}

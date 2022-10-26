package org.example.ex2;

import javax.persistence.*;

@Entity // позначає сутність - на основі даного об'єкта буде створено бін
@Table(name = "employees") // зв'язок сутності з таблице
public class Employee {

    @Id // позначає первинний ключ
    @Column(name = "id") // зв'язок поля з колонкою таблиці
    @GeneratedValue(strategy = GenerationType.IDENTITY) // визначає стратегію генерації унікального ідентифікатора - id (IDENTITY - стратегія (найпопулярніша), що реалізується в БД за замовчуванням)
    private int id;

    @Column(name = "first_name") // зв'язок поля з колонкою таблиці
    private String firstName;

    @Column(name = "last_name") // зв'язок поля з колонкою таблиці
    private String lastName;

    @Column(name = "department") // зв'язок поля з колонкою таблиці
    private String department;
    @OneToOne(cascade = CascadeType.ALL) // вид зв'язків, що використовуються між таблицями Employee та Detail та Каскадність, що задається через ENUM константи, які визначають поведінку при різних діях з інф в БД (видалення, зміна…) - CascadeType.ALL визначає найбільш поширену поведінку для усіх маніпуляцій
    @JoinColumn(name = "details_id") // принцип об'єднання таблиць (вторинний ключ) - по якому полю (колонка в таблиці employees в БД) таблиця Employee зв'язується з табл Detail (атрибут name = "details_id" приймає назву колонки з БД)
    private Detail detail; // сутність Detail – при зверненні до об’єкта Employee з нього одразу можна буде отримати детальну інформацію (Hibernate сам пов’яже дані)

    public Employee() {
    }

    public Employee(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
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

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}

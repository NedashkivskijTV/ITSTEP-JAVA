package org.example.ex3;

import javax.persistence.*;

@Entity // позначає сутність - на основі даного об'єкта буде створено бін
@Table(name = "details") // зв'язок сутності з таблицею
public class Detail {

    @Id // позначає первинний ключ
    @Column(name = "id") // зв'язок поля з колонкою таблиці
    @GeneratedValue(strategy = GenerationType.IDENTITY) // визначає стратегію генерації унікального ідентифікатора - id (IDENTITY - стратегія (найпопулярніша), що реалізується в БД за замовчуванням)
    private int id;

//    @Column(name = "city") // зв'язок поля з колонкою таблиці
//    private String city;

    @Column(name = "email") // зв'язок поля з колонкою таблиці
    private String email;

    @Column(name = "phone") // зв'язок поля з колонкою таблиці
    private String phone;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "detail")// вид зв'язків, що використовуються між таблицями Employee та Detail та Каскадність, що задається через ENUM константи, які визначають поведінку при різних діях з інф в БД (видалення, зміна…) - CascadeType.ALL визначає найбільш поширену поведінку для усіх маніпуляцій
    private Employee employee ; // сутність Employee – при зверненні до об’єкта Employee з нього одразу можна буде отримати детальну інформацію (Hibernate сам пов’яже дані)

    public Detail() {
    }

    public Detail(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

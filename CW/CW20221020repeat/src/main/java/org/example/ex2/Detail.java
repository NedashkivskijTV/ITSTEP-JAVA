package org.example.ex2;

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

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

package org.example.ex2;

import javax.persistence.*;

@Entity
@Table(name="details")
public class Detail {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(name="city")
//    private String city;

    @Column(name="email")
    private String email;

    @Column(name="phone")
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

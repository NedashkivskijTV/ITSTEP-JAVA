package org.example.ex5;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // – позначає сутність - на основі даного об'єкта буде створено бін, планується зв'зок даної сутності з БД
@Table(name = "children") // – зв'язок сутності з таблицею БД
public class Child {

    @Id // – позначає первинний ключ
    @Column(name = "id") // – зв'язок поля з колонкою таблиці (якщо назва поля та колонки співпадають дозволяється використовувати без атрибута - @Column)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // – визначає стратегію генерації унікального ідентифікатора - id (IDENTITY - стратегія (найпопулярніша), що реалізується/пропонується в самій БД за замовчуванням)
    private int id;

    @Column(name = "first_name")
    // – зв'язок поля з колонкою таблиці (якщо назва поля та колонки співпадають дозволяється використовувати без атрибута - @Column)
    private String firstName;

    @Column(name = "last_name")
    // – зв'язок поля з колонкою таблиці (якщо назва поля та колонки співпадають дозволяється використовувати без атрибута - @Column)
    private String lastName;

    @Column(name = "age")
    // – зв'язок поля з колонкою таблиці (якщо назва поля та колонки співпадають дозволяється використовувати без атрибута - @Column)
    private int age;

    /*
     При створенні класу додаються поле для зберігання інф про список секцій, пов’язаних з даним Child
     (колекція - private List<Section> sections = new ArrayList<>();),
     пустий конструктор,
     конструктор з параметрами (окрім id та поля, що відповідає за вторинний ключ),
     гетери та сетери (окрім сетера для id та сетера для встановлення колекції пов’язаних елементів - секцій),
     перевизначається метод toString() (без виведення поля з колекцією пов’язаних елементів),
     також створюється метод для додавання нових секцій до колекції пов’язаних елементів
     (public void addSection(Section section){ sections.add(section); })
    */

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}) // тип відношення - вид зв'язків, що використовуються між таблицями Child та Section –––  КАСКАДНІСТЬ – При обранні типу каскадності cascade = CascadeType.ALL не підійде, оскільки при видаленні Child видаляться усі пов'язані Section (та навпаки) – слід використовувати масив типів окрім REMOVE, ALL (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinTable(name = "children_sections",
            joinColumns = @JoinColumn(name = "children_id"),
            inverseJoinColumns = @JoinColumn(name = "sections_id")) // зв'язок з таблицею об'єднання - АТРИБУТИ - name = "children_sections" - приймає назву проміжної таблиці в БД, (joinColumns = @JoinColumn(name = "children_id") - цільова таблиця - приймає назву колонки проміжної таблиці, де зберігатиметься id об'єкта поточного класу (Child), який зв'язуватиметься з об'єктом Section  - (inverseJoinColumns = @JoinColumn(name = "sections_id")) - другорядна таблиця - приймає назву колонки проміжної таблиці, де зберігатиметься id об'єкта (Section), пов'язаного з об'єктом поточного класу (Child) - у пов'язаній таблиці назви полів поміняються місцями
    private List<Section> sections = new ArrayList<>(); // поле для зберігання інф про список об'єктів (Section) пов'язаних з поточним об'єктом (класом Child)

    public Child() {
    }

    public Child(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Section> getSections() {
        return sections;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    // метод для додавання нових секцій до колекції пов’язаних елементів
    public void addSection(Section section) {
        sections.add(section);
    }
}

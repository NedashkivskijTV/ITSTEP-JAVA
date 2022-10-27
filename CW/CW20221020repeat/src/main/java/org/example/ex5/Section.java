package org.example.ex5;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // – позначає сутність - на основі даного об'єкта буде створено бін, планується зв'зок даної сутності з БД
@Table(name = "sections") // – зв'язок сутності з таблицею БД
public class Section {

    @Id // – позначає первинний ключ
    @Column(name = "id")
    // – зв'язок поля з колонкою таблиці (якщо назва поля та колонки співпадають дозволяється використовувати без атрибута - @Column)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // – визначає стратегію генерації унікального ідентифікатора - id (IDENTITY - стратегія (найпопулярніша), що реалізується/пропонується в самій БД за замовчуванням)
    private int id;

    @Column(name = "name")
    // – зв'язок поля з колонкою таблиці (якщо назва поля та колонки співпадають дозволяється використовувати без атрибута - @Column)
    private String name;

    @Column(name = "price")
    // – зв'язок поля з колонкою таблиці (якщо назва поля та колонки співпадають дозволяється використовувати без атрибута - @Column)
    private int price;

    /*
    При створенні класу додаються : поле для зберігання інф про список дітей,
    пов’язаних з даним об’єктом Section (колекція -
    private List<Child> children = new ArrayList<>(); - відповідає за вторинний ключ),
    пустий конструктор, конструктор з параметрами  (окрім id та поля, що відповідає за вторинний ключ),
    гетери та сетери (окрім сетера для id та сетера для встановлення колекції пов’язаних елементів - дітей),
    перевизначається метод toString() (без виведення поля з колекцією пов’язаних елементів),
    також створюється метод для додавання нових Child до колекції пов’язаних  елементів
    (public void addChild(Child child){ children.add(child); })
     */

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    // тип відношення - вид зв'язків, що використовуються між таблицями Child та Section –––  КАСКАДНІСТЬ – При обранні типу каскадності cascade = CascadeType.ALL не підійде, оскільки при видаленні Child видаляться усі пов'язані Section (та навпаки) – слід використовувати масив типів окрім REMOVE, ALL (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    //@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "children_sections",
            joinColumns = @JoinColumn(name = "sections_id"),
            inverseJoinColumns = @JoinColumn(name = "children_id"))
    // зв'язок з таблицею об'єднання - АТРИБУТИ - name = "children_sections" - приймає назву проміжної таблиці в БД, (joinColumns = @JoinColumn(name = "sections_id") - цільова таблиця - приймає назву колонки проміжної таблиці, де зберігатиметься id об'єкта поточного класу (Section), який зв'язуватиметься з об'єктом Child  - (inverseJoinColumns = @JoinColumn(name = "children_id")) - другорядна таблиця - приймає назву колонки проміжної таблиці, де зберігатиметься id об'єкта (Child), пов'язаного з об'єктом поточного класу (Section) - у пов'язаній таблиці назви полів поміняються місцями
    private List<Child> children = new ArrayList<>(); // поле для зберігання інф про список об'єктів (Child) пов'язаних з поточним об'єктом (класом Section)

    public Section() {
    }

    public Section(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Child> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    // метод для додавання нових Child до колекції пов’язаних  елементів
    public void addChild(Child child) {
        children.add(child);
    }
}

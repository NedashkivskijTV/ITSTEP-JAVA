package org.example.ex5;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sections")
public class Section {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    //@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "children_sections",
            joinColumns = @JoinColumn(name = "sections_id"),
            inverseJoinColumns = @JoinColumn(name = "children_id"))
    private List<Child> children = new ArrayList<>();

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

    public void addChild(Child child){
        children.add(child);
    }
}

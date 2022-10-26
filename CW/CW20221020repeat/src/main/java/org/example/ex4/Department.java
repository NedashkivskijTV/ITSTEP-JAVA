package org.example.ex4;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // позначає сутність - на основі даного об'єкта буде створено бін
@Table(name = "departments") // зв'язок сутності з таблицею
public class Department {

    @Id // позначає первинний ключ
    @Column(name = "id") // зв'язок поля з колонкою таблиці
    @GeneratedValue(strategy = GenerationType.IDENTITY) // визначає стратегію генерації унікального ідентифікатора - id (IDENTITY - стратегія (найпопулярніша), що реалізується в БД за замовчуванням)
    private int id;

    @Column(name = "name") // зв'язок поля з колонкою таблиці
    private String name;

    @Column(name = "min_salary") // зв'язок поля з колонкою таблиці
    private int minSalary;

    @Column(name = "max_salary") // зв'язок поля з колонкою таблиці
    private int maxSalary;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    // вид зв'язків, що використовуються між таблицями Department та Employee -
    // слід розуміти, що має бути обрана анотація, що відображає зв'язок від поточного класу (Department) до пов'язаного класу (Employee)
    // тобто в дному департаменті можуть працювати  багато працівників  (у класі Employee буде обрано @ManyToOne)
    //
    // АТРИБУТ mappedBy = "department" пов'язує даний клас з класом у якому зберігається вторинний ключ
    // - Employee та передається назва поля у атрибуті @JoinColumn якого описується принцип об'єднання таблиць (вторинний ключ)
    //
    // КАСКАДНІСТЬ - CascadeType.ALL - при видаленні департаменту буде видалено усіх пов'язаних працівників (потрібно виходити від ЗАДАЧІ!!!)
    private List<Employee> employees = new ArrayList<>(); // поле для зберігання інф про пов'язаних з департаментом пррацівників

    public Department() {
    }

    public Department(String name, int minSalary, int maxSalary) {
        this.name = name;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
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

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }

    public void addEmployee(Employee employee){ // метод додавання співробітника до департаменту, також додає співторібнику інф про департамент
        employees.add(employee);
        employee.setDepartment(this);
    }
}

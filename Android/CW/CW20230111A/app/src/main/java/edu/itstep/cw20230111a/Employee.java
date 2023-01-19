package edu.itstep.cw20230111a;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//@Entity // для Room DB - сутність - вказує на те, що даний клас буде мати відображення у БД
@Entity(tableName = "employees") // для Room DB - сутність - вказує на те, що даний клас буде мати відображення у БД
// Якщо ім'я класу не співпадає з назвою таблиці для якої зроблено дану модель, використовується атрибут tableName анотації @Entity
// атрибут tableName приймає рядок - назву таблиці
public class Employee {

    @PrimaryKey(autoGenerate = true) // вказує на поле, що зберігає інф про первинний ключ у даній таблиці
    // Атрибут autoGenerate прописується при необхідності автогенерування id (практично завжди потрібно)
    // за замовчуванням атрибут autoGenerate = false !!!
    public long id;

    @ColumnInfo(name = "name") // пов'язує поле класу з колонкою таблиці
    public String name;

    @ColumnInfo(name = "salary") // пов'язує поле класу з колонкою таблиці
    public int salary;
}

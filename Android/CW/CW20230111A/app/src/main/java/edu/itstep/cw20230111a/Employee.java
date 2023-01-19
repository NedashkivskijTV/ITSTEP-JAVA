package edu.itstep.cw20230111a;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity // для Room DB - сутність - вказує на те, що даний клас буде мати відображення у БД
public class Employee {

    @PrimaryKey(autoGenerate = true) // вказує на поле, що зберігає інф про первинний ключ у даній таблиці
    public long id;

    @ColumnInfo(name = "name") // пов'язує поле класу з колонкою таблиці
    public String name;

    @ColumnInfo(name = "salary") // пов'язує поле класу з колонкою таблиці
    public int salary;
}

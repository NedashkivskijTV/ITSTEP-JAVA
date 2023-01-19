package edu.itstep.cw20230111a;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Employee.class}, version = 1) // вказує що це не звичайний клас, а клас з конфігураціями для БД, в параметрах вказуються класи, що є сутностями (у {} через ,) та версія БД (змінюється при оновленні програми)
public abstract class AppDatabase extends RoomDatabase {
    public abstract EmployeeDao employeeDao();
}
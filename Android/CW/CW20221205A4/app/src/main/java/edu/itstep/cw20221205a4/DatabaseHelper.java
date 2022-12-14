package edu.itstep.cw20221205a4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    //При створенні об’єкта даного класу (спрацювання конструктора) потрібно буде передати до батьківського конструктора (через super)
    // - контекст (анотацію @Nullable можна прибрати),
    // - name – назву БД – можна захардкодити, оскільки використовується при зверненні до декількох БД, з параметрів методу можна прибрати
    // - CursorFactory – курсор це об’єкт, котрий зберігає інф про вибірку з БД + додаткову функціональність – у прикладі використовуватись не буде, передамо null, або можна прибрати з параметрів методу
    // - Версія БД – при оновленні БД цей параметр потрібно змінювати – передаватись не буде, можна прибрати з параметрів методу

    // Первинний вигляд конструктора
//    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }

    // Зкорегований конструктор
    public DatabaseHelper(Context context) {
        super(context, "PhoneBook", null, 1);
        //super(context, "PhoneBook", null, 2); // конструкція для емуляції оновлення застосунку - спрацьовує метод onUpgrade !!!

        // Створення логів - при виклику конструктора у консоль виведеться повідомлення
        // Для перегляду створених логів потрібно створити фільтр
        // - вкладка Logcat, вверху зправа випадаючий список Show only selected application
        // - обрати рядок Edit Filter Configuration
        // - вікно Create New Logcat Filter - поле Log Tag: - вказати тег dbExec
        // - в полі Lo Level - обрати Debug
        // - OK
        Log.d("dbExec", "DatabaseHelper");
    }

    // Спрацьовує 1 раз при першому запуску мобільного додатку на телефоні
    // відповідає за створення структури БД
    // метод потребує реалізації, а викликається системою
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Створення логів - при виклику метода onCreate у консоль виведеться повідомлення
        Log.d("dbExec", "onCreate");

        // sqLiteDatabase - об'єкт, що надається SQLiteOpenHelper
        // та використовується для здійснення маніпуляцій з БД

        // Створення таблиці contacts, метод execSQL виконує запит, але нічого не повертає !!!
        sqLiteDatabase.execSQL("CREATE TABLE contacts(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone TEXT)");

        // Наповнення створеної таблиці тестовими даними
        sqLiteDatabase.execSQL("INSERT INTO contacts(name, phone) VALUES('Ivan Ivanenko', '+380-50-111-22-33')");
        sqLiteDatabase.execSQL("INSERT INTO contacts(name, phone) VALUES('Petro', '+380-77-112-22-32')");
    }

    // Викликається при оновленні додатку
    // Приймає в параметри номери старої та нової версій для забезпеченні різного алгоритму оновлення
    // в залежності від того з якої і до якої версії здійснюється оновлення, а в об'єкті sqLiteDatabase може бути реалізований switch з вибором алгоритмів
    // Метод потребує реалізації, а викликається системою
    // Буде викликаний, якщо змінитьмя параметр version - версія додатку (для оновлення)
    @Override
    //public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // Створення логів - при виклику метода onUpgrade у консоль виведеться повідомлення
        Log.d("dbExec", "onUpgrade");
    }
}

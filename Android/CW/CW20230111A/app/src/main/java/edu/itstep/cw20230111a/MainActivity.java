package edu.itstep.cw20230111a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDb = findViewById(R.id.tvDb);

        // Отримання БД
        AppDatabase db = App.getInstance().getDatabase();

        // Отримання посилання на об'єкт класу, котрий реалізує інтерфейс EmployeeDao
        // (там описуються методи взаємодії з БД, які буде реалізовувати ROOM за допомогою рефлекції)
        EmployeeDao employeeDao = db.employeeDao();


        // Виклик методів взаємодії з БД (CRUD операції)
        // Вставка - імітація роботи з БД - при запуску Актівіті спрацює даний метод, який містить код
        // щодо додавання до щойноствреної (або створеної ранішне при попередніх запусках) БД об'єкта Employee
        Employee employee = new Employee();
        //employee.id = 1;
        employee.name = "John Smith";
        employee.salary = 10000;

        employeeDao.insert(employee); // команда на додавання даних до БД
    }
}

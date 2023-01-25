package edu.itstep.fullstackclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tvEmployee;
    private Button btnShawAllEmployees;
    private Button btnNewEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvEmployee = findViewById(R.id.tvEmployee);
        btnShawAllEmployees = findViewById(R.id.btnShawAllEmployees);
        btnNewEmployee = findViewById(R.id.btnNewEmployee);

        btnNewEmployee.setOnClickListener(v -> {
            NetworkService
                    .getInstance()
                    .getEmployeeApi()
                    .saveEmployee(new Employee("Dean", "Winchester", "IT", 7000))
                    .enqueue(new Callback<Employee>() {
                        @Override
                        public void onResponse(Call<Employee> call, Response<Employee> response) {
                            Employee employee = response.body();
                            Toast.makeText(MainActivity.this, employee.toString(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Employee> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "ERROR: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        });



        //EmployeeApi employeeApi = NetworkService.getInstance().getEmployeeApi(); // отримання EmployeeApi - класу, що реалізує інтерфейс EmployeeApi, що в свою чергу, описує методи взаємодії з БД
        //employeeApi.getAllEmployees().enqueue(...); // виклик методу, що поверне список усіх елементів Employee, даний метод повертає об'єкт Call, який ставиться у чергу на виконання - для виконання потребує виклику методу .enqueue()

        //Компактний вигляд вищевказаних методів
        NetworkService
                .getInstance()
                .getEmployeeApi()
                .getAllEmployees()
                .enqueue(new Callback<List<Employee>>() {

                    // Метод виконається в момент отримання результату запиту з сервера
                    @Override
                    public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                        List<Employee> employees = response.body(); // отримання колекції об'єктів Employee з об'єкта response
                        //tvEmployee.setText(employees.get(0).getFirstName()); // поміщення у текстове поле інформації, отриманої з колекції
                        tvEmployee.setText(employees.get(1).toString()); // поміщення у текстове поле інформації, отриманої з колекції
                    }

                    // Метод виконається при виникненні помилки
                    @Override
                    public void onFailure(Call<List<Employee>> call, Throwable t) {
                        //Toast.makeText(MainActivity.this, "ERROR: " + t.getMessage(), Toast.LENGTH_SHORT).show(); // виведення тексту помилки у тостове повідомлення
                        tvEmployee.setText(t.getMessage()); // виведення тексту помилки у текстове поле
                    }
                });

        btnShawAllEmployees.setOnClickListener(v -> {
            startActivity(new Intent(this, ListActivity.class));
        });
    }

}

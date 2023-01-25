package edu.itstep.fullstackclient;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {

    private ListView lvEmployees;
    private SimpleAdapter adapter;
    private List<Employee> employeeList = new ArrayList<>();
    private List<Map<String, String>> employeeInf = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lvEmployees = findViewById(R.id.lvEmployees);

        downloadData();
        createAndSetAdapter();
        setListeners();
    }

    private void downloadData() {
        NetworkService
                .getInstance()
                .getEmployeeApi()
                .getAllEmployees()
                .enqueue(new Callback<List<Employee>>() {
                    // Метод виконається в момент отримання результату запиту з сервера
                    @Override
                    public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                        employeeList = response.body(); // отримання колекції об'єктів Employee з об'єкта response

                        // Формування колекції Map для відображення у simple_list_item_2
                        employeeInf.clear();
                        Map<String, String> map;
                        for (Employee employee : employeeList) {
                            map = new HashMap<>();
                            map.put("inf_1", "" + employee.getId() + " " + employee.getFirstName() + " " + employee.getLastName());
                            map.put("inf_2", employee.getDepartment() + " " + employee.getSalary());
                            employeeInf.add(map);
                        }
                        createAndSetAdapter();
                    }

                    // Метод виконається при виникненні помилки
                    @Override
                    public void onFailure(Call<List<Employee>> call, Throwable t) {
                        Toast.makeText(ListActivity.this, "ERROR: " + t.getMessage(), Toast.LENGTH_SHORT).show(); // виведення тексту помилки у тостове повідомлення
                    }
                });
    }

    // Створення та підключення Адаптера
    private void createAndSetAdapter() {
        adapter = new SimpleAdapter(
                this,
                employeeInf,
                android.R.layout.simple_list_item_2,
                new String[]{"inf_1", "inf_2"},
                new int[]{android.R.id.text1, android.R.id.text2}
        );

        lvEmployees.setAdapter(adapter);
    }

    private void setListeners() {

        // Підключення слухача - видалення по кліку на елемент
        lvEmployees.setOnItemClickListener((parent, view, position, id) -> {
            //Toast.makeText(this, "" + employeeList.get((int) id).getId(), Toast.LENGTH_SHORT).show();
            int employeeId = employeeList.get(position).getId();

            // виклик діалогового вікна по натисканню кнопки видалення
                    // створення діалогового вікна з використанням паттерна Builder -
                    // дає змогу запускати методи ланцюжком
            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    // встановлення заголовка
                    .setTitle("Do you want to delete the selected item?")
                    // встановлення тексту-пояснення
                    .setMessage("The element will be removed without the possibility of recovery")
                    // налаштування кнопки прийняття дії
                    .setPositiveButton("YES", (dialog, which) -> {
                        deleteEmployeeById(employeeId); // виклик алгоритма видалення у разі натискання кнопки підтвердження
                    })
                    // налаштування кнопки відтермінування дії (інша дія) - використовується у якості кнопки відміни, оскільки відображається на протилежному боці вікна-повідомлення
                    .setNeutralButton("NO", (dialog, which) -> {
                        Toast.makeText(this, "The removal is canceled", Toast.LENGTH_SHORT).show();
                    });
            // виведення діалогового вікна на екран
            builder.show();
        });

        // Підключення слухача - редагування (спрощено - заміна полів на текстові константи) по ДОВГОМУ кліку на елемент
        lvEmployees.setOnItemLongClickListener((parent, view, position, id) -> {
            Employee employee = employeeList.get(position);
            employee.setFirstName("updateTest");
            employee.setLastName("updateTest");
            employee.setDepartment("updateTest");
            employee.setSalary(777);

            NetworkService
                    .getInstance()
                    .getEmployeeApi()
                    .updateEmployee(employee)
                    .enqueue(new Callback<Employee>() {
                        @Override
                        public void onResponse(Call<Employee> call, Response<Employee> response) {
                            downloadData();
                        }

                        @Override
                        public void onFailure(Call<Employee> call, Throwable t) {
                            Toast.makeText(ListActivity.this, "ERROR: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

            return false;
        });
    }

    // Алгоритм видалення елемента за id
    private void deleteEmployeeById(int id) {
        NetworkService
                .getInstance()
                .getEmployeeApi()
                .deleteEmployeeById(id)
                .enqueue(new Callback<Employee>() {
                    @Override
                    public void onResponse(Call<Employee> call, Response<Employee> response) {
                        Toast.makeText(ListActivity.this, "deleted: " + response.body().toString(), Toast.LENGTH_SHORT).show();
                        //lvEmployees.setAdapter(null);
                        downloadData();
                    }

                    @Override
                    public void onFailure(Call<Employee> call, Throwable t) {
                        Toast.makeText(ListActivity.this, "ERROR: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
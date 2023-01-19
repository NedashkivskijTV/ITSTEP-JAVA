package edu.itstep.cw20230118client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tvEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvEmployee = findViewById(R.id.tvEmployee);

//        EmployeeApi employeeApi = NetworkService.getInstance().getApi();
//        employeeApi.getAllEmployee();

//        NetworkService
//                .getInstance()
//                .getApi()
//                .getAllEmployee()
//                .enqueue(new Callback<List<Employee>>() {
//                    @Override
//                    public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
//                        List<Employee> employees = response.body();
//                        tvEmployee.setText(employees.get(0).getFirstName()); // name
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<Employee>> call, Throwable t) {
//                        tvEmployee.setText(t.getMessage());
//                    }
//                });

        NetworkService
                .getInstance()
                .getApi()
                .saveEmployee(new Employee("Dean", "Vinchester", "Hunter", 0))
                .enqueue(new Callback<Employee>() {
                    @Override
                    public void onResponse(Call<Employee> call, Response<Employee> response) {
                        Employee employee = response.body();
                        tvEmployee.setText(String.valueOf(employee.getId()));
                    }

                    @Override
                    public void onFailure(Call<Employee> call, Throwable t) {
                        tvEmployee.setText(t.getMessage());
                    }
                });
        

    }
}

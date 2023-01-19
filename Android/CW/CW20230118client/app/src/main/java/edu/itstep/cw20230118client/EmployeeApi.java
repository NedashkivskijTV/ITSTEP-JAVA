package edu.itstep.cw20230118client;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EmployeeApi {

    @GET("/employees")
    Call<List<Employee>> getAllEmployee();

    @POST("/employees")
    Call<Employee> saveEmployee(@Body Employee employee);
}

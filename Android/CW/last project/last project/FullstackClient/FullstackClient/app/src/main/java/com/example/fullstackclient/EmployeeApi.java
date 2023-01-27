package com.example.fullstackclient;

import java.util.Calendar;
import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface EmployeeApi {

    @GET("/employees")
    Call<List<Employee>> getAllEmployees();

    @POST("/employees")
    Call<Employee>saveEmployee(@Body Employee employee);

    @Multipart
    @POST("/upload-image")
    Call<String> uploadImage(@Part MultipartBody.Part body);
}

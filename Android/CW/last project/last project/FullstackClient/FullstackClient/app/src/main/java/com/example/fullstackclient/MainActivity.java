package com.example.fullstackclient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fullstackclient.databinding.ActivityMainBinding;

import java.io.File;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_GALLERY = 1;
    //private TextView tvEmployee;
    ActivityMainBinding binding;

    String filePath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // tvEmployee = findViewById(R.id.tvEmployee);

//        NetworkService
//                .getInstance()
//                .getEmployeeApi()
//                .getAllEmployees()
//                .enqueue(new Callback<List<Employee>>() {
//                    @Override
//                    public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
//                        List<Employee> employees = response.body();
//                        tvEmployee.setText(employees.get(0).getFirstName());//Ivan
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<Employee>> call, Throwable t) {
//                        tvEmployee.setText(t.getMessage());
//                    }
//                });

//        NetworkService
//                .getInstance()
//                .getEmployeeApi()
//                .saveEmployee(new Employee("Dean", "Vinchester", "Hunter", 0))
//                .enqueue(new Callback<Employee>() {
//                    @Override
//                    public void onResponse(Call<Employee> call, Response<Employee> response) {
//                        Employee employee = response.body();
//                        binding.tvEmployee.setText(String.valueOf(employee.getId()));
//                    }
//
//                    @Override
//                    public void onFailure(Call<Employee> call, Throwable t) {
//                        binding.tvEmployee.setText(t.getMessage());
//                    }
//                });

        binding.imageView.setOnClickListener(view -> {
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        });

        binding.btnSelect.setOnClickListener(view -> {
            int accessStorage = ContextCompat.checkSelfPermission(
                    getApplicationContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (accessStorage == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        });

        binding.btnSend.setOnClickListener(view -> {
            File file = new File(filePath);
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
            NetworkService.getInstance()
                    .getEmployeeApi()
                    .uploadImage(body)
                    .enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            Toast.makeText(MainActivity.this, response.body(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            filePath = RealPathUtil.getRealPath(this, uri);
            //Bitmap bitmap = BitmapFactory.decodeFile(filePath);
            //.imageView.setImageBitmap(bitmap);
            binding.imageView.setImageURI(uri);

        }
    }
}
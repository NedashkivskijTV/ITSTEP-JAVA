package edu.itstep.hw20230111a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // Змінні екземпляра класу, що відповідають активним елеменнтам Актівіті
    private TextView tvHelloMessage;
    private Button btnGetUsers;
    private ProgressBar pbGetUsers;

    private List<User> users = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ініціалізація (отримання за id) змінних екземпляра класу
        tvHelloMessage = findViewById(R.id.tvHelloMessage);
        btnGetUsers = findViewById(R.id.btnGetUsers);
        pbGetUsers = findViewById(R.id.pbGetUsers);


        // Підключення слухачів
        btnGetUsers.setOnClickListener(this::getUsersAndGoNextActivity);
    }

    private void getUsersAndGoNextActivity(View view) {
        pbGetUsers.setVisibility(View.VISIBLE);

        PlaceholderAPI placeholderAPI = NetworkService.getInstance().getApi();
        Call<List<User>> call = placeholderAPI.getAllUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                users = response.body();

                pbGetUsers.setVisibility(View.INVISIBLE);

                Intent intent = new Intent(MainActivity.this, UsersActivity.class);
                intent.putParcelableArrayListExtra("usersList", (ArrayList<? extends Parcelable>) users);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERROR: " + t, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
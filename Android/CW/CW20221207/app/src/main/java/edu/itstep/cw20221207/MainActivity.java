package edu.itstep.cw20221207;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private TextView tvPost;
    private Button btnGet;
    private Button btnNext;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPost = findViewById(R.id.tvPost);
        btnGet = findViewById(R.id.btnGet);
        btnNext = findViewById(R.id.btnNext);
        progressBar = findViewById(R.id.progressBar);

        btnGet.setOnClickListener(this::getPost);

        btnNext.setOnClickListener(view -> {
            startActivity(new Intent(this, PostsActivity.class));
        });
    }

    private void getPost(View view) {
        progressBar.setVisibility(View.VISIBLE);

        PlaceholderAPI placeholderAPI = NetworkService.getInstance().getApi();
        Call<Post> call = placeholderAPI.getPostById(7);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post post = response.body();
                tvPost.setText(post.getTitle());
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERROR: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
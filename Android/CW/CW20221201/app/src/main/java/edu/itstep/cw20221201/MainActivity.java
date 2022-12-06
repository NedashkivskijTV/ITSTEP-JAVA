package edu.itstep.cw20221201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvCount;//null
    private Button btnCount;//null
    private Button btnNext;

    private int count;//0
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount = findViewById(R.id.tvCount);
        btnCount = findViewById(R.id.btnCount);
        btnNext = findViewById(R.id.btnNext);

        sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        count = sharedPreferences.getInt("count", 0);
        tvCount.setText(String.valueOf(count));

        btnCount.setOnClickListener(view -> {
            tvCount.setText(String.valueOf(++count));
            editor.putInt("count", count);
            editor.apply();
        });

        btnNext.setOnClickListener(view -> {
            startActivity(new Intent(this, DynamicActivity.class));
        });

    }
}
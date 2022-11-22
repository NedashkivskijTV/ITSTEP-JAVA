package edu.itstep.cw20221117a2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // поля - змінні класу, що відповідають активним елементам Activity
    private TextView tvWelcome;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // отримання посилань на відповідні об'єкти
        tvWelcome = findViewById(R.id.tvWelcome);
        btnNext = findViewById(R.id.btnNext);

        // підключення подій - підготовка слухача
        btnNext.setOnClickListener(view -> {
            // алгоритм запуску нового Activity
            // TODO
        });

    }
}
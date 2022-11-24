package edu.itstep.cw20221117a2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_MESSAGE = "androidx.appcompat.app.AppCompatActivity.MainActivity.message";
    // поля - змінні класу, що відповідають активним елементам Activity
    private TextView tvWelcome;
    private Button btnNext;
    private EditText etMessage;
    private ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // отримання посилань на відповідні об'єкти
        tvWelcome = findViewById(R.id.tvWelcome);
        btnNext = findViewById(R.id.btnNext);
        etMessage = findViewById(R.id.etMessage);
        ivLogo = findViewById(R.id.ivLogo);

        // підключення подій - підготовка слухача
        btnNext.setOnClickListener(view -> {
            // отримання тексту повідомлення, введеного у поле EditText etMessage
            String message = etMessage.getText().toString();

            // алгоритм запуску нового Activity
            // створення об'єкта Intent (створення окремого об'єкта використовується
            // при необхідності передавання даних між актівіті)
            Intent intent = new Intent(this, SecondActivity.class);

            // передача даних до об'єкта Intent - використовується метод putExtra()
            // у параметри даний метод приймає аргумент, схожий на Map - КЛЮЧ (тільки String), ЗНАЧЕННЯ
            intent.putExtra(KEY_MESSAGE, message); // Ctrl+Alt+C - створення текстової константи

            // запуск нового актівіті
            startActivity(intent);
        });

        // підкоючення події - клік на картинці
        ivLogo.setOnClickListener(view1 -> {
            Toast.makeText(this, "LOGO", Toast.LENGTH_SHORT).show();
        });

    }
}
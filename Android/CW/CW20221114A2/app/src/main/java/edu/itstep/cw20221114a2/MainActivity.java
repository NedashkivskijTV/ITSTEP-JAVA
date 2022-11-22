package edu.itstep.cw20221114a2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSave;
    private Button btnSaveL;
    private Button btnMethodReference;
    private Button btnDownload;
    private Button btnSend;
    private EditText etMessage;
    private TextView tvMessage;
    private Button btnSendMessage;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // отримання посилань на об'єкти
        btnSave = findViewById(R.id.btnSave);
        btnSaveL = findViewById(R.id.btnSaveL);
        btnMethodReference = findViewById(R.id.btnMethodReference);
        btnDownload = findViewById(R.id.btnDownload);
        btnSend = findViewById(R.id.btnSend);
        etMessage = findViewById(R.id.etMessage);
        tvMessage = findViewById(R.id.tvMessage);
        btnSendMessage = findViewById(R.id.btnSendMessage);
        btnNext = findViewById(R.id.btnNext);

        // використання об'єкта анонімного класу
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Save-Anonymous", Toast.LENGTH_SHORT).show();
            }
        });

        // використання лямбда функції
        btnSaveL.setOnClickListener(view -> Toast.makeText(
                this,
                "Save-Lambda",
                Toast.LENGTH_SHORT).show());

        // використання посилання на метод
        btnMethodReference.setOnClickListener(this::save);

        // доєднання подій при імплементації методом MainActivity інтерфейсу View.OnClickListener
        btnDownload.setOnClickListener(this);
        btnSend.setOnClickListener(this);
        btnSendMessage.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    private void save(View view) {
        Toast.makeText(this, "Save-MethodReference", Toast.LENGTH_SHORT).show();
    }

    public void showHelloWorld(View view) {
        // у параметрі View приходить інформація про подію - обов'язково має вказуватись

        // відображення тексту
        Toast.makeText(this, "Hello World!", Toast.LENGTH_SHORT).show();

        // відображення тексту з файла string.xml за id
        Toast.makeText(this, R.string.say_hello, Toast.LENGTH_SHORT).show();

        // відображення вікна тривалий час - Toast.LENGTH_LONG
        Toast.makeText(this, "Hello World! - Long view", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        // застосування перемикача switch
//        switch (view.getId()) {
//            case R.id.btnDownload: {
//                Toast.makeText(this, "Downloaded", Toast.LENGTH_SHORT).show();
//                break;
//            }
//            case R.id.btnSend: {
//                Toast.makeText(this, "Sent", Toast.LENGTH_SHORT).show();
//                break;
//            }
//        }

        // застосування драбинки if/else
        int id = view.getId();
        if (id == R.id.btnDownload) {
            Toast.makeText(this, "Downloaded - if/else", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.btnSend) {
            Toast.makeText(this, "Sent - if/else", Toast.LENGTH_SHORT).show();
        } else if(id == R.id.btnSendMessage){
            String text = etMessage.getText().toString();
            tvMessage.setText(text);
            //tvMessage.setText(String.valueOf(7)); // при відображенні чисел
        } else if(id == R.id.btnNext){
            // перехід на нове Activity
            startActivity(new Intent(this, ResultActivity.class));
        }
    }
}
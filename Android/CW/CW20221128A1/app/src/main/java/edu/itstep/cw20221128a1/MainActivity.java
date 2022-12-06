package edu.itstep.cw20221128a1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvTest;
    private Button btnNext;
    private EditText etMessage;

    private Button btn4; // кнопка зміни лічильника

    private int count; // лічильник

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // створення логів з метою дебагінгу, фіксації помилки, додаткового інформування
        // приймає у параметри 1-тег (для фільтрації повідомлень серед багатьох інших),
        // 2-текстове повідомлення,
        Log.d("LifeCycle", "MainActivity onCreate");

        tvTest = findViewById(R.id.tvTest);
        btnNext = findViewById(R.id.btnNext);
        etMessage = findViewById(R.id.etMessage);

        btnNext.setOnClickListener(view -> {
            startActivity(new Intent(this, SecondActivity.class));
        });

        // реалізація роботи лічильника
        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(view -> {
            tvTest.setText(String.valueOf(++count));
        });

        // отримання даних з попереднього Актівіті (поворот екрану)
        // ВАЖЛИВО - при першому запуску Актівіті у параметрах приходить null
        if(savedInstanceState != null){
            // в параметрах вказується клуч, наданий при збереженні даних до об'єкта Bundle
            // у методі onSaveInstanceState()
            count = savedInstanceState.getInt("count");

            // збереження актуального значення (отриманого при повороті екрана) у відповідне поле
            tvTest.setText(String.valueOf(count));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // збереження значення лічильника при перевертанні вікна
        outState.putInt("count", count);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Отримання об'єкта MenuInflater - об'єкт для наповнення/надування меню
        MenuInflater inflater = getMenuInflater();

        // звернення до наповнювача меню через метод inflate() - наповни меню наступними об'єктами
        // приймає 2 параметри
        // 1 - макет меню - підготовлений заздалегідь файл (settings.xml)
        // 2 - об'єкт menu, що отримується в параметрах поточного методу
        inflater.inflate(R.menu.settings, menu);

        // при поверненні true - меню відображатиметься, згенерований код повертає false
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // отриманн id обраного елемента меню (приходить у параметрах)
        int id = item.getItemId();

        // реалізація алгоритмів відповідно до обраного пункту меню відбувається із застосуванням
        // перемикача switch або драбинки if/elseif
        // при застосуванні switch рекомендується документацією замість break використовувати return true
        // - актуально при перевикористанні даного меню та застосуванні фрагментів
        switch (id) {
            case R.id.item_light: {
                tvTest.setTextColor(Color.GRAY);
                tvTest.setBackgroundColor(Color.WHITE);

                // рекомендується документацією замість break використовувати return true
                return true;
            }
            case R.id.item_dark: {
                tvTest.setTextColor(Color.WHITE);
                tvTest.setBackgroundColor(Color.BLACK);
                return true;
            }
            case R.id.item_big: {
                tvTest.setTextSize(34);
                return true;
            }
            case R.id.item_middle: {
                tvTest.setTextSize(24);
                return true;
            }
            case R.id.item_small: {
                tvTest.setTextSize(14);
                return true;
            }
            default:
                // рядок return... може використовуватись після конструкції switch, але
                // документація рекомендує ставити повернення у елементі default перемикача
                return super.onOptionsItemSelected(item);
        }
        // рядок return... у документації рекомендується викликати з елемента default перемикача switch
        // return super.onOptionsItemSelected(item);
    }

    // Перевизначення методів життєвого циклу Актівіті для демонстрації роботи з дебагінгом та порядку
    // відпрацювання методів життєвого циклу
    // onCreate() - вже перевизначено у поточному класі


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "MainActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle", "MainActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle", "MainActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle", "MainActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "MainActivity onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle", "MainActivity onRestart");
    }
}
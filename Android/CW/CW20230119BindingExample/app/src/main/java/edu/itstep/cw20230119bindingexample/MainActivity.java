package edu.itstep.cw20230119bindingexample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;

import edu.itstep.cw20230119bindingexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding; // оголошення змінної класу для використання плагіна Binding (відміняє потребу звертатись до View-елементів через виклик findViewById)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater()); // ініціалізація змінної класу binding, а саме викликати статичний метод ActivityMainBinding.inflate та передати об’єкт getLayoutInflater() – усе згідно інструкції ініціалізації даного об’єкта

        //setContentView(R.layout.activity_main);
        setContentView(binding.getRoot()); // внесення змін з метою підключення плагіна Binding

        setDataToElement();
    }

    // Приклад отримання доступу до елементів Актівіті з використанням об'єкта binding
    private void setDataToElement() {
        binding.btnChangeText.setOnClickListener(v -> {
            binding.tvHello.setText("New TEXT");
            binding.tvHello.setBackgroundColor(Color.BLACK);
        });
    }
}
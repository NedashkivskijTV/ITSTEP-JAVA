package edu.itstep.cw20221201a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int count; // лічильник, збільшується при натисканні на кнопку

    // поля - змінні класу, що відповідають активним елементам Activity
    private TextView tvCount;
    private Button btnCount;
    private Button btnNext;

    // змінна для збереження даних у телефоні
    // SharedPreferences це інтерфейс - у змінну можна покласти об’єкт класу, що реалізує даний інтерфейс
    // sharedPreferences - об'єкт,  який даватиме доступ до файла
    private SharedPreferences sharedPreferences;

    // об'єкт для внесення змін у файл (запис даних)
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView(); // ініціалізація даних
        setListener(); // підключення слухачів
        initData(); // ініціалізація первинних даних
    }

    // ініціалізація даних
    private void initView() {
        tvCount = findViewById(R.id.tvCount);
        btnCount = findViewById(R.id.btnCount);
        btnNext = findViewById(R.id.btnNext);

        // отримання об'єкта класу, що імплементує інтерфейс SharedPreferences
        // sharedPreferences - об'єкт, який даватиме доступ до файла
        // в параметри приймає:
        // 1 - назву файла, що створюватиметься у пам'яті телефона
        // 2 - (числове значення) режим роботи з файлом
        // - найчастіше застосовується режим MODE_PRIVATE - доступ до файла матиме лише поточний застосунок
        sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE);

        // ініціалізація змінної, що використовуватиметься для внесення змін у вищевказаний файл
        editor = sharedPreferences.edit();

        // Отримання даних з файлу
        // ініціалізація змінної count значенням, що лежить у відповідному,
        // щойноствореному файлі
        // використовується об'єкт sharedPreferences в якому викликається метод getInt - залежить від типу збережених даних
        // приймає параметри
        // - ключ
        // - значення за замовчуванням - якщо у файлі значення не буде,
        // повернеться саме значення за замовчуванням
        count = sharedPreferences.getInt("count", 0);
        tvCount.setText(String.valueOf(count));
    }

    // підключення слухачів
    private void setListener() {

        // збільшення лічильника на 1 при натисканні на кнопку, та відображення значення змінної count
        // у відповідній TextView
        btnCount.setOnClickListener(view -> {
            tvCount.setText(String.valueOf(++count));

            // приклад запису інф до файлу
            // порядок запису інф подібний до запису до Map -
            // використовується метод putНазваТипуДаних (putInt, putBoolean, ),
            // також можна покласти Set з рядків (унікальна колекція рядків)
            // у параметри приймає - рядок-унікальний ключ та саме значення, що потрібно зберегти
            editor.putInt("count", count);
            // використовується алгоритм бферизації, який дозволяє підготувати
            // до запису значну кількість значень, а потім записати усе
            // викликавши один метод apply()
            editor.apply();
        });

        btnNext.setOnClickListener(view -> {
            startActivity(new Intent(this, DynamicActivity.class));
        });
    }

    // ініціалізація первинних даних
    private void initData() {
    }
}

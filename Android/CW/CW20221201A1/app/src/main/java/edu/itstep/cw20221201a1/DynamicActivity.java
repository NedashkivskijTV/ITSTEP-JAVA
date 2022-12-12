package edu.itstep.cw20221201a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_dynamic); // відключення стандартного елементу для створення Актівіті, який за допомогою id звертається до файлу-шаблона, з якого відмальовує Актівіті

        // Створення елементів Актівіті в коді

        // Основний елемент - LinearLayout, конструктор приймає у параметри, як мінімум Context
        LinearLayout layout = new LinearLayout(this);
        layout.setLayoutParams(new LinearLayout.LayoutParams(
                // 2 Основні константи, щодо значення розмірів
                // LinearLayout (match_parent, wrap_content) знаходяться у об'єкті LayoutParams
                LinearLayout.LayoutParams.MATCH_PARENT, // ширина
                LinearLayout.LayoutParams.MATCH_PARENT // висота
        ));

        // Орієнтація LinearLayout - горизонтальна/вертикальна
        // встановлюється через виклик методу setOrientation()
        // Самі константи знаходяться у об'єкті LinearLayout
        // (LinearLayout.HORIZONTAL, LinearLayout.VERTICAL)
        layout.setOrientation(LinearLayout.VERTICAL);

        // Атрибут Gravity - вказує де будуть знаходитись елементи
        // встановлюється через виклик методу setGravity()
        // константи знаходяться у класі Gravity
        layout.setGravity(Gravity.CENTER);

//        // Альтернативний спосіб форматування LinearLayout через створення окремого об'єкта з параметрами LinearLayout.LayoutParams
//        // Встановлення ширини та висоти лейаута
//        // За дані параметри відповідає окремий об'єкт LayoutParams,
//        // у останнього є конструктор, який приймає значення ширини та висоти
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
//                // 2 Основні константи, щодо значення розмірів
//                // LinearLayout (match_parent, wrap_content) знаходяться у об'єкті LayoutParams
//                LinearLayout.LayoutParams.MATCH_PARENT, // ширина
//                LinearLayout.LayoutParams.MATCH_PARENT // висота
//        );

        // Створення КНОПОК
        // Створення 1 кнопки
        Button button1 = new Button(this);

        // Встановлення тексту кнопки - метод setText()
        button1.setText("КНОПКА 1");

        // Розмір кнопки однієї кнопки - метод setLayoutParams()
        button1.setLayoutParams(new LinearLayout.LayoutParams(
                        // 2 Основні константи, щодо значення розмірів
                        // об'єкта View (match_parent, wrap_content) знаходяться у об'єкті LayoutParams
                        LinearLayout.LayoutParams.WRAP_CONTENT, // ширина
                        LinearLayout.LayoutParams.WRAP_CONTENT // висота
                )
        );

        // Додавання слухача - метод setOnClickListener()
        button1.setOnClickListener(view -> {
            // Тостове повідомлення - тест роботи коду
            Toast.makeText(this, "Натиснуто кнопку 1", Toast.LENGTH_SHORT).show();
        });



        // Створення декількох кнопок з однаковими параметрами
        // При необхідності створення декількох кнопок з однаковими параметрами створюєтся
        // окремий об’єкт LinearLayout.LayoutParams, в якому задаються параметри
        // і який підключається до кожної кнопки
        LinearLayout.LayoutParams layoutParamsButton = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, // ширина
                LinearLayout.LayoutParams.WRAP_CONTENT // висота
        );
        // Створення кнопки
        Button button2 = new Button(this);

        // Встановлення тексту кнопки - метод setText()
        button2.setText("КНОПКА 2");

        // Розмір кнопки однієї кнопки - метод setLayoutParams(),
        // приймає в параметри раніше створений об'єкт LinearLayout.LayoutParams
        button2.setLayoutParams(layoutParamsButton);

        // Додавання слухача - метод setOnClickListener()
        button2.setOnClickListener(view -> {
            // Тостове повідомлення - тест роботи коду
            Toast.makeText(this, "Натиснуто кнопку 2", Toast.LENGTH_SHORT).show();
        });

        // Створення кнопки
        Button button3 = new Button(this);
        button3.setText("NEXT");
        button3.setLayoutParams(layoutParamsButton);
        button3.setOnClickListener(view -> {
            startActivity(new Intent(this, ListContactActivity.class));
        });
        // Створення кнопки
        Button button4 = new Button(this);
        button4.setText("ListContactActivity 2 elem");
        button4.setLayoutParams(layoutParamsButton);
        button4.setOnClickListener(view -> {
            startActivity(new Intent(this, ListContactActivity2.class));
        });
        // Створення кнопки
        Button button5 = new Button(this);
        button5.setText("CustomListContactActivity");
        button5.setLayoutParams(layoutParamsButton);
        button5.setOnClickListener(view -> {
            startActivity(new Intent(this, CustomListContactActivity.class));
        });

        // Після створення усіх потрібних елементів їх потрібно додати до створеного на початку
        // контейнера LinearLayout layout - метод addView()
        // (на даний момент усі створені у методі onCreate об'єкти нічого не знають один про одного)
        layout.addView(button1);
        layout.addView(button2);
        layout.addView(button3);
        layout.addView(button4);
        layout.addView(button5);

        setContentView(layout); // команда на відображення вмісту об'єкта View - контейнера layout
    }
}

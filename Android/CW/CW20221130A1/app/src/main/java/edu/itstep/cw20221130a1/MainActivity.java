package edu.itstep.cw20221130a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // поля - змінні класу, що відповідають активним елементам Activity
    private Spinner spSpeciality;
    private Button btnSecondActivity;
    private Button btnDialogsActivity;
    private Button btnTimePickerDialog;

    // колекція елементів, що потрібно відобразити у Spinner (імітація звернення до БД)
    // Для прикладу використовується масив елементів типу String
    private String[] specialities = new String[]{"Developer", "Designer", "Tester", "Manager"};

    // Adapter - бувають різні
    // для даного прикладу, оскільки має місце використання масива, використовується ArrayAdapter<>
    // ArrayAdapter<> - типізовваний, вказується тип даних масиву
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ініціалізація даних - змінних класу
        spSpeciality = findViewById(R.id.spSpeciality);
        btnSecondActivity = findViewById(R.id.btnSecondActivity);
        btnDialogsActivity = findViewById(R.id.btnDialogsActivity);
        btnTimePickerDialog = findViewById(R.id.btnTimePickerDialog);

        // ініціалізація адаптера ArrayAdapter -
        // має декілька конструкторів, кожен приймає context
        // в параметри передаються
        // - context (поточне Актівіті)
        // - (для поточного завдання) наяваний в Android SDK підготовлений
        // файл-шаблон .xml - звернення до нього відбувається через простір імен android + клас R +
        // об'єкт layout (містить перелік підготовлених xml-файлів) + назва відповідного файлу simple_spinner_item
        // (підходить для реалізації поточного завдання)
        // - об'єкт, що містить дані для відображення - масив
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, specialities);

        // встановлення Adapter у Spinner, використовуючи метод setAdapter()
        spSpeciality.setAdapter(adapter);

        // встановлення до об’єкта Spinner слухача/події – обробника по натисканню на кнопку setOnItemSelectedListener
        // приймає реалізацію абстрактного класу OnItemSelectedListener - об'єкт анонімного класу AdapterView.OnItemSelectedListener
        // який реалізує 2 методи, при цьому використовується лише метод onItemSelected(), інший працює некоректно
        spSpeciality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // використовується даний метод (onItemSelected)
            // приймає в параметри -
            // - спіннер, елемент якого обрав користувач
            // - view - елемент на який було натиснуто
            // - position - позиція елемента в колекції, з якої відображаються елементи
            // - id елемента
            // при роботі з БД параметри position та id будуть різними (елементи видаляються...)
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                // отримання даних, що прийшли до методу після вибору одного з елементів, що  містить Spinner

                // простий варіант отримання даних про обраний елемент через позицію даного елемента у масиві
                // підхід не універсальний - при наявності декількох масивів потребує реалізації окремого коду для кожного Spinner
                //String selectedSpeciality = specialities[position];

                // Інший, УНІВЕРСАЛЬНИЙ, варіант отримання даних про обратий елемент у Spinner - через елемент adapterView
                // елемент витягується з самого Spinner по позиції (position) - повертає Object, який приводиться до рядка
                // при цьому даний обробник може перевикористовуватись
                String selectedSpeciality = adapterView.getItemAtPosition(position).toString();

                // виведення даних на екран
                Toast.makeText(MainActivity.this, "selectedSpeciality - " + selectedSpeciality, Toast.LENGTH_SHORT).show();
            }

            // метод не використовується, оскільки працює некоректно
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        btnSecondActivity.setOnClickListener(view -> {
            startActivity(new Intent(this, SecondActivity.class));
        });

        btnDialogsActivity.setOnClickListener(view -> {
            startActivity(new Intent(this, DialogsActivity.class));
        });

        btnTimePickerDialog.setOnClickListener(view -> {
            startActivity(new Intent(this, TimePickerActivity.class));
        });
    }
}

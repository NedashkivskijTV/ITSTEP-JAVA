package edu.itstep.cw20221117a2;

import static java.lang.String.join;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    // поля - змінні класу, що відповідають активним елементам Activity
    private TextView tvMessage;

    private CheckBox chbJava;
    private CheckBox chbKotlin;
    private CheckBox chbAndroid;

    private Button btnApply;

    private RadioGroup rGrpGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView(); // ініціалізація даних
        setListener(); // підключення слухачів
    }

    // метод ініціалізації даних
    private void initView() {
        // отримання посилань на відповідні об'єкти
        tvMessage = findViewById(R.id.tvMessage);

        chbJava = findViewById(R.id.chbJava);
        chbKotlin = findViewById(R.id.chbKotlin);
        chbAndroid = findViewById(R.id.chbAndroid);

        btnApply = findViewById(R.id.btnApply);

        rGrpGender = findViewById(R.id.rGrpGender);
    }

    // метод підключення слухачів
    private void setListener() {
        // отримання об'єкта Intent, відправленого з попереднього актівіті -
        // використовується метод одного з бітьківських класів getIntent()
        // при цьому отримується об'єкт Intent, створений у попередньому актівіті
        Intent intent = getIntent();

        // отримання даних з об'єкта Intent з використанням методу,
        // обраного відповідно до типу даних, що передаються - в даному разі передається String -
        // використовується метод getStringExtra("message"), в параметри якого передається ключ даних, вказаний
        // при їх занесенні до об'єкта Intent - для уникнення помилок при вказанні ключаварто використовувати
        // строкові константи
        //String message = intent.getStringExtra("message"); // використання ключа, введеного вручну
        String message = intent.getStringExtra(MainActivity.KEY_MESSAGE); // використання ключа-константи

        // передача тексту, отриманого через об'єкт Intent з попереднього актівіті
        // до атрибуту text поля TextView
        tvMessage.setText("Message: " + message);

        // встановлення слухача на кнопку
        btnApply.setOnClickListener(this::save); // використовується посилання на метод

        // встановлення слухача на групу радіобаттонів
        rGrpGender.setOnCheckedChangeListener(this::showGender); // використовується посилання на метод
    }

    // виведення даних відповідно до обраного радіобаттону
    private void showGender(RadioGroup radioGroup, int id) {
        String gender = null;
        if(id == R.id.rBtnMale){
            gender = "Male";
        } else if(id == R.id.rBtnFemale){
            gender = "Female";
        } else if(id == R.id.rBtnOther){
            gender = "Other";
        }
        Toast.makeText(this, gender, Toast.LENGTH_SHORT).show();
    }

    // виведення даних відповідно до натиснутих чекбоксів
    private void save(View view) {
        String result = "";
        if(chbJava.isChecked()){
            result += " Java";
        }
        if(chbKotlin.isChecked()){
            result += " Kotlin";
        }
        if(chbAndroid.isChecked()){
            result += " Android";
        }

        // код для форматування відображення обраних даних з розділенням через
        // деліметр " ,"
//        String[] resultMas = result.trim().split(" ");
//        String res = join(" ,", resultMas);

        // скорочений запис
        String res = join(" ,", result.trim().split(" "));

        tvMessage.setText(res);
    }
}

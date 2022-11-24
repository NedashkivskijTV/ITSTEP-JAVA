package edu.itstep.cw20221117a3;

import static java.lang.String.join;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import edu.itstep.cw20221117a3.models.Developer;

public class SecondActivity extends AppCompatActivity {

    // поля - змінні класу, що відповідають активним елементам Activity
    private TextView tvMessage;

    private CheckBox chbJava;
    private CheckBox chbKotlin;
    private CheckBox chbAndroid;

    private Button btnApply;

    private RadioGroup rGrpGender;
    
    private Button btnNext;

    private Developer developer;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView(); // ініціалізація даних
        setListener(); // підключення слухачів
        initData(); // ініціалізація перевинних даних
    }

    private void initData() {
        // отримання об'єкта Intent, відправленого з попереднього актівіті -
        Intent intent = getIntent();

        // отримання даних з об'єкта Intent з використанням методу, getSerializableExtra -
        // використовується у разі передачі даних через модель, що імплементує інтерфейс Serializable
        //Developer developer = (Developer) intent.getSerializableExtra(MainActivity.KEY_DEVELOPER); // використання ключа-константи
        developer = (Developer) intent.getSerializableExtra(MainActivity.KEY_DEVELOPER); // використання ключа-константи
        String message = developer.getTagLine(); // отримання текстового значення з моделі

        // передача тексту, отриманого через об'єкт Intent з попереднього актівіті
        // до атрибуту text поля TextView
        tvMessage.setText("Message: " + message);
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

        btnNext = findViewById(R.id.btnNext);
    }

    // метод підключення слухачів
    private void setListener() {
        btnApply.setOnClickListener(this::save);

        rGrpGender.setOnCheckedChangeListener(this::showGender);

        btnNext.setOnClickListener(this::showResultActivity);
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
        developer.setGender(gender); // передача даних до моделі
        Toast.makeText(this, gender, Toast.LENGTH_SHORT).show();
    }

    // виведення даних відповідно до натиснутих чекбоксів
    private void save(View view) {

        // очищення колекції перед зберіганням даних - захист від багаторазового
        // натискання на кнопку btnApply
        developer.getSoftSkills().clear();

        String result = "";
        if(chbJava.isChecked()){
            result += " Java";
            developer.addSkill("Java");
        }
        if(chbKotlin.isChecked()){
            result += " Kotlin";
            developer.addSkill("Kotlin");
        }
        if(chbAndroid.isChecked()){
            result += " Android";
            developer.addSkill("Android");
        }
        // код для форматування відображення обраних даних
        // з розділенням через деліметр " ,"
        String res = join(" ,", result.trim().split(" "));

        tvMessage.setText(res);
    }

    private void showResultActivity(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(MainActivity.KEY_DEVELOPER, developer);
        startActivity(intent);
    }

}

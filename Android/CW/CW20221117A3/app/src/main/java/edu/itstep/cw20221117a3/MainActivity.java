package edu.itstep.cw20221117a3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import edu.itstep.cw20221117a3.models.Developer;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_DEVELOPER = "edu.itstep.cw20221117a3.MainActivity.developer";

    // поля - змінні класу, що відповідають активним елементам Activity
    private Button btnNext;
    private EditText etMessage;
    private ImageView ivLogo;

    private Developer developer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView(); // ініціалізація даних
        setListener(); // підключення слухачів

        initData(); // ініціалізація початкових даних моделі Developer
        // рекомендується провидити ініціалізацію початкових даних моделі в окремих методах
        // у разі наявності значної кількості роботи – звернення до сервера, БД …)
    }

    // ініціалізація початкових даних моделі Developer
    private void initData() {
        developer = new Developer();
    }

    // метод ініціалізації даних
    private void initView() {
        btnNext = findViewById(R.id.btnNext);
        etMessage = findViewById(R.id.etMessage);
        ivLogo = findViewById(R.id.ivLogo);
    }

    // метод підключення слухачів
    private void setListener() {
        btnNext.setOnClickListener(this::nextActivity);
        ivLogo.setOnClickListener(this::showLogo);
        etMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().trim().length() != 0){
                    btnNext.setEnabled(true);
                } else {
                    btnNext.setEnabled(false);
                }
            }
        });
    }

    // функціонал при натисненні на кртинку
    private void showLogo(View view) {
        Toast.makeText(this, "LOGO", Toast.LENGTH_SHORT).show();
    }

    // функціонал при натисненні на кнопку Next
    private void nextActivity(View view) {
        // отримання тексту повідомлення, введеного у поле EditText etMessage
        String  message = etMessage.getText().toString();

        // додавання отриманого рядка до моделі
        developer.setTagLine(message);

        // створення об'єкта Intent (створення окремого об'єкта використовується
        // при необхідності передавання даних між актівіті)
        Intent intent = new Intent(this, SecondActivity.class);

        // передача даних до об'єкта Intent - використовується метод putExtra()
        // у параметри даний метод приймає аргумент, схожий на Map - КЛЮЧ (тільки String), ЗНАЧЕННЯ
        // УВАГА! - при доєднанні до intent об'єкта класу - моделі Цей клас має імплементувати
        // інтерфейс Parcelable або Serializable !!!
        intent.putExtra(KEY_DEVELOPER, developer); // Ctrl+Alt+C - створення текстової константи

        // запуск нового актівіті
        startActivity(intent);
    }

}

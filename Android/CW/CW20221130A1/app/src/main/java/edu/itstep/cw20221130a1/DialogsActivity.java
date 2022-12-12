package edu.itstep.cw20221130a1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DialogsActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    // поля - змінні класу, що відповідають активним елементам Activity
    private Button btnDelete;
    private TextView tvOutputMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);

        initView(); // ініціалізація даних
        setListener(); // підключення слухачів
        //initData(); // ініціалізація перевинних даних
    }

    private void initView() {
        btnDelete = findViewById(R.id.btnDelete);
        tvOutputMessage = findViewById(R.id.tvOutputMessage);
    }

    private void setListener() {
        // виклик діалогового вікна по натисканню кнопки із застосуванням анонімних класів
//        btnDelete.setOnClickListener(view -> {
//            // створення діалогового вікна з використанням паттерна Builder -
//            // дає змогу запускати методи ланцюжком
//            AlertDialog.Builder builder = new AlertDialog.Builder(this)
//                    .setTitle("Ви бажаєте видалити файл ?")
//                    .setMessage("Файл буде видалено без можливості повернення")
//                    .setPositiveButton("ВИДАЛИТИ", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int which) {
//                            tvOutputMessage.setText("РЕЗУЛЬТАТ ДІЇ - ВИДАЛЕНО !!!");
//                            Toast.makeText(DialogsActivity.this, "ВИДАЛЕНО !!!", Toast.LENGTH_SHORT).show();
//                        }
//                    })
//                    .setNegativeButton("ВІДМОВИТИСЬ", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            tvOutputMessage.setText("РЕЗУЛЬТАТ ДІЇ - ВИДАЛЕННЯ ВІДМІНЕНО");
//                            Toast.makeText(DialogsActivity.this, "ВИДАЛЕННЯ ВІДМІНЕНО", Toast.LENGTH_SHORT).show();
//                        }
//                    })
//                    .setNeutralButton("ВІДКЛАСТИ ДІЮ", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            tvOutputMessage.setText("РЕЗУЛЬТАТ ДІЇ - ПОДУМАТИ ...");
//                            Toast.makeText(DialogsActivity.this, "ПОДУМАТИ ...", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//            builder.show();
//        });


        // виклик діалогового вікна по натисканню кнопки із застосуванням лямбда-функцій
//        btnDelete.setOnClickListener(view -> {
//            // створення діалогового вікна з використанням паттерна Builder -
//            // дає змогу запускати методи ланцюжком
//            AlertDialog.Builder builder = new AlertDialog.Builder(this)
//                    // встановлення заголовка
//                    .setTitle("Ви бажаєте видалити файл ?")
//                    // встановлення тексту-пояснення
//                    .setMessage("Файл буде видалено без можливості повернення")
//                    // налаштування кнопки прийняття дії
//                    .setPositiveButton("YES", (dialogInterface, which) -> {
//                        tvOutputMessage.setText("РЕЗУЛЬТАТ ДІЇ - ВИДАЛЕНО !!!");
//                        Toast.makeText(DialogsActivity.this, "ВИДАЛЕНО !!!", Toast.LENGTH_SHORT).show();
//                    })
//                    // налаштування кнопки відміни дії
//                    .setNegativeButton("NO", (dialogInterface, which) -> {
//                        tvOutputMessage.setText("РЕЗУЛЬТАТ ДІЇ - ВИДАЛЕННЯ ВІДМІНЕНО");
//                        Toast.makeText(DialogsActivity.this, "ВИДАЛЕННЯ ВІДМІНЕНО", Toast.LENGTH_SHORT).show();
//                    })
//                    // налаштування кнопки відтермінування дії (інша дія)
//                    .setNeutralButton("ASK LATER", (dialogInterface, which) -> {
//                        tvOutputMessage.setText("РЕЗУЛЬТАТ ДІЇ - ПОДУМАТИ ...");
//                        Toast.makeText(DialogsActivity.this, "ПОДУМАТИ ...", Toast.LENGTH_SHORT).show();
//                    });
//            // виведення діалогового вікна на екран
//            builder.show();
//        });


        // виклик діалогового вікна по натисканню кнопки через посилання на клас Актівіті,
        // який реалізує інтерфейс DialogInterface.OnClickListener
        // використовується за умови реалізації класом Актівіті інтерфейсу DialogInterface.OnClickListener
        // даний підхід застосовується при невеликій кількості коду (проста логіка) при натисненні на кнопку
        // - у інших випадках рекомендується застосовувати посилання на методи
        btnDelete.setOnClickListener(view -> {
            // створення діалогового вікна з використанням паттерна Builder -
            // дає змогу запускати методи ланцюжком
            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle("Ви бажаєте видалити файл ?") // встановлення заголовка
                    .setMessage("Файл буде видалено без можливості повернення") // встановлення тексту-пояснення
                    .setPositiveButton("YES", this) // налаштування кнопки прийняття дії
                    .setNegativeButton("NO", this) // налаштування кнопки відміни дії
                    .setNeutralButton("ASK LATER", this); // налаштування кнопки відтермінування дії (інша дія)
            builder.show(); // виведення діалогового вікна на екран
        });
    }

    // виклик діалогового вікна по натисканню кнопки із застосуванням другого параметра - which
    // which використавується для випадків коли потрібно зрозуміти яка кнопка була натиснута
    @Override
    public void onClick(DialogInterface dialogInterface, int which) {
        switch (which) {
            case DialogInterface.BUTTON_POSITIVE: {
                // налаштування кнопки прийняття дії
                tvOutputMessage.setText("РЕЗУЛЬТАТ ДІЇ - ВИДАЛЕНО !!!");
                Toast.makeText(DialogsActivity.this, "ВИДАЛЕНО !!!", Toast.LENGTH_SHORT).show();
                break;
            }
            case DialogInterface.BUTTON_NEGATIVE: {
                // налаштування кнопки відміни дії
                tvOutputMessage.setText("РЕЗУЛЬТАТ ДІЇ - ВИДАЛЕННЯ ВІДМІНЕНО");
                Toast.makeText(DialogsActivity.this, "ВИДАЛЕННЯ ВІДМІНЕНО", Toast.LENGTH_SHORT).show();
                break;
            }
            case DialogInterface.BUTTON_NEUTRAL: {
                // налаштування кнопки відтермінування дії (інша дія)
                tvOutputMessage.setText("РЕЗУЛЬТАТ ДІЇ - ПОДУМАТИ ...");
                Toast.makeText(DialogsActivity.this, "ПОДУМАТИ ...", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }

}

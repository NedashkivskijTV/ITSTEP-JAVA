package edu.itstep.cw20221130a1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimePickerActivity extends AppCompatActivity {

    // поля - змінні класу, що відповідають активним елементам Activity
    private TextView tvShowTime;
    private Button btnShowTimePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

        initView(); // ініціалізація даних
        setListener(); // підключення слухачів
        //initData(); // ініціалізація перевинних даних
    }

    private void initView() {
        tvShowTime = findViewById(R.id.tvShowTime);
        btnShowTimePicker = findViewById(R.id.btnShowTimePicker);
    }

    private void setListener() {
        btnShowTimePicker.setOnClickListener(view -> {

            // отримання поточного часу з об'єкта Calendar для відображення при запуску TimePickerDialog
            Calendar calendar = Calendar.getInstance();
            int h = calendar.get(Calendar.HOUR);
            int m = calendar.get(Calendar.MINUTE);

            // відображення годинника при натисканні на кнопку
            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    this, // контекст
                    (TimePickerDialog.OnTimeSetListener) (timePicker, hour, min) -> { // встановлення слухача на подію-виюір дати
                        //tvShowTime.setText("" + hour + ":" + min); // виведення обраної дати без форматування
                        Date d = new GregorianCalendar(calendar.get(Calendar.YEAR), // формування дати/часу відповідно до обраного часу
                                calendar.get(Calendar.MONTH),
                                calendar.get(Calendar.DAY_OF_MONTH),
                                hour,
                                min,
                                0
                        ).getTime();
                        String time = new SimpleDateFormat("HH:mm").format(d); // створення фільтра та отримання обраної дати у форматованому вигляді у форматі рядка
                        tvShowTime.setText(time); // виведення обраної дати у форматованому вигляді
                    },
                    h, // поточний час - години
                    m, // поточний час - хвилини
                    true // формат виведення TimePickerDialog (true - 24 годинний)
            );
            timePickerDialog.show(); // запуск діалогового вікна timePickerDialog
        });
    }
}

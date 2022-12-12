package edu.itstep.cw20221130a1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SecondActivity extends AppCompatActivity {

    // поля - змінні класу, що відповідають активним елементам Activity
    private Button btnCalendar;
    private TextView tvDate; // відображення даних

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView(); // ініціалізація даних
        setListener(); // підключення слухачів
        //initData(); // ініціалізація перевинних даних
    }

    private void initView() {
        btnCalendar = findViewById(R.id.btnCalendar);
        tvDate = findViewById(R.id.tvDate); // відображення даних
    }

    private void setListener() {
        btnCalendar.setOnClickListener(view -> {
            // отрииання поточної дати з об'єкта Calendar для виділення поточної дати при відкриванні вікна DatePickerDialog
            Calendar calendar = Calendar.getInstance(); // отримання поточної дати
            int present_year = calendar.get(Calendar.YEAR); // поточний рік
            int present_month = calendar.get(Calendar.MONTH); // поточний місяць
            int present_day = calendar.get(Calendar.DAY_OF_MONTH);  // поточний день

            // відкривання календаря по натисканню на кнопку
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    this, // контекст
                    (DatePickerDialog.OnDateSetListener) (datePicker, year, month, dayOfMonth) -> { // підклюення слухача-на вибір дати, приймає в параметрах сам об'єкт datePicker та рік, місяць (починається з 0), день обраної дати
                        // функціонал, що спрацьовуватиме при виборі дати
                        // TODO
                        // використання дати без форматування
//                        tvDate.setText((month + 1) + "/" + dayOfMonth + "/" + year); // 12/6/2022

                        // використання дати з кастомним форматуванням
//                        String y = String.valueOf(year);
//                        ++month;
//                        String m = month < 10 ? "0" + month : String.valueOf(month);
//                        String d = dayOfMonth < 10 ? "0" + dayOfMonth : String.valueOf(dayOfMonth);
//                        String date = m + "/" + d + "/" + y;
//                        tvDate.setText(date); // 12/06/2022

                        // форматування дати з використанням наявних інстументів форматування
                        Date d = new GregorianCalendar(year, month, dayOfMonth).getTime();
                        String date = new SimpleDateFormat("dd:MM:yyyy").format(d);
                        tvDate.setText(date); // 05:12:2022
                    },
//                    2022, // рік дати, що відображається при запуску DatePickerDialog (хардкод)
//                    10, // місяць (починається з 0) дати, що відображається при запуску DatePickerDialog (хардкод)
//                    30 // день дати, що відображається при запуску DatePickerDialog (хардкод)
                    present_year, // поточний рік, отриманий з об'єкта Calendar - виділиться у відкритому вікні
                    present_month, // поточний місяць, отриманий з об'єкта Calendar - виділиться у відкритому вікні
                    present_day // поточний день, отриманий з об'єкта Calendar - виділиться у відкритому вікні
            );

            datePickerDialog.show(); // виклик метода show() для відображення діалогового вікна
        });
    }
}

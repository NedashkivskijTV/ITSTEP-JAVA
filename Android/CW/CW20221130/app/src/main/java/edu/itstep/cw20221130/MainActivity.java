package edu.itstep.cw20221130;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    private Spinner spSpeciality;
    private Button btnCalendar;
    private TextView tvDate;
    private Button btnDelete;
    private Button btnTime;

    private String[] specialities = new String[]{"Developer", "Designer", "Tester", "Manager"};
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spSpeciality = findViewById(R.id.spSpeciality);
        btnCalendar = findViewById(R.id.btnCalandar);
        tvDate = findViewById(R.id.tvDate);
        btnDelete = findViewById(R.id.btnDelete);
        btnTime = findViewById(R.id.btnTime);


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, specialities);
        spSpeciality.setAdapter(adapter);
        spSpeciality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
//                String selectedSpeciality = specialities[position];
                String selectedSpeciality = adapterView.getItemAtPosition(position).toString();

                Toast.makeText(MainActivity.this, selectedSpeciality, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        btnCalendar.setOnClickListener(view -> {

            Calendar calendar = Calendar.getInstance();

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    this,
                    (DatePickerDialog.OnDateSetListener) (datePicker, year, month, dayOfMonth) -> {
                        //tvDate.setText((month + 1) + " " + dayOfMonth + " " + year);

//                        month++;
//                        String y = String.valueOf(year);
//                        String m = month < 10 ? "0" + month : String.valueOf(month);
//                        String d = dayOfMonth < 10 ? "0" + dayOfMonth : String.valueOf(dayOfMonth);
//                        String date = m + "/" + d + "/" + y;
//                        tvDate.setText(date);

                        Date d = new GregorianCalendar(year, month, dayOfMonth).getTime();
                        String date = new SimpleDateFormat("dd:MM:yyyy").format(d);
                        tvDate.setText(date);
                    },
//                    2022,
//                    11,
//                    30
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            );

            datePickerDialog.show();
        });

        btnTime.setOnClickListener(view -> {
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    tvDate.setText(i + " | " + i1);
                }
            },
                    22,
                    15,
                    true
            );
            timePickerDialog.show();
        });

//        btnDelete.setOnClickListener(view -> {
//            AlertDialog.Builder builder = new AlertDialog.Builder(this)
//                    .setTitle("Ви бажаєте видалити файл ?")
//                    .setMessage("Файл буде видалено назавжди")
//                    .setPositiveButton("так", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int which) {
//                            Toast.makeText(MainActivity.this, "Видалено", Toast.LENGTH_SHORT).show();
//                        }
//                    })
//                    .setNegativeButton("ні", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            Toast.makeText(MainActivity.this, "Видалення відмінено", Toast.LENGTH_SHORT).show();
//                        }
//                    })
//                    .setNeutralButton("Пізніше", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            Toast.makeText(MainActivity.this, "Подумати ще", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//            builder.show();
//        });

//        btnDelete.setOnClickListener(view -> {
//            AlertDialog.Builder builder = new AlertDialog.Builder(this)
//                    .setTitle("Ви бажаєте видалити файл ?")
//                    .setMessage("Файл буде видалено назавжди")
//                    .setPositiveButton("так", (dialogInterface, which) ->
//                            Toast.makeText(MainActivity.this, "Видалено", Toast.LENGTH_SHORT).show())
//                    .setNegativeButton("ні", (dialogInterface, which) ->
//                            Toast.makeText(MainActivity.this, "Видалення відмінено", Toast.LENGTH_SHORT).show())
//                    .setNeutralButton("Пізніше", (dialogInterface, which) ->
//                            Toast.makeText(MainActivity.this, "Подумати ще", Toast.LENGTH_SHORT).show());
//            builder.show();
//        });

        btnDelete.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle("Ви бажаєте видалити файл ?")
                    .setMessage("Файл буде видалено назавжди")
                    .setPositiveButton("так", (dialogInterface, which) -> {
                        tvDate.setText("");
                        Toast.makeText(MainActivity.this, "Видалено", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("ні", (dialogInterface, which) ->
                            Toast.makeText(MainActivity.this, "Видалення відмінено", Toast.LENGTH_SHORT).show())
                    .setNeutralButton("Пізніше", (dialogInterface, which) ->
                            Toast.makeText(MainActivity.this, "Подумати ще", Toast.LENGTH_SHORT).show());
            builder.show();
        });


    }
}
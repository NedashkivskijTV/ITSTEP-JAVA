package edu.itstep.cw20221130a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    // поля - змінні класу, що відповідають активним елементам Activity
    private Spinner spSpeciality;

    // колекція елементів, що потрібно відобразити у Spinner (імітація звернення до БД)
    // Для прикладу використовується масив елементів типу String
    private String[] specialities = new String[]{"Developer", "Designer", "Tester", "Manager"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spSpeciality = findViewById(R.id.spSpeciality);

    }
}

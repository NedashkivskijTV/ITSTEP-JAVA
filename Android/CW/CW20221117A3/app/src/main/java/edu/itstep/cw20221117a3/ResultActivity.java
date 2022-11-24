package edu.itstep.cw20221117a3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import edu.itstep.cw20221117a3.models.Developer;

public class ResultActivity extends AppCompatActivity {

    // поля - змінні класу, що відповідають активним елементам Activity
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        initView(); // ініціалізація даних
        //setListener(); // підключення слухачів
        initData(); // ініціалізація перевинних даних
    }

    private void initView() {
        tvResult = findViewById(R.id.tvResult);
    }

    private void initData() {
        Developer developer = (Developer) getIntent().getSerializableExtra(MainActivity.KEY_DEVELOPER);
        String text = developer.getTagLine() + " " + developer.getGender() + " " + developer.getSoftSkills().toString();
        tvResult.setText(text);
    }
}
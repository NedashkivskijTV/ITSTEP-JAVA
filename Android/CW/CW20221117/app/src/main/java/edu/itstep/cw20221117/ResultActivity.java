package edu.itstep.cw20221117;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import edu.itstep.cw20221117.models.Developer;

public class ResultActivity extends AppCompatActivity {
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvResult = findViewById(R.id.tvResult);

        Developer developer = (Developer) getIntent().getSerializableExtra(MainActivity.KEY_DEVELOPER);

        tvResult.setText(developer.getTagline() + " " + developer.getGender() + "\n" + developer.getSoftSkills().toString());

    }
}
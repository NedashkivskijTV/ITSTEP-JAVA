package edu.itstep.cw20221117;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

import edu.itstep.cw20221117.models.Developer;


public class SecondActivity extends AppCompatActivity {

    private TextView tvMessage;
    private CheckBox chbJava;
    private CheckBox chbKotlin;
    private CheckBox chbAndroid;
    private Button btnApply;
    private RadioButton rbMale;
    private RadioButton rbFemale;
    private RadioButton rbOther;
    private RadioGroup rgGender;
    private Developer developer;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvMessage = findViewById(R.id.tvMessage);
        chbJava = findViewById(R.id.chbJava);
        chbKotlin = findViewById(R.id.chbKotlin);
        chbAndroid = findViewById(R.id.chbAndroid);
        btnApply = findViewById(R.id.btnApply);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        rbOther = findViewById(R.id.rbOther);
        rgGender = findViewById(R.id.rgGender);
        btnNext = findViewById(R.id.btnNext);


        Intent intent = getIntent();
        //String message = intent.getStringExtra("message");
        //String message = intent.getStringExtra(MainActivity.KEY_MESSAGE);
        developer = (Developer) intent.getSerializableExtra(MainActivity.KEY_DEVELOPER);
        //tvMessage.setText("Message: " + message);
        tvMessage.setText("Message: " + developer.getTagline());

        btnApply.setOnClickListener(this::save);

        rgGender.setOnCheckedChangeListener(this::showGender);

        btnNext.setOnClickListener(this::goResult);

    }

    private void goResult(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(MainActivity.KEY_DEVELOPER, developer);
        startActivity(intent);
    }

    private void showGender(RadioGroup radioGroup, int id) {
        String gender = null;
        if(id == R.id.rbMale){
            gender = "male";
        }
        if(id == R.id.rbFemale){
            gender = "female";
        }
        if(id == R.id.rbOther){
            gender = "other";
        }
        developer.setGender(gender);
        Toast.makeText(this, gender, Toast.LENGTH_SHORT).show();
    }
    private void save(View view) {
        String result = "";
        //developer.getSoftSkills().clear();
        if(chbJava.isChecked()){
            result += " Java";
            developer.addSkills("Java");
        }
        if(chbKotlin.isChecked()){
            result += " Kotlin";
            developer.addSkills("Kotlin");
        }
        if(chbAndroid.isChecked()){
            result += " Android";
            developer.addSkills("Android");
        }
        tvMessage.setText(result);
    }
}

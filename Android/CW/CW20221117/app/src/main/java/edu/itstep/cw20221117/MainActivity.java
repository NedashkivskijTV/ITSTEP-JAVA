package edu.itstep.cw20221117;

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

import edu.itstep.cw20221117.models.Developer;

public class MainActivity extends AppCompatActivity {

    //public static final String KEY_MESSAGE = "edu.itstep.cw20221117.MainActivity.message";
    public static final String KEY_DEVELOPER = "edu.itstep.cw20221117.MainActivity.message";
    // поля - змінні класу, що відповідають активним елементам Activity
    private Button btnNext;
    private EditText etMessage;
    private ImageView ivLogo;
    private Developer developer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // отримання посилань на відповідні об'єкти
        btnNext = findViewById(R.id.btnNext);
        etMessage = findViewById(R.id.etMessage);
        ivLogo = findViewById(R.id.ivLogo);

        initDate();

        // підключення подій
        btnNext.setOnClickListener(view -> {

            String message = etMessage.getText().toString();

            Intent intent = new Intent(this, SecondActivity.class);
            //intent.putExtra(KEY_MESSAGE, message);
            developer.setTagline(message);
            intent.putExtra(KEY_DEVELOPER, developer);

            startActivity(intent);
        });

        ivLogo.setOnClickListener(view ->
                Toast.makeText(MainActivity.this, "LOGO", Toast.LENGTH_SHORT).show());

        etMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().trim().length() > 0) {
                    btnNext.setEnabled(true);
                } else {
                    btnNext.setEnabled(false);
                }
            }
        });
    }

    private void initDate() {
        developer = new Developer();
    }
}
package edu.itstep.cw20221114a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSave;
    private Button btnDownload;
    private Button btnSend;
    private EditText etMessage;
    private TextView tvMessage;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btnSave);
        btnDownload = findViewById(R.id.btnDownload);
        btnSend = findViewById(R.id.btnSend);
        etMessage = findViewById(R.id.etMessage);
        tvMessage = findViewById(R.id.tvMessage);
        btnNext = findViewById(R.id.btnNext);


//        btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "saved", Toast.LENGTH_LONG).show();
//            }
//        });
//        btnSave.setOnClickListener(view -> Toast.makeText(
//                this,
//                "saved",
//                Toast.LENGTH_LONG).show());
        btnSave.setOnClickListener(this::save);
        btnDownload.setOnClickListener(this);
        btnSend.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    private void save(View view) {
        Toast.makeText(
                this,
                "saved",
                Toast.LENGTH_LONG).show();
    }

    public void showHelloWorld(View view) {
        Toast.makeText(this, R.string.say_hello, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnDownload) {
            Toast.makeText(
                    this,
                    "downloaded",
                    Toast.LENGTH_LONG).show();
        } else if (id == R.id.btnSend) {
//            Toast.makeText(
//                    this,
//                    "sent",
//                    Toast.LENGTH_LONG).show();

            String message = etMessage.getText().toString();
            tvMessage.setText(message);
        } else if (id == R.id.btnNext) {
            // TODO
            startActivity(new Intent(this, ResultActivity.class));
        }
//        switch (view.getId()) {
//            case R.id.btnDownload:
//                Toast.makeText(
//                        this,
//                        "downloaded",
//                        Toast.LENGTH_LONG).show();
//            break;
//
//            case R.id.btnSend:
//                Toast.makeText(
//                        this,
//                        "sent",
//                        Toast.LENGTH_LONG).show();
//                break;
//        }
    }
}
package edu.itstep.hw20230111a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PhoneActivity extends AppCompatActivity {

    private TextView tvUserName;
    private TextView tvUserPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        tvUserName = findViewById(R.id.tvUserName);
        tvUserPhone = findViewById(R.id.tvUserPhone);

        Intent intent = getIntent();
        ArrayList<String> userInfo = intent.getStringArrayListExtra("userPhone");

        tvUserName.setText(userInfo.get(0));
        tvUserPhone.setText(userInfo.get(1));
    }
}
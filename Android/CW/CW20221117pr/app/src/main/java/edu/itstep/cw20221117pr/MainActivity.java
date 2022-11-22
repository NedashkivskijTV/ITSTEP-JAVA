package edu.itstep.cw20221117pr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvWish;
    private Button btnGetWish;

    private String[] wishes = {
            "wish #01",
            "wish #02",
            "wish #03",
            "wish #04",
            "wish #05",
            "wish #06",
            "wish #07",
            "wish #08",
            "wish #09",
            "wish #10",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWish = findViewById(R.id.tvWish);
        btnGetWish = findViewById(R.id.btnGetWish);

        btnGetWish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = (int) (Math.random() * 10);
                tvWish.setText(wishes[n]);
            }
        });
    }
}
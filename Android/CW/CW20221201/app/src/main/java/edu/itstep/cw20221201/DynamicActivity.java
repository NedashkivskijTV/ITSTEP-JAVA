package edu.itstep.cw20221201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));

        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        Button button1 = new Button(this);
        //button1.setText("кнопка 1");
        button1.setText("CustomListContactActivity");
        button1.setLayoutParams(layoutParams);
        button1.setOnClickListener(view -> {
            //Toast.makeText(this, "натиснута кнопка 1", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, CustomListContactActivity.class));
        });

        Button button2 = new Button(this);
        //button2.setText("кнопка 2");
        button2.setText("ListContactActivity");
        button2.setLayoutParams(layoutParams);
        //button1.setLayoutParams();
        button2.setOnClickListener(view -> {
            //Toast.makeText(this, "натиснута кнопка 2", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, ListContactActivity.class));
        });

        layout.addView(button1);
        layout.addView(button2);

        setContentView(layout);
    }
}

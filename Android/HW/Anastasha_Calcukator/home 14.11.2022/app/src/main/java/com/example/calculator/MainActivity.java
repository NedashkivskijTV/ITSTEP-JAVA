package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculator.models.Calculate;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1x;
    private Button btnxy;
    private Button btnd;
    private Button btndeletelast;
    private Button btndeleteAll;
    private Button btnProc;
    private Button btnCor;
    private Button btnDil;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnmultiply;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btnmin;
    private Button btn3;
    private Button btn2;
    private Button btn1;
    private Button btnpl;
    private Button btn0;
    private Button btndrob;
    private Button btnres;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        btn1x = findViewById(R.id.btn1x);
        btnxy = findViewById(R.id.btnxy);
        btnd = findViewById(R.id.btnd);
        btndeletelast = findViewById(R.id.btndeletelast);
        btndeleteAll = findViewById(R.id.btndeleteAll);
        btnProc = findViewById(R.id.btnProc);
        btnCor = findViewById(R.id.btnCor);
        btnDil = findViewById(R.id.btnDil);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnmultiply = findViewById(R.id.btnmultiply);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btnmin = findViewById(R.id.btnmin);
        btn3 = findViewById(R.id.btn3);
        btn2 = findViewById(R.id.btn2);
        btn1 = findViewById(R.id.btn1);
        btnpl = findViewById(R.id.btnpl);
        btn0 = findViewById(R.id.btn0);
        btndrob = findViewById(R.id.btndrob);
        btnres = findViewById(R.id.btnres);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnmin.setOnClickListener(this);
        btnmultiply.setOnClickListener(this);
        btnpl.setOnClickListener(this);
        btnDil.setOnClickListener(this);
        btnres.setOnClickListener(this);
        btndeleteAll.setOnClickListener(this);
        btnd.setOnClickListener(this);
        btndeletelast.setOnClickListener(this);
        btndrob.setOnClickListener(this);
        btn1x.setOnClickListener(this);
        btnxy.setOnClickListener(this);
        btnCor.setOnClickListener(this);
        textView.setText("");
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn0) {
            textView.setText(textView.getText().toString() + "0");
        } else if (id == R.id.btn1) {
            textView.setText(textView.getText().toString() + "1");
        } else if (id == R.id.btn2) {
            textView.setText(textView.getText().toString() + "2");
        } else if (id == R.id.btn3) {
            textView.setText(textView.getText().toString() + "3");
        } else if (id == R.id.btn4) {
            textView.setText(textView.getText().toString() + "4");
        } else if (id == R.id.btn5) {
            textView.setText(textView.getText().toString() + "5");
        } else if (id == R.id.btn6) {
            textView.setText(textView.getText().toString() + "6");
        } else if (id == R.id.btn7) {
            textView.setText(textView.getText().toString() + "7");
        } else if (id == R.id.btn8) {
            textView.setText(textView.getText().toString() + "8");
        } else if (id == R.id.btn9) {
            textView.setText(textView.getText().toString() + "9");
        } else if (id == R.id.btnpl) {
            textView.setText(textView.getText().toString() + "+");
        } else if (id == R.id.btnmin) {
            textView.setText(textView.getText().toString() + "-");
        } else if (id == R.id.btnDil) {
            textView.setText(textView.getText().toString() + "/");
        } else if (id == R.id.btnmultiply) {
            textView.setText(textView.getText().toString() + "*");
        } else if (id == R.id.btnd) {
            String text = textView.getText().toString();
            if (text.length() > 0) {
                char lSymbol = text.charAt(text.length() - 1);
                String lastSymbol = Character.toString(lSymbol);
                Pattern p = Pattern.compile("\\d");
                Matcher m = p.matcher(lastSymbol);
                if (m.find()) {
                    textView.setText(textView.getText().toString() + ")");
                } else {
                    textView.setText(textView.getText().toString() + "(");
                }
            } else {
                textView.setText(textView.getText().toString() + "(");
            }
        } else if (id == R.id.btnres) {
            Calculate calculate = new Calculate();
            calculate.setTextView(textView.getText().toString());
            textView.setText(calculate.start());
        } else if (id == R.id.btndeleteAll) {
            textView.setText("");
        }
        else if(id == R.id.btndeletelast){
            String calc = textView.getText().toString();
            textView.setText(calc.substring(0, calc.length() - 1));
        }
        else if(id == R.id.btndrob){
            textView.setText(textView.getText().toString() + ".");
        }
        else if(id == R.id.btn1x){
            textView.setText(textView.getText().toString() + "1/" );
        }
        else if(id == R.id.btnxy){
            String text = textView.getText().toString();
            if (text.length() > 0) {
                char lSymbol = text.charAt(text.length() - 1);
                String lastSymbol = Character.toString(lSymbol);
                Pattern p = Pattern.compile("\\d");
                Matcher m = p.matcher(lastSymbol);
                if (m.find()) {
                    textView.setText(textView.getText().toString() + "^");
                }
            } else {
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
            }
        }
        else if(id == R.id.btnCor){
            String text = textView.getText().toString();
            if (text.length() > 0) {
                Double result = Double.parseDouble(text);
                result = Math.sqrt(result);
                textView.setText("√" + text + "=" + String.valueOf(result));
            } else {
                Toast.makeText(this, "Please, enter the number at first", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
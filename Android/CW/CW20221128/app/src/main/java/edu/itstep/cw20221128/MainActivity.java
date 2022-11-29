package edu.itstep.cw20221128;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView tvTest;
    private Button btnNext;
    private Button btnCount;

    private int count;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LifeCycle", "MainActivity onCreate");

        tvTest = findViewById(R.id.tvTest);
        btnNext = findViewById(R.id.btnNext);
        btnCount = findViewById(R.id.btnCount);
        btnNext.setOnClickListener(view -> {
            startActivity(new Intent(this, SecondActivity.class));
        });

        btnCount.setOnClickListener(view -> {
            tvTest.setText(String.valueOf(++count));
        });

        if(savedInstanceState != null){
            count = savedInstanceState.getInt("count");
            tvTest.setText(String.valueOf(count));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_light:{
                tvTest.setTextColor(Color.GRAY);
                tvTest.setBackgroundColor(Color.WHITE);
                //break;
                return true;
            }
            case R.id.item_dark:{
                tvTest.setTextColor(Color.WHITE);
                tvTest.setBackgroundColor(Color.BLACK);
                //break;
                return true;
            }
            case R.id.item_small:{
                tvTest.setTextSize(14);
                return true;
                //break;
            }
            case R.id.item_middle:{
                tvTest.setTextSize(24);
                return true;
                //break;
            }
            case R.id.item_big:{
                tvTest.setTextSize(34);
                return true;
                //break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "MainActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle", "MainActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle", "MainActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle", "MainActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "MainActivity onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle", "MainActivity onRestart");
    }
}

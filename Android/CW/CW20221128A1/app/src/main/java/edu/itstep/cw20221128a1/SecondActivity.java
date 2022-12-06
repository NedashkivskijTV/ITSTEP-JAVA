package edu.itstep.cw20221128a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d("LifeCycle", "SecondActivity onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "SecondActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle", "SecondActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle", "SecondActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle", "SecondActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "SecondActivity onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle", "SecondActivity onRestart");
    }

}
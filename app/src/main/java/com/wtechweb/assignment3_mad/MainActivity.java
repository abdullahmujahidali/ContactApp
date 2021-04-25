package com.wtechweb.assignment3_mad;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import 	android.os.Handler;

public class MainActivity extends AppCompatActivity {
    final static int SPLASH_TIME=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, com.wtechweb.assignment3_mad.MainScreen.class);
                startActivity(intent);
            }

        }, SPLASH_TIME);
    }
}
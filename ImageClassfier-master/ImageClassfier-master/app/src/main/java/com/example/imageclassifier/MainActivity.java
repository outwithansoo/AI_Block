package com.example.imageclassifier;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private long backBtnTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cameraBtn = findViewById(R.id.cameraBtn);
        cameraBtn.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, CameraActivity.class);
            startActivity(i);
        });

        Button btnCodeResult = findViewById(R.id.btnCodeResult);
        btnCodeResult.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, Code_resultActivity.class);
            startActivity(i);
        });

        Button introduce = findViewById(R.id.introduce);
        introduce.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this,ManualActivity.class);
            startActivity(i);
        });

    }

    @Override
    public void onBackPressed() {
        long curTime = System.currentTimeMillis();
        long gapTime = curTime - backBtnTime;

        if(0<=gapTime && 2000 >= gapTime){
            super.onBackPressed();
        }
        else{
            backBtnTime = curTime;
            Toast.makeText(this, "한번 더 누르면 종료 됩니다.", Toast.LENGTH_SHORT).show();
        }


    }
}


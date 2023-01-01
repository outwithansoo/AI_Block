package com.example.imageclassifier;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Code_resultActivity extends AppCompatActivity {

    int i = 1;
    ConstraintLayout nsc_view;
    ImageButton code_result_btn_hide;
    Toolbar toolbar;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_result);

        toolbar = findViewById(R.id.activity_result_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("결과");

        nsc_view = findViewById(R.id.Code_result_ctr_layout);
        code_result_btn_hide = findViewById(R.id.code_result_btn_hide);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getRealSize(size); // or getSize(size)
        int width = size.x;
        int height = size.y;
        nsc_view.setMaxHeight((int)(height * 0.7));

        Button btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(view -> {
            Intent i = new Intent(Code_resultActivity.this, MainActivity.class);
            finishAffinity();
            startActivity(i);
        });

        nsc_view.setVisibility(View.VISIBLE);

        code_result_btn_hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 1 - i;
                if(i == 0){
                    nsc_view.setVisibility(View.GONE);
                    code_result_btn_hide.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                }
                else{
                    nsc_view.setVisibility(View.VISIBLE);
                    code_result_btn_hide.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                }
            }
        });
    }

}
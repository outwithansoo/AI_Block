package com.example.imageclassifier;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.imageclassifier.Data.VariableData;


public class CodeGenerator extends AppCompatActivity {
    TextView intentValue;
    Button btnVariable1, btnVariable2, btnReCapture;
    Toolbar toolbar;
    VariableData var1, var2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_generator);

        toolbar = findViewById(R.id.code_generator_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnVariable1 = findViewById(R.id.btnVariable1);
        btnVariable2 = findViewById(R.id.btnVariable2);
        btnReCapture = findViewById(R.id.btnReCapture);
        Button btnToResult = findViewById(R.id.btnToResult);

        ActivityResultLauncher<Intent> startActivityResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            if (result.getData().getSerializableExtra("var1") != null) {
                                var1 = (VariableData) result.getData().getSerializableExtra("var1");
                                btnVariable1.setText(var1.getVariableName());
                            }
                            else{
                                var2 = (VariableData) result.getData().getSerializableExtra("var2");
                                btnVariable2.setText(var2.getVariableName());
                            }
                        }
                    }
                });

        btnVariable1.setOnClickListener(view -> {
            Intent i = new Intent(this, SaveVariableActivity.class);
            i.putExtra("var", "var1");
            startActivityResult.launch(i);
        });

        btnVariable2.setOnClickListener(view -> {
            Intent i = new Intent(this, SaveVariableActivity.class);
            i.putExtra("var", "var2");
            startActivityResult.launch(i);
        });

        btnReCapture.setOnClickListener(view -> {
            Intent i = new Intent(this, CameraActivity.class);
            startActivity(i);
        });

        btnToResult.setOnClickListener(view -> {
            Intent i = new Intent(this, Code_resultActivity.class);
            startActivity(i);
        });


        Intent intent = getIntent();
        String text = getIntent().getStringExtra("text");
            intentValue = (TextView) findViewById(R.id.operator1);
            intentValue.setText(text);

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
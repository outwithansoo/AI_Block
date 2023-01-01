package com.example.imageclassifier;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomDialog extends Dialog {
    private EditText etVariableName, etVariableData;
    private Button okBtn, cancelBtn;
    private Context context;
    private CustomDialogListener customDialogListener;

    public CustomDialog(Context context) {
        super(context);
        this.context = context;
    }

    //인터페이스 설정
    interface CustomDialogListener{
        void onPositiveClicked(String name, Integer data);
        void onNegativeClicked();
    }

    //호출할 리스너 초기화
    public void setDialogListener(CustomDialogListener customDialogListener){
        this.customDialogListener = customDialogListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_variable_dialog);

        etVariableName = findViewById(R.id.variable_name_edit);
        etVariableData = findViewById(R.id.variable_data_edit);
        okBtn = findViewById(R.id.add_variable_ok_btn);
        cancelBtn = findViewById(R.id.add_variable_cancel_btn);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name;
                Integer data;
                if(!etVariableName.getText().toString().trim().equals("") && !etVariableData.getText().toString().trim().equals("")){
                    Log.d("text", etVariableName.getText().toString() + etVariableData.getText().toString());
                    try{
                        name = etVariableName.getText().toString().trim();
                        data = Integer.valueOf(etVariableData.getText().toString().trim());
                        customDialogListener.onPositiveClicked(name, data);
                        dismiss();
                    }catch (Exception e){
                        Toast.makeText(context, "데이터 값에 실수를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(context, "빈 칸을 채워주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                customDialogListener.onNegativeClicked();
                cancel();
            }
        });
    }
}

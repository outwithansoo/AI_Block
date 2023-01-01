package com.example.imageclassifier;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.imageclassifier.Adapters.VariableListAdapter;
import com.example.imageclassifier.Data.VariableData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class SaveVariableActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private RecyclerView variableRecyclerView;
    private Button addButton, modifyButton, removeButton;
    private ArrayList<VariableData> recyclerData;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private VariableListAdapter adapter;
    private Intent varIntent;
    private ArrayList<VariableData> modifyArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_variable);

        toolbar = findViewById(R.id.save_variable_toolbar);
        variableRecyclerView = findViewById(R.id.variable_recycler);
        addButton = findViewById(R.id.add_variable_btn);
        modifyButton = findViewById(R.id.modify_variable_btn);
        removeButton = findViewById(R.id.remove_variable_btn);
        varIntent = getIntent();

        recyclerData = new ArrayList<>();
        modifyArrayList = new ArrayList<>();

        pref = getSharedPreferences("variableData", Activity.MODE_PRIVATE);
        editor = pref.edit();

        addButton.setOnClickListener(this);
        modifyButton.setOnClickListener(this);
        removeButton.setOnClickListener(this);
        recyclerData = getVariablePref("variable");
        adapter = new VariableListAdapter(recyclerData);
        variableRecyclerView.setAdapter(adapter);
        variableRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setOnItemClickListener(new VariableListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position, VariableData item) {
                Intent intent = new Intent();
                if(varIntent.getStringExtra("var").equals("var1")){
                    intent.putExtra("var1", item);
                }
                else{
                    intent.putExtra("var2", item);
                }

                setResult(Activity.RESULT_OK, intent);
                finish();
            }

            @Override
            public void onItemLongClick(View v, int position, VariableData item) {
                Context context = v.getContext();
                if(modifyArrayList.contains(item)){
                    modifyArrayList.remove(item);
                    v.setBackgroundColor(0x00000000);
                }else {
                    modifyArrayList.add(item);
                    v.setBackgroundColor(ContextCompat.getColor(context, R.color.light_gray));
                }
            }
        });
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_variable_btn: {
                CustomDialog dialog = new CustomDialog(this);
                dialog.setDialogListener(new CustomDialog.CustomDialogListener() {
                    @Override
                    public void onPositiveClicked(String name, Integer data) {
                        VariableData item = new VariableData();
                        item.setVariableName(name);
                        item.setVariableData(data);
                        recyclerData.add(item);
                        variableRecyclerView.getAdapter().notifyDataSetChanged();

                        setVariablePref("variable", recyclerData);
                    }

                    @Override
                    public void onNegativeClicked() {
                    }
                });


                dialog.show();

                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                break;
            }
            case R.id.modify_variable_btn: {
                break;
            }
            case R.id.remove_variable_btn: {
                if (modifyArrayList.size() != 0){
                    for(VariableData items:modifyArrayList){
                        recyclerData.remove(items);
                    }
/*                    for(VariableData items:recyclerData){
                        Log.d("variable", items.getVariableName()+items.getVariableData().toString());
                    }*/
                    setVariablePref("variable",recyclerData);
                    adapter.notifyDataSetChanged();
                }
                break;
            }
        }
    }

    private void setVariablePref(String key, ArrayList<VariableData> values) {
        Gson gson = new Gson();
        String json = gson.toJson(values);

        editor.putString(key, json);
        editor.apply();
    }


    private ArrayList<VariableData> getVariablePref(String key){
        ArrayList<VariableData> variableData = new ArrayList<>();
        String json = pref.getString(key, null);
        Gson gson = new Gson();

        if(json != null)
            variableData = gson.fromJson(json, new TypeToken<ArrayList<VariableData>>(){}.getType());

        return variableData;
    }
}


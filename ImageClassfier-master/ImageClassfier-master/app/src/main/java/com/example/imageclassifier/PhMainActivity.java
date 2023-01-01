package com.example.imageclassifier;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PhMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // List 설정
        bindList();
    }

    /**
     * List 설정
     */
    private void bindList() {
        // List item 생성
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("emoji_u1f600");
        nameList.add("emoji_u1f601");
        nameList.add("emoji_u1f602");
        nameList.add("emoji_u1f603");
        nameList.add("emoji_u1f604");
        nameList.add("emoji_u1f605");
        nameList.add("emoji_u1f606");
        nameList.add("emoji_u1f607");
        nameList.add("emoji_u1f608");
        nameList.add("emoji_u1f609");
        nameList.add("emoji_u1f610");
        nameList.add("emoji_u1f611");
        nameList.add("emoji_u1f612");
        nameList.add("emoji_u1f613");
        nameList.add("emoji_u1f614");
        nameList.add("emoji_u1f615");
        nameList.add("emoji_u1f616");
        nameList.add("emoji_u1f617");
        nameList.add("emoji_u1f618");
        nameList.add("emoji_u1f619");
        nameList.add("emoji_u1f620");
        nameList.add("emoji_u1f621");
        nameList.add("emoji_u1f622");
        nameList.add("emoji_u1f623");
/*
        // Recycler view
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // Adapter 추가
        PhRecyclerViewAdapter adapter = new PhRecyclerViewAdapter(nameList);
        recyclerView.setAdapter(adapter);

        // Layout manager 추가
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);*/
    }
}
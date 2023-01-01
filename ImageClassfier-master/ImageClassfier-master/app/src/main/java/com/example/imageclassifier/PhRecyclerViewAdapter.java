package com.example.imageclassifier;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


    public class PhRecyclerViewAdapter extends RecyclerView.Adapter<PhRecyclerViewHolder> {

        private ArrayList<String> mNameList;

        public PhRecyclerViewAdapter(ArrayList<String> a_list) {
            mNameList = a_list;
        }

        @Override
        public PhRecyclerViewHolder onCreateViewHolder(ViewGroup a_viewGroup, int a_viewType) {
            View view = LayoutInflater.from(a_viewGroup.getContext()).inflate(R.layout.item_list, a_viewGroup, false);
            return new PhRecyclerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(PhRecyclerViewHolder a_viewHolder, int a_position) {
            String strName = mNameList.get(a_position);
            a_viewHolder.tvName.setText(strName);

        }

        @Override
        public int getItemCount() {
            return mNameList.size();
        }
    }


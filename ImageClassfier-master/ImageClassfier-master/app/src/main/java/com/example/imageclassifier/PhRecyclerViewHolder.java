package com.example.imageclassifier;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class PhRecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView tvName;


    public PhRecyclerViewHolder(View a_itemView) {
        super(a_itemView);

        tvName = a_itemView.findViewById(R.id.tv_name);
    }

}
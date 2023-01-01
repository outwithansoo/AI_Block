package com.example.imageclassifier.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imageclassifier.Data.VariableData;
import com.example.imageclassifier.R;

import java.util.ArrayList;

public class VariableListAdapter extends RecyclerView.Adapter<VariableListAdapter.ViewHolder> {

    private ArrayList<VariableData> mData = null;
    public VariableListAdapter(ArrayList<VariableData> list){
        this.mData = list;
    }
    public Context context;
    private OnItemClickListener mListener = null;

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.variable_item_list,parent, false);
        ViewHolder vh = new VariableListAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VariableData data = mData.get(position);

        holder.variableName.setText(data.getVariableName());
        holder.variableData.setText(data.getVariableData().toString());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView variableName, variableData;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            variableName = itemView.findViewById(R.id.variable_item_name);
            variableData = itemView.findViewById(R.id.variable_item_data);

            itemView.setOnLongClickListener(new View.OnLongClickListener(){

                @Override
                public boolean onLongClick(View view) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION) {
                        VariableData item = mData.get(pos);
                        if (mListener != null)
                            mListener.onItemLongClick(view, pos, item);
                    }
                    return true;
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        VariableData item = mData.get(pos);
                        if (mListener != null){
                            mListener.onItemClick(view, pos, item);
                        }
                    }
                }
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position, VariableData item);
        void onItemLongClick(View v, int position, VariableData item);
    }
}

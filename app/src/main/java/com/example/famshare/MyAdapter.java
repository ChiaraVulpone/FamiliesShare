package com.example.famshare;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList name_id, desc_id, age_id;
    private OnListElemListener XonListElemListener; //qui

    public MyAdapter(Context context, ArrayList name_id, ArrayList desc_id, ArrayList age_id, OnListElemListener onListElemListener) { //qui
        this.context = context;
        this.name_id = name_id;
        this.desc_id = desc_id;
        this.age_id = age_id;
        this.XonListElemListener = onListElemListener; //qui
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v, XonListElemListener); //qui
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_id.setText(String.valueOf(name_id.get(position)));
        holder.age_id.setText(String.valueOf(age_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener { //qui
        TextView name_id, age_id;
        OnListElemListener xonListElemListener; //qui
        Button deletepa; //eee

        public MyViewHolder(@NonNull View itemView, OnListElemListener onListElemListener) { //qui
            super(itemView);
            name_id = itemView.findViewById(R.id.textname);
            age_id = itemView.findViewById(R.id.textage);
            deletepa = itemView.findViewById(R.id.button_deletePA);

            this.xonListElemListener = onListElemListener; //qui

            itemView.setOnClickListener(this);//qui
            deletepa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onListElemListener!=null) {
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {onListElemListener.onDeleteClick(position);}
                    }
                }

            });
        }



        @Override
        public void onClick(View v) {  //qui
          xonListElemListener.onElemClick(getAdapterPosition());//qui
        }
    }

    public interface OnListElemListener { //qui
        void onElemClick(int position);
        void onDeleteClick(int position);
    }
}
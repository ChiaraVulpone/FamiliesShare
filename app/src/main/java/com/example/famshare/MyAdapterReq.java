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

public class MyAdapterReq extends RecyclerView.Adapter<MyAdapterReq.MyViewHolder> {
    private Context context;
    private ArrayList title_id, email_id, date;
    private MyAdapterReq.OnListElemListener XonListElemListener; //qui


    public MyAdapterReq(Context context, ArrayList title_id, ArrayList email_id, ArrayList content_id, MyAdapterReq.OnListElemListener onListElemListener) { //qui
        this.context = context;
        this.title_id = title_id;
        this.email_id = email_id;
        this.date = content_id;
        this.XonListElemListener = onListElemListener; //qui
    }

    @NonNull
    @Override
    public MyAdapterReq.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.reqentry,parent,false);
        return new MyAdapterReq.MyViewHolder(v, XonListElemListener); //qui
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterReq.MyViewHolder holder, int position) {
        holder.title_id.setText(String.valueOf(title_id.get(position)));
        holder.content_id.setText(String.valueOf(date.get(position)));
    }

    @Override
    public int getItemCount() {
        return title_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener { //qui
        TextView title_id, content_id;
        MyAdapterReq.OnListElemListener onListElemListener; //qui
        Button addReq;

        public MyViewHolder(@NonNull View itemView, OnListElemListener onListElemListener) { //qui
            super(itemView);
            title_id = itemView.findViewById(R.id.texttitle2);
            content_id = itemView.findViewById(R.id.textdate2);
            this.onListElemListener = onListElemListener; //qui
            addReq = itemView.findViewById(R.id.button3);

            itemView.setOnClickListener(this); //qui

            addReq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onListElemListener!=null) {
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {onListElemListener.onAddClick(position);}
                    }
                }
            });

        }

        @Override
        public void onClick(View v) {  //qui
            onListElemListener.onElemClick1(getAdapterPosition());//qui
        }
    }

    public interface OnListElemListener { //qui
        void onElemClick1(int position);
        void onAddClick(int position);
    }
}
package com.example.famshare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterInc extends RecyclerView.Adapter<MyAdapterInc.MyViewHolder> {
    private Context context;
    private ArrayList title_id, email_id, content_id;
    private MyAdapterInc.OnListElemListener XonListElemListener; //qui


    public MyAdapterInc(Context context, ArrayList title_id, ArrayList email_id, ArrayList content_id, MyAdapterInc.OnListElemListener onListElemListener) { //qui
        this.context = context;
        this.title_id = title_id;
        this.email_id = email_id;
        this.content_id = content_id;
        this.XonListElemListener = onListElemListener; //qui
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.incentry,parent,false);
        return new MyAdapterInc.MyViewHolder(v, XonListElemListener); //qui
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title_id.setText(String.valueOf(title_id.get(position)));
        holder.email_id.setText(String.valueOf(email_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return title_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener { //qui
        TextView title_id, email_id;
        MyAdapterInc.OnListElemListener onListElemListener; //qui

        public MyViewHolder(@NonNull View itemView, MyAdapterInc.OnListElemListener onListElemListener) { //qui
            super(itemView);
            title_id = itemView.findViewById(R.id.texttitle1);
            email_id = itemView.findViewById(R.id.textdate1);
            this.onListElemListener = onListElemListener; //qui

            itemView.setOnClickListener(this); //qui


        }

        @Override
        public void onClick(View v) {  //qui
            onListElemListener.onElemClick(getAdapterPosition());//qui
        }
    }

    public interface OnListElemListener { //qui
        void onElemClick(int position);
    }
}
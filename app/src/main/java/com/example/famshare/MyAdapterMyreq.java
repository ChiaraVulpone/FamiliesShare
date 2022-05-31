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

public class MyAdapterMyreq extends RecyclerView.Adapter<MyAdapterMyreq.MyViewHolder> {
    private Context context;
    private ArrayList title_id, email_id, date;
    private MyAdapterMyreq.OnListElemListener XonListElemListener; //qui


    public MyAdapterMyreq(Context context, ArrayList title_id, ArrayList email_id, ArrayList content_id, MyAdapterMyreq.OnListElemListener onListElemListener) { //qui
        this.context = context;
        this.title_id = title_id;
        this.email_id = email_id;
        this.date = content_id;
        this.XonListElemListener = onListElemListener; //qui
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.myreqentry,parent,false);
        return new MyAdapterMyreq.MyViewHolder(v, XonListElemListener); //qui
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title_id.setText(String.valueOf(title_id.get(position)));
        holder.content_id.setText(String.valueOf(date.get(position)));
    }

    @Override
    public int getItemCount() {
        return title_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener { //qui
        TextView title_id, content_id;
        MyAdapterMyreq.OnListElemListener onListElemListener; //qui
        Button deleteReq; //eee

        public MyViewHolder(@NonNull View itemView, MyAdapterMyreq.OnListElemListener onListElemListener) { //qui
            super(itemView);
            title_id = itemView.findViewById(R.id.texttitlemy);
            content_id = itemView.findViewById(R.id.textdatemy);
            deleteReq = itemView.findViewById(R.id.cancellareqbutton);

            this.onListElemListener = onListElemListener; //qui


            itemView.setOnClickListener(this); //qui

            deleteReq.setOnClickListener(new View.OnClickListener() {
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
            onListElemListener.onElemClick(getAdapterPosition());//qui
        }
    }

    public interface OnListElemListener { //qui
        void onElemClick(int position);
        void onDeleteClick(int position);

    }
}
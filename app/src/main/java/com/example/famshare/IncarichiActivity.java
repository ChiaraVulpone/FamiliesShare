package com.example.famshare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.famshare.DataBase.CurrentUser;
import com.example.famshare.DataBase.DBHelper;

import java.util.ArrayList;


public class IncarichiActivity extends AppCompatActivity implements MyAdapterInc.OnListElemListener { //qui
    RecyclerView recyclerView;
    ArrayList<String> title, email, content;
    DBHelper DB;
    MyAdapterInc adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incarichi);
        DB = new DBHelper(this);
        title = new ArrayList<>();
        email = new ArrayList<>();
        content = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerviewi);
        adapter = new MyAdapterInc(this, title, email, content,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata()
    {
        Cursor cursor = DB.getdataInc(CurrentUser.CURRENTUSER);
        if(cursor.getCount()==0)
        {
            Toast.makeText(IncarichiActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            cursor.close();
            return;
        }
        else
        {
            while(cursor.moveToNext())
            {
                title.add(cursor.getString(0));
                email.add(cursor.getString(1));
                content.add(cursor.getString(2));
            }
        }
        cursor.close();
    }
    @Override
    public void onElemClick(int position) { //qui
        title.get(position);
        CurrentUser.reference=title.get(position);
        Intent intent = new Intent(this,RequestInfoActivity.class);
        startActivity(intent);
    }
}
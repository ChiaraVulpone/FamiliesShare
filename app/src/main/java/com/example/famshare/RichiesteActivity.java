package com.example.famshare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.famshare.DataBase.CurrentUser;
import com.example.famshare.DataBase.DBHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RichiesteActivity extends AppCompatActivity implements MyAdapterReq.OnListElemListener, MyAdapterMyreq.OnListElemListener { //qui
    RecyclerView recyclerView,recyclerView1;
    ArrayList<String> title, email, date,emailRe;
    ArrayList<String> title1, email1, date1,emailRe1;
    DBHelper DB;
    MyAdapterMyreq adapter;
    MyAdapterReq adapter1;
    FloatingActionButton AddReq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_richieste);
        DB = new DBHelper(this);
        title = new ArrayList<>();
        email = new ArrayList<>();
        date = new ArrayList<>();
        title1 = new ArrayList<>();
        email1 = new ArrayList<>();
        date1 = new ArrayList<>();
        AddReq=(FloatingActionButton) findViewById(R.id.floatingActionAddreq);
        recyclerView = findViewById(R.id.recyclerviewmyreq);
        recyclerView1 = findViewById(R.id.recyclerviewreq);

        adapter1 = new MyAdapterReq(this, title1, email1, date1,this);
        recyclerView1.setAdapter(adapter1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        displaydata1();


        adapter = new MyAdapterMyreq(this, title, email, date,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

        AddReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoAddReq(); }
        });
    }

    private void displaydata()
    {
        Cursor cursor = DB.getdataMyReq(CurrentUser.CURRENTUSER);
        if(cursor.getCount()==0)
        {
            Toast.makeText(RichiesteActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            cursor.close();
            return;
        }
        else
        {
            while(cursor.moveToNext())
            {
                title.add(cursor.getString(0));
                email.add(cursor.getString(1));
                date.add(cursor.getString(2));
            }
        }
        cursor.close();
    }

    private void displaydata1()
    {
        Cursor cursor = DB.getdataReq(CurrentUser.CURRENTUSER);
        if(cursor.getCount()==0)
        {
            Toast.makeText(RichiesteActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            cursor.close();
            return;
        }
        else
        {
            while(cursor.moveToNext())
            {
                title1.add(cursor.getString(0));
                email1.add(cursor.getString(1));
                date1.add(cursor.getString(2));
            }
        }
        cursor.close();
    }

    public void gotoAddReq(){
        Intent intent = new Intent(this,AddReqActivity.class);
        startActivity(intent);
    }

    @Override
    public void onElemClick(int position) { //qui
        title.get(position);
        CurrentUser.referenceR=title.get(position);
        CurrentUser.emailR=email.get(position);
        Intent intent = new Intent(this,RequestInfoActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDeleteClick(int position) {
        title.get(position);
        CurrentUser.referenceR=title.get(position);
        DB.deletetask(CurrentUser.referenceR);
        Intent intent = new Intent(this,RichiesteActivity.class);
        startActivity(intent);
    }

    @Override
    public void onElemClick1(int position1) { //qui
        title1.get(position1);
        CurrentUser.referenceR=title1.get(position1);
        CurrentUser.emailR=email1.get(position1);
        Intent intent = new Intent(this,RequestInfoActivity.class);
        startActivity(intent);
    }

    @Override
    public void onAddClick(int position) {
        title1.get(position);
        CurrentUser.referenceR=title1.get(position);
        DB.modifyCarry(CurrentUser.referenceR,CurrentUser.CURRENTUSER);
        Intent intent = new Intent(this,RichiesteActivity.class);
        startActivity(intent);
    }


}
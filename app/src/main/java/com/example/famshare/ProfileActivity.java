package com.example.famshare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.famshare.DataBase.CurrentUser;
import com.example.famshare.DataBase.DBHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;



public class ProfileActivity extends AppCompatActivity implements MyAdapter.OnListElemListener { //qui
    TextView nomeU,cognomeU,telU,emailU;
    RecyclerView recyclerView;
    ArrayList<String> name, email, age, userstring;
    DBHelper DB;
    MyAdapter adapter;
    FloatingActionButton AddPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nomeU= (TextView)findViewById(R.id.nomeUser);
        cognomeU= (TextView)findViewById(R.id.cognomeUser);
        telU= (TextView)findViewById(R.id.telUser);
        emailU= (TextView)findViewById(R.id.emailUser);
        userstring = new ArrayList<>();

        AddPA= (FloatingActionButton) findViewById(R.id.addpaButton);
        DB = new DBHelper(this);
        name = new ArrayList<>();
        email = new ArrayList<>();
        age = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerviewp);
        adapter = new MyAdapter(this, name, email, age,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayUSER();
        displaydata();

        emailU.setText(String.valueOf(userstring.get(0)));
        nomeU.setText(String.valueOf(userstring.get(1)));
        cognomeU.setText(String.valueOf(userstring.get(2)));
        telU.setText(String.valueOf(userstring.get(3)));

        AddPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoAddPa(); }
        });
    }

    private void displaydata()
    {
        Cursor cursor = DB.getdataPa(CurrentUser.CURRENTUSER);
        if(cursor.getCount()==0)
        {
            Toast.makeText(ProfileActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            cursor.close();
            return;
        }
        else
        {
            while(cursor.moveToNext())
            {
                name.add(cursor.getString(0));
                email.add(cursor.getString(1));
                age.add(cursor.getString(2));
            }
        }
        cursor.close();
    }

    private void displayUSER()
    {
        Cursor cursor = DB.getdata(CurrentUser.CURRENTUSER);
        if(cursor.getCount()==0)
        {
            Toast.makeText(ProfileActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            cursor.close();
            return;
        }
        else
        {
            while(cursor.moveToNext())
            {
                userstring.add(cursor.getString(0));
                userstring.add(cursor.getString(1));
                userstring.add(cursor.getString(2));
                userstring.add(cursor.getString(3));
            }
        }
        cursor.close();
    }


    public void gotoAddPa(){
        Intent intent = new Intent(this,AddPaActivity.class);
        startActivity(intent);
    }

    @Override
    public void onElemClick(int position) { //qui
        name.get(position);
        CurrentUser.reference=name.get(position);
        Intent intent = new Intent(this,PAActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDeleteClick(int position) {
        name.get(position);
        CurrentUser.reference=name.get(position);
        DB.deletepa(CurrentUser.reference,CurrentUser.CURRENTUSER);
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }
}
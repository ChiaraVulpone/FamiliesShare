package com.example.famshare;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.famshare.DataBase.CurrentUser;
import com.example.famshare.DataBase.DBHelper;

import java.util.ArrayList;

public class PAActivity extends AppCompatActivity {
    TextView nomeP,descP,annoP;
    ArrayList<String> pastring;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pa);

        nomeP= (TextView)findViewById(R.id.nomePAText);
        descP= (TextView)findViewById(R.id.necessPA);
        annoP= (TextView)findViewById(R.id.annoPaText);

        pastring = new ArrayList<>();
        DB = new DBHelper(this);

        displayUSER();

        nomeP.setText(String.valueOf(pastring.get(0)));
        descP.setText(String.valueOf(pastring.get(1)));
        annoP.setText(String.valueOf(pastring.get(2)));
    }

    private void displayUSER() {
        Cursor cursor = DB.getdataPaOnID(CurrentUser.CURRENTUSER,CurrentUser.reference);
        if(cursor.getCount()==0)
        {
            Toast.makeText(PAActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            cursor.close();
            return;
        }
        else
        {
            while(cursor.moveToNext())
            {
                pastring.add(cursor.getString(0));
                pastring.add(cursor.getString(1));
                pastring.add(cursor.getString(2));
            }
        }
        cursor.close();
    }
}
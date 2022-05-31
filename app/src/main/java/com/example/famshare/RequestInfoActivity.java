package com.example.famshare;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.famshare.DataBase.CurrentUser;
import com.example.famshare.DataBase.DBHelper;

import java.util.ArrayList;

public class RequestInfoActivity extends AppCompatActivity {
    TextView titolo, desc, data,NameR,TElR;
    ArrayList<String> InfoString,Other;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_info);


        titolo = (TextView)findViewById(R.id.titolor);
        desc = (TextView)findViewById(R.id.contR);
        data = (TextView)findViewById(R.id.dataR);
        NameR = (TextView)findViewById(R.id.textView6);
        TElR = (TextView)findViewById(R.id.textView7);

        InfoString = new ArrayList<>();
        Other = new ArrayList<>();
        DB = new DBHelper(this);

        displayReq();
        displayReqUser();

        titolo.setText(String.valueOf(InfoString.get(0)));
        data.setText(String.valueOf(InfoString.get(1)));
        data.setText(String.valueOf(InfoString.get(2)));
        desc.setText(String.valueOf(InfoString.get(3)));
        NameR.setText(String.valueOf(Other.get(0)));
        NameR.setText(String.valueOf(Other.get(1))+ " " +String.valueOf(Other.get(2)));
        TElR.setText(String.valueOf(Other.get(3)));

    }

    private void displayReq() {
        Cursor cursor = DB.getdataMyReqOnID(CurrentUser.emailR,CurrentUser.referenceR);
        if(cursor.getCount()==0)
        {
            Toast.makeText(RequestInfoActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            cursor.close();
            return;
        }
        else
        {
            while(cursor.moveToNext())
            {
                InfoString.add(cursor.getString(0));
                InfoString.add(cursor.getString(1));
                InfoString.add(cursor.getString(2));
                InfoString.add(cursor.getString(3));
            }
        }
        cursor.close();
    }

    private void displayReqUser() {
        Cursor cursor = DB.getdata(CurrentUser.emailR);
        if(cursor.getCount()==0)
        {
            Toast.makeText(RequestInfoActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            cursor.close();
            return;
        }
        else
        {
            while(cursor.moveToNext())
            {
                Other.add(cursor.getString(0));
                Other.add(cursor.getString(1));
                Other.add(cursor.getString(2));
                Other.add(cursor.getString(3));
            }
        }
        cursor.close();
    }
}
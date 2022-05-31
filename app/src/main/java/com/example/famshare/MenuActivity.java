package com.example.famshare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Button buttonp;
    private Button buttonr;
    private Button buttoni;
    private Button buttonx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        buttonr= (Button) findViewById(R.id.buttonRic);
        buttoni= (Button) findViewById(R.id.buttonInc);
        buttonx= (Button) findViewById(R.id.buttonInfo);
        buttonp= (Button) findViewById(R.id.buttonPro);
        buttonp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoProfile(); }
        });
        buttonx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoInfo(); }
        });
        buttoni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoIncarichi(); }
        });
        buttonr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoReq(); }
        });
    }

    public void gotoProfile(){
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }
    public void gotoReq(){
        Intent intent = new Intent(this,RichiesteActivity.class);
        startActivity(intent);
    }
    public void gotoIncarichi(){
        Intent intent = new Intent(this,IncarichiActivity.class);
        startActivity(intent);
    }

    public void gotoInfo(){
        Intent intent = new Intent(this,InfActivity.class);
        startActivity(intent);
    }

}
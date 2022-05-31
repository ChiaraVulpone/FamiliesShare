package com.example.famshare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.famshare.DataBase.CurrentUser;
import com.example.famshare.DataBase.DBHelper;

public class AddReqActivity extends AppCompatActivity {
    private EditText titolo, desc, data;
    private Button req_add;
    DBHelper DB;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_req);

        req_add =(Button)findViewById(R.id.addreqButton1);
        titolo=(EditText)findViewById(R.id.editTextTitle1);
        data =(EditText)findViewById(R.id.editdate1);
        desc =(EditText)findViewById(R.id.editTextTextDesc1);

        DB= new DBHelper(this);


        req_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reqtit = titolo.getText().toString();
                String reqdesc = desc.getText().toString();
                String reqdate = data.getText().toString();


                if (TextUtils.isEmpty(reqtit) || TextUtils.isEmpty(reqdesc) || TextUtils.isEmpty(reqdate))
                { Toast.makeText(AddReqActivity.this, "Manca qualcosa", Toast.LENGTH_SHORT).show();}
                else
                {
                        Boolean insert=DB.insertreqdata(reqtit, CurrentUser.CURRENTUSER, reqdesc,reqdate, CurrentUser.CURRENTUSER);
                        if(insert== true) {
                            Toast.makeText(AddReqActivity.this, "INSERTED", Toast.LENGTH_LONG).show();
                            gotoRequest();
                        }
                        else
                            Toast.makeText(AddReqActivity.this, "richiesta non inserita", Toast.LENGTH_SHORT).show();
                    }
                }
        });
    }

    public void gotoRequest(){
        Intent intent = new Intent(this,RichiesteActivity.class);
        startActivity(intent);
    }
}
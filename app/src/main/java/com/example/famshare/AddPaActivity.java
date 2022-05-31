package com.example.famshare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.famshare.DataBase.CurrentUser;
import com.example.famshare.DataBase.DBHelper;

public class AddPaActivity extends AppCompatActivity {
    private EditText namesurname,nec,year;
    private Button conf_add;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pa);

        conf_add=(Button)findViewById(R.id.con_add_btt);
        namesurname=(EditText)findViewById(R.id.edittextnomcogPa);
        year=(EditText)findViewById(R.id.editTextYear);
        nec=(EditText)findViewById(R.id.editTextTextMultiLine);

        DB= new DBHelper(this);


        conf_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameSur = namesurname.getText().toString();
                String userNec = nec.getText().toString();
                String userYear = year.getText().toString();


                if (TextUtils.isEmpty(userNameSur) || TextUtils.isEmpty(userNec) || TextUtils.isEmpty(userYear))
                { Toast.makeText(AddPaActivity.this, "Manca qualcosa", Toast.LENGTH_SHORT).show();}
                else
                {
                    Boolean checkpa= DB.checkpaname(userNameSur);
                    if(checkpa==false){
                        Boolean insert=DB.insertpadata(userNameSur,userNec,userYear, CurrentUser.CURRENTUSER);
                        if(insert== true) {
                                Toast.makeText(AddPaActivity.this, "Inserito correttamente", Toast.LENGTH_LONG).show();
                                gotoProfile();
                            }
                            else
                                Toast.makeText(AddPaActivity.this, "pa non inserito", Toast.LENGTH_SHORT).show();
                     }
                else{
                        Toast.makeText(AddPaActivity.this, "utente già esistente", Toast.LENGTH_SHORT).show();
                    }
                }
                }
        });
    }

    public void gotoProfile(){
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }
}
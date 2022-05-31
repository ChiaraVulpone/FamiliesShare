package com.example.famshare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.famshare.DataBase.CurrentUser;
import com.example.famshare.DataBase.DBHelper;

public class LoginActivity extends AppCompatActivity {
    private TextView text;
    private Button button;
    private EditText email,pswrd;
    DBHelper DB; //qui

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        button= (Button) findViewById(R.id.login_button);
        text= (TextView) findViewById(R.id.HereText);
        email= (EditText) findViewById(R.id.editemail6);
        pswrd= (EditText) findViewById(R.id.editpassword6);
        DB= new DBHelper(this); //qui

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userEmail= email.getText().toString();
                String userPsw= pswrd.getText().toString();

                if(TextUtils.isEmpty(userEmail)|| TextUtils.isEmpty(userPsw))
                { Toast.makeText(LoginActivity.this,"Manca qualcosa", Toast.LENGTH_SHORT).show();}
                else
                { Boolean checkuserpsw= DB.checkuseremailpsw(userEmail,userPsw);

                    if(checkuserpsw==true){
                        CurrentUser.CURRENTUSER=userEmail;
                        Toast.makeText(LoginActivity.this,"Login effettuato", Toast.LENGTH_SHORT).show();
                        gotoMenu();
                    }
                    else{
                        Toast.makeText(LoginActivity.this,"Login FALLITO", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoSignUp(); }
        });
    }
    public void gotoSignUp(){
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }
    public void gotoMenu(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}

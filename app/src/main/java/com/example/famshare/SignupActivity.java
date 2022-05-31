package com.example.famshare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.famshare.DataBase.DBHelper;

public class SignupActivity extends AppCompatActivity {
    private TextView text;
    private EditText name,surname,email,pswrd,tel;
    private CheckBox privacy;
    private Button signup;
    private CheckBox cbPrivacy;
    DBHelper DB; //qui

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signup=(Button)findViewById(R.id.signup_button);
        privacy=(CheckBox)findViewById(R.id.checkBox);
        name=(EditText)findViewById(R.id.nameBox);
        surname=(EditText)findViewById(R.id.SurnameBox);
        email=(EditText)findViewById(R.id.editemail2);
        tel=(EditText)findViewById(R.id.telefono);
        pswrd=(EditText)findViewById(R.id.editpassword2) ;
        text= (TextView) findViewById(R.id.privacytxt);
        cbPrivacy= (CheckBox) findViewById(R.id.checkBox);

        DB= new DBHelper(this); //qui

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoPrivacy(); }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName= name.getText().toString();
                String userSurname= surname.getText().toString();
                String userEmail= email.getText().toString();
                String userTel= tel.getText().toString();
                String userPsw= pswrd.getText().toString();

                if(TextUtils.isEmpty(userName)|| TextUtils.isEmpty(userSurname)|| TextUtils.isEmpty(userEmail)|| TextUtils.isEmpty(userTel)|| TextUtils.isEmpty(userPsw))
                    Toast.makeText(SignupActivity.this,"Manca qualcosa", Toast.LENGTH_SHORT).show();
                else
                {
                        Boolean checkuser= DB.checkuseremail(userEmail);
                    if(checkuser==false){
                                        Boolean insert=DB.insertuserdata( userEmail, userTel, userName, userSurname, userPsw);
                                        if(insert== true) {
                                            if(cbPrivacy.isChecked()){

                                                Toast.makeText(SignupActivity.this, "Sign up completato", Toast.LENGTH_LONG).show();
                                                gotoLogin();
                                            }
                                            else
                                                Toast.makeText(SignupActivity.this, "Accetta le condizioni di privacy", Toast.LENGTH_SHORT).show();
                                        }
                                        else {Toast.makeText(SignupActivity.this, "DIOCANE", Toast.LENGTH_SHORT).show(); }
                    }
                    else{
                        Toast.makeText(SignupActivity.this, "User già esistente", Toast.LENGTH_SHORT).show();
                        }
                }

            }
        });


    }
    public void gotoPrivacy(){
        Intent intent = new Intent(this, PrivacyInfoActivity.class);
        startActivity(intent);
    }

    public void gotoLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
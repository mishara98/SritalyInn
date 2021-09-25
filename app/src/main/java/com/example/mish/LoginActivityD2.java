package com.example.mish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivityD2 extends AppCompatActivity {

    EditText username,password;
    Button Signin,Signup;
    MyDB DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_d2);

        username = findViewById(R.id.Logname);
        password = findViewById(R.id.Logpassword);
        Signin = findViewById(R.id.logbtn);
        Signup = findViewById(R.id.signupBtn);
        DB = new MyDB(this);

        Signin.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          String user = username.getText().toString();
                                          String pass = password.getText().toString();

                                          if (TextUtils.isEmpty(user)||TextUtils.isEmpty(pass))
                                              Toast.makeText(LoginActivityD2.this, "All fields Required", Toast.LENGTH_SHORT).show();
                                          else{
                                              boolean checkuserpass = DB.checkusernamepassword(user,pass);
                                              if (checkuserpass == true) {
                                                  Toast.makeText(LoginActivityD2.this, "login successful", Toast.LENGTH_SHORT).show();
                                                  Intent intent =  new Intent(getApplicationContext(),GProfileActivity.class); //home activity
                                                  intent.putExtra("kusername",user);
                                                  intent.putExtra("kpwd",pass);
                                                  startActivity(intent);
                                                  //  Intent intent = new Intent(getApplicationContext(),GProfileActivity.class);
                                                  //  startActivity(intent);
                                              }else
                                                  Toast.makeText(LoginActivityD2.this, "login failed", Toast.LENGTH_SHORT).show();
                                          }

                                      }
                                  }


        );
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Home.class);
                startActivity(intent);
            }
        });
    }
}
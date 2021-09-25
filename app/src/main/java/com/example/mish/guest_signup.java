package com.example.mish;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class guest_signup extends AppCompatActivity {
    EditText username,password,repassword;
    Button Signin,Signup,view;
    MyDB DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_signup);
        username = findViewById(R.id.InputUsername);
        password = findViewById(R.id.InputPassword);
        repassword = findViewById(R.id.Repassword);
        Signup = findViewById(R.id.Signupbtn);
        Signin = findViewById(R.id.Signinbtn);

        DB = new MyDB(this);




        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (TextUtils.isEmpty(user)||TextUtils.isEmpty(pass))
                    Toast.makeText(guest_signup.this, "All fields Required", Toast.LENGTH_SHORT).show();
                else{
                    if (pass.equals(repass)){
                        boolean checkuser= DB.checkusername(user);
                        if (!checkuser) {
                            boolean insert = DB.insertData(
                                    username.getText().toString(),
                                    password.getText().toString() );
                            if (insert==true){
                                Toast.makeText(guest_signup.this, "Registerd successfully", Toast.LENGTH_SHORT).show();
                                Intent intent =  new Intent(getApplicationContext(),Home.class);//should go to the homepage
                                startActivity(intent);
                            }else{
                                Toast.makeText(guest_signup.this, "Failed", Toast.LENGTH_SHORT).show();
                            }

                        }else {
                            Toast.makeText(guest_signup.this, "User already exists", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(guest_signup.this, "passwords are not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginActivityD2.class);
                startActivity(intent);
            }
        });
        //should be in admin
        /*view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.Getdata();
                if(res.getCount()==0){
                    Toast.makeText(guest_signup.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name :"+res.getString(0)+"\n");
                    buffer.append("pwd :"+res.getString(1)+"\n");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(guest_signup.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });*/
    }
}
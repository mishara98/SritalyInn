package com.example.mish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class SelectLogin extends AppCompatActivity {

    private Button move;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_login);
        move = findViewById(R.id.button2);
        move.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(SelectLogin.this,AdminLogin.class);
                startActivity(intent);
            }
        });


        move = findViewById(R.id.button1);
        move.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(SelectLogin.this,LoginActivityD2.class);
                startActivity(intent);
            }
        });


    }
}
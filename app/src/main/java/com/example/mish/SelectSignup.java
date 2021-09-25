package com.example.mish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class SelectSignup extends AppCompatActivity {

    private Button move;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_signup);
        move = findViewById(R.id.button2);
        move.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(SelectSignup.this,AdminReg.class);
                startActivity(intent);
            }
        });


        move = findViewById(R.id.button1);
        move.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(SelectSignup.this,guest_signup.class);
                startActivity(intent);
            }
        });


    }
}
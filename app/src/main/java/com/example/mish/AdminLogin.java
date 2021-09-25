package com.example.mish;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import android.os.Bundle;

public class AdminLogin extends AppCompatActivity {
    private Button move;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        move = findViewById(R.id.button1);
        move.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(AdminLogin.this,AdminSwitch.class);
                startActivity(intent);
            }
        });

    }
}
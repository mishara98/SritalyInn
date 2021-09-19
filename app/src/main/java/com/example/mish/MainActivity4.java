package com.example.mish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity4 extends AppCompatActivity {
    private Button buttonE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        buttonE = findViewById(R.id.buttonE);
        buttonE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActicty3a();
            }
        });
    }
    public void openActicty3a(){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
}
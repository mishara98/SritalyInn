package com.example.mish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {
    private Button buttonC;
    private Button buttonN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        buttonC = findViewById(R.id.buttonC);
        buttonC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActicty4();
            }
        });
        buttonN = findViewById(R.id.buttonN);
        buttonN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActicty5();
            }
        });
    }

    public void openActicty4() {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);

    }

    public void openActicty5() {
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }
}
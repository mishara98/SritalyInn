package com.example.mish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView = (TextView)findViewById(R.id.textView5);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Facilities.class);
                startActivity(intent);

                Toast.makeText(Home.this,"You tap on facilities", Toast.LENGTH_LONG).show();
            }
        });


        textView = (TextView)findViewById(R.id.textView6);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,MainActivity.class);
                startActivity(intent);

                Toast.makeText(Home.this,"You tap on reservation", Toast.LENGTH_LONG).show();
            }
        });

        textView = (TextView)findViewById(R.id.textView7);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,RatingHome.class);
                startActivity(intent);

                Toast.makeText(Home.this,"You tap on reviews", Toast.LENGTH_LONG).show();
            }
        });

        textView = (TextView)findViewById(R.id.textView8);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,MainActivity.class);
                startActivity(intent);

                Toast.makeText(Home.this,"You tap on payments", Toast.LENGTH_LONG).show();
            }
        });


        textView = (TextView)findViewById(R.id.textView9);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,SelectLogin.class);
                startActivity(intent);

                Toast.makeText(Home.this,"You tap on login", Toast.LENGTH_LONG).show();
            }
        });

        textView = (TextView)findViewById(R.id.textView10);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,SelectSignup.class);
                startActivity(intent);

                Toast.makeText(Home.this,"You tap on signup", Toast.LENGTH_LONG).show();
            }
        });

    }
}
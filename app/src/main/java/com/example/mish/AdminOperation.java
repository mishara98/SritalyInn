package com.example.mish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AdminOperation extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_operation);
        textView = (TextView)findViewById(R.id.textView2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminOperation.this,Updateadminprofile.class);
                startActivity(intent);

                Toast.makeText(AdminOperation.this,"You tap on update profile", Toast.LENGTH_LONG).show();
            }
        });



        textView = (TextView)findViewById(R.id.textView3);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminOperation.this,MainActivity6.class);
                startActivity(intent);

                Toast.makeText(AdminOperation.this,"You tap on update reservation", Toast.LENGTH_LONG).show();
            }
        });

        textView = (TextView)findViewById(R.id.textView4);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminOperation.this,DeleteAct.class);
                startActivity(intent);

                Toast.makeText(AdminOperation.this,"You tap on manage review", Toast.LENGTH_LONG).show();
            }
        });


        textView = (TextView)findViewById(R.id.textView5);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminOperation.this,Updatehotelinfo.class);
                startActivity(intent);

                Toast.makeText(AdminOperation.this,"You tap on update hotel info", Toast.LENGTH_LONG).show();
            }
        });

    }
}
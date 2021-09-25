package com.example.mish;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class GProfileActivity extends AppCompatActivity {

    EditText dusername , dpassword;
    Button home,Editbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gprofile);
        dusername = findViewById(R.id.duser);
        dpassword = findViewById(R.id.dpwd);
        home = findViewById(R.id.hm);
        Editbutton = findViewById(R.id.Editbtn);

        String username = getIntent().getStringExtra("kusername");
        String pwd = getIntent().getStringExtra("kpwd");

        dusername.setText(username);
        dpassword.setText(pwd);


        /*home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getApplicationContext(),Home.class);
                startActivity(intent);
            }
        });*/




        Editbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(getApplicationContext(),EditGProfile.class); //home activity
                intent.putExtra("Eusername",username);
                intent.putExtra("Epwd",pwd);
                startActivity(intent);
                // Intent intent = new Intent(getApplicationContext(),EditGProfile.class);
                //startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

    }
    public void openHome(){

                Intent intent =  new Intent (this, Home.class);
                startActivity(intent);
            }



}
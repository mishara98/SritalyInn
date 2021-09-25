package com.example.mish;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mish.DBPhandler;

import org.w3c.dom.Comment;
import static android.content.ContentValues.TAG;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import android.os.Bundle;

public class EditAct2 extends AppCompatActivity {

    private Button Cbutton,Ubutton;
    private EditText etcomm;

    String id,username,comment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_act2);
        Cbutton = (Button) findViewById(R.id.cancelbtn);
        Ubutton = (Button) findViewById(R.id.updatebtn);


        etcomm = (EditText) findViewById(R.id.editComment);

        //First we call this
        getAndSetIntentData();

        Ubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //And only then we call this
                DBPhandler dbHandler = new DBPhandler(EditAct2.this);
                dbHandler.updateInfo(id,comment=etcomm.getText().toString());


            }
        });

        Cbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),comments.class);
                startActivity(intent);
            }
        });

    }

    void getAndSetIntentData(){
        if( getIntent().hasExtra("comment")) {
            //Getting Data from Intent

            id = getIntent().getStringExtra("id");
            username = getIntent().getStringExtra("username");
            comment = getIntent().getStringExtra("comment");



            //Setting Intend Data

            etcomm.setText(comment);


        }else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
}
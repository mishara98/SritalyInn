package com.example.mish;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mish.DBPhandler;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.os.Bundle;

public class RatingHome extends AppCompatActivity {

    private Button button, viewbutton;
    private EditText username,CommentInputText;

    String date;
    DBPhandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_home);
        username = (EditText) findViewById(R.id.editTextTextPersonName5);
        CommentInputText = (EditText) findViewById(R.id.editTextTextPersonName);
        button = (Button) findViewById(R.id.btn);
        viewbutton = (Button) findViewById(R.id.buttonview);





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                DBPhandler dbHandler = new DBPhandler(getApplicationContext());
                //if(username.equals(" ") && CommentInputText.equals(" ")) {
                dbHandler.addInfo(username.getText().toString(), CommentInputText.getText().toString(), Calendar.getInstance().getTime());


                Calendar calFordDate = Calendar.getInstance();
                SimpleDateFormat currentDate = new SimpleDateFormat("dd-MMMM-yyyy");
                final String saveCurrentDate = currentDate.format(calFordDate.getTime());


                final String RandomKey = username + saveCurrentDate;


                Toast.makeText(RatingHome.this, "Comment Added Successfully.Thank you!!!", Toast.LENGTH_SHORT).show();

                //}
                //  else {
                //Toast.makeText(RatingHome.this, "please enter username and comment", Toast.LENGTH_SHORT).show();
                // }
                username.setText(null);
                CommentInputText.setText(null);
            }


        });

        viewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),comments.class);
                startActivity(i);
            }
        });
    }




}
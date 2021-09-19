package com.example.mish;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity5 extends AppCompatActivity {

    private Button buttonB;
    private Button buttonCa;
    private Button buttonM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        buttonB = findViewById(R.id.buttonB);
        buttonB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActicty3b();
            }
        });
        buttonCa = findViewById(R.id.buttonCa);
        buttonCa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                alert("Your Booking Has Been Canceled");

            }
        });
        buttonM = findViewById(R.id.buttonM);
        buttonM.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                openActicty6();

            }
        });
    }
    public void openActicty3b(){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
    public void openActicty6(){
        Intent intent = new Intent(this, MainActivity6.class);
        startActivity(intent);
    }


    private void alert(String message){
        AlertDialog dil = new AlertDialog.Builder(MainActivity5.this).setTitle("Message")
                .setMessage(message).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        dil.show();
    }

}
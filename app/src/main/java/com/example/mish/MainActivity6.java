package com.example.mish;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity6 extends AppCompatActivity {

    private Button buttonCh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        buttonCh = findViewById(R.id.buttonCh);
        buttonCh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                alert("All Bookings are checked");

            }
        });
    }
    private void alert(String message){
        AlertDialog dil = new AlertDialog.Builder(MainActivity6.this).setTitle("Message")
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
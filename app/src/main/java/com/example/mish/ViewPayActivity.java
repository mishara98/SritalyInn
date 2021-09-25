package com.example.mish;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewPayActivity extends AppCompatActivity {

    Button OKbutton,backbtn;
    TextView dcardno,dcardtype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pay);
        dcardno = findViewById(R.id.dcardno);
        dcardtype = findViewById(R.id.dcardtype);
        OKbutton = findViewById(R.id.btnOk);
        backbtn = findViewById(R.id.backbtn);

        String cardno = getIntent().getStringExtra("kcardno");
        String cardtype = getIntent().getStringExtra("kcardtype");



        dcardno.setText(cardno);
        dcardtype.setText(cardtype);


        OKbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alert(" ");
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(getApplicationContext(),PaymentActivity.class);//home activity
            }
        });

    }
    public void alert(String message){
        AlertDialog dlg = new AlertDialog.Builder(ViewPayActivity.this)
                .setTitle("Your Payment is done!")
                .setMessage("Thank you for your payment. Welcome to our Hotel")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                })
                .create();
        dlg.show();
    }
}
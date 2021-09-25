package com.example.mish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class AdminReg extends AppCompatActivity {

    EditText admin_firstname, admin_lastname, admin_age, admin_email, admin_contact, admin_code, admin_password;
    TextView textView3,textView4, textView5, textView6, textView7, textView8, textView9;
    Button button2;
    DBVHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_reg);
        admin_firstname = (EditText) findViewById(R.id.admin_firstname);
        admin_lastname = (EditText) findViewById(R.id.admin_lastname);
        admin_age = (EditText) findViewById(R.id.admin_age);
        admin_email = (EditText) findViewById(R.id.admin_email);
        admin_contact = (EditText) findViewById(R.id.admin_contact);
        admin_code = (EditText) findViewById(R.id.admin_code);
        admin_password = (EditText) findViewById(R.id.admin_password);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
        button2 = (Button) findViewById(R.id.button2);
        DB = new DBVHelper(this);


        button2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String firstname = admin_firstname.getText().toString();
                String lastname = admin_lastname.getText().toString();
                String age = admin_age.getText().toString();
                String email = admin_email.getText().toString();
                String contact = admin_contact.getText().toString();
                String code = admin_code.getText().toString();
                String password = admin_password.getText().toString();

                if(firstname.equals("")||lastname.equals("")||age.equals("")||email.equals("")||contact.equals("")||code.equals("")||password.equals(""))
                    Toast.makeText(AdminReg.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean insert = DB.insertData(firstname, lastname ,age , email, contact, code, password);
                    Toast.makeText(AdminReg.this, "Register Successful", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(AdminReg.this,AdminLogin.class);
                startActivity(intent);
            }
        });

    }
}
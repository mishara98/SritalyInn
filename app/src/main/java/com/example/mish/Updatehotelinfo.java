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

public class Updatehotelinfo extends AppCompatActivity {

    EditText admin_updateoffer;
    TextView offer;
    Button edit_updateinfo, delete_updateinfo;
    DBVHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatehotelinfo);
        admin_updateoffer = (EditText) findViewById(R.id.admin_updateoffer);
        offer = (TextView) findViewById(R.id.offer);
        edit_updateinfo = (Button) findViewById(R.id.edit_updateinfo);
        delete_updateinfo = (Button) findViewById(R.id.delete_updateinfo);
        DB = new DBVHelper(this);


        edit_updateinfo.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String offer = admin_updateoffer.getText().toString();

                if(offer.equals(""))
                    Toast.makeText(Updatehotelinfo.this, "Please enter the field", Toast.LENGTH_SHORT).show();
                else{
                    Boolean insert = DB.insertofferData(offer);
                    Toast.makeText(Updatehotelinfo.this, "Update Successful", Toast.LENGTH_SHORT).show();
                } }
        });


        deleteofferData();



        /*
        delete_updateinfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String firstname = admin_firstname.getText().toString();

                if(firstname.equals("")||lastname.equals("")||age.equals("")||email.equals("")||contact.equals("")||code.equals("")||password.equals(""))
                    Toast.makeText(Updatehotelinfo.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean insert = DB.insertData(firstname, lastname ,age , email, contact, code, password);
                    Toast.makeText(Updatehotelinfo.this, "Deleted", Toast.LENGTH_SHORT).show();
                } }
        });


         */
    }

    public void deleteofferData() {
        delete_updateinfo.setOnClickListener(new View.OnClickListener() {

                                                 @Override
                                                 public void onClick(View v) {

                                                     Integer deletedRows = DB.deleteofferData(offer.getText().toString());

                                                     if(deletedRows > 0)
                                                         Toast.makeText(Updatehotelinfo.this,"Deleted",Toast.LENGTH_LONG).show();
                                                     else
                                                         Toast.makeText(Updatehotelinfo.this,"Not Deleted",Toast.LENGTH_LONG).show();
                                                 }
                                             }

        );
    }
}
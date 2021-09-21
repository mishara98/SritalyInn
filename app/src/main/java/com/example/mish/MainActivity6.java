package com.example.mish;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {

    DBHelper myDB;
    private Button buttonCh,buttonDL;
    private EditText deleteTx;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        myDB = new DBHelper(this);

        buttonCh = findViewById(R.id.buttonCh);

        deleteTx = findViewById(R.id.dlt);
        buttonDL = findViewById(R.id.db);






        viewAll();
        DeleteData2();


    }
    public void viewAll() {
        buttonCh.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Cursor res = myDB.getData();
                                           if (res.getCount() == 0) {
                                               // show message
                                               showMessage("Error", "No data found");
                                               return;
                                           }

                                           StringBuilder buffer = new StringBuilder();
                                           while (res.moveToNext()) {
                                               buffer.append("Guest  :" + res.getString(0) + "\n");
                                               buffer.append("CheckIn :" + res.getString(1) + "\n");
                                               buffer.append("CheckOut :" + res.getString(2) + "\n");
                                               buffer.append("Type :" + res.getString(3) + "\n");
                                               buffer.append("NumberOfRooms :" + res.getString(4) + "\n");
                                               buffer.append("NumberOfGuests :" + res.getString(5) + "\n");


                                           }

                                           // Show all data
                                           showMessage("Data", buffer.toString());
                                       }
                                   }

        );
    }
    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }
    public void DeleteData2(){
        buttonDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDB.deleteData(deleteTx.getText().toString());
                if(deletedRows > 0)
                    Toast.makeText(MainActivity6.this, "Booking Deleted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity6.this, "Booking Not Deleted", Toast.LENGTH_LONG).show();

            }
        });
    }



}
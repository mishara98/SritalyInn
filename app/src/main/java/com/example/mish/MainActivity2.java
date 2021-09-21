package com.example.mish;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {

    //DBHelper myDB;

    private Button button;
    private EditText calender1, calender2;
    private ImageView cal1, cal2;
    private int mDate, mMonth, mYear;

    private EditText numRoom, numGuest, guestID;
    private Spinner rooms;

    private String gusID;
    private String room;
    private String noG;
    private String noR;
    private String cki;
    private String cko;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        calender1 = findViewById(R.id.cl1);
        calender2 = findViewById(R.id.cl2);
        cal1 = findViewById(R.id.clI1);
        cal2 = findViewById(R.id.clI2);

        button = findViewById(R.id.button2);


        numRoom = findViewById(R.id.noRoom);
        numGuest = findViewById(R.id.noGuest);
        guestID = findViewById(R.id.guestID);
        rooms = findViewById(R.id.rooms_spinner);

        cal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cal1 = Calendar.getInstance();
                mDate = cal1.get(Calendar.DATE);
                mMonth = cal1.get(Calendar.MONTH);
                mYear = cal1.get(Calendar.YEAR);
                DatePickerDialog dp = new DatePickerDialog(MainActivity2.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int date) {
                        calender1.setText(date + "/" + month + "/" + year);
                    }
                }, mYear, mMonth, mDate);
                dp.show();
            }
        });
        cal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cal2 = Calendar.getInstance();
                mDate = cal2.get(Calendar.DATE);
                mMonth = cal2.get(Calendar.MONTH);
                mYear = cal2.get(Calendar.YEAR);
                DatePickerDialog dp2 = new DatePickerDialog(MainActivity2.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int date) {
                        calender2.setText(date + "/" + month + "/" + year);
                    }
                }, mYear, mMonth, mDate);
                dp2.show();
            }
        });


        Spinner spinner = (Spinner) findViewById(R.id.rooms_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.rooms_spinner));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);


        /*ckeckDate = findViewById(R.id.cl1);
        checkoutDate = findViewById(R.id.cl2);*/


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();

            }

        });

    }

    /*public void openActicty3(){
        Intent intent = new Intent(this,MainActivity3.class);
        startActivity(intent);
    }*/

    public void sendData(){
        gusID = guestID.getText().toString().trim();
        room = rooms.getSelectedItem().toString();
        cki = calender1.getText().toString().trim();
        cko = calender2.getText().toString().trim();
        noG = numGuest.getText().toString().trim();
        noR = numRoom.getText().toString().trim();

        Intent i = new Intent(this,MainActivity3.class);
        i.putExtra(MainActivity3.GuestID,gusID);
        i.putExtra(MainActivity3.Room,room);
        i.putExtra(MainActivity3.CheckIN,cki);
        i.putExtra(MainActivity3.CheckOut,cko);
        i.putExtra(MainActivity3.NoOfGuest,noG);
        i.putExtra(MainActivity3.NoOfRooms,noR);
        startActivity(i);


    }

}

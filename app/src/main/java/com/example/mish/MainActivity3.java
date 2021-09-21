package com.example.mish;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    DBHelper myDB;

    private Button buttonC;
    private Button buttonN;
    private Button buttonCM;
    public static final String GuestID = "GuestID";
    public static final String Room = "Room";
    public static final String CheckIN = "CheckIN";
    public static final String CheckOut = "CheckOut";
    public static final String NoOfGuest = "NoOfGuest";
    public static final String NoOfRooms = "NoOfRooms";

    private TextView id,rm,g,r,cki2,cko2;

    private String gusID;
    private String room;
    private String noG;
    private String noR;
    private String chki;
    private String chko;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        myDB = new DBHelper(this);


        id = findViewById(R.id.guestId2);
        cki2 = findViewById(R.id.checkin);
        cko2 = findViewById(R.id.checkout2);
        rm = findViewById(R.id.room);
        r = findViewById(R.id.numr);
        g = findViewById(R.id.numg);


        Intent i = getIntent();
        gusID = i.getStringExtra(GuestID);
        chki = i.getStringExtra(CheckIN);
        chko = i.getStringExtra(CheckOut);
        room = i.getStringExtra(Room);
        noG = i.getStringExtra(NoOfGuest);
        noR = i.getStringExtra(NoOfRooms);


        id.setText(gusID);
        rm.setText(room);
        cki2.setText(chki);
        cko2.setText(chko);
        g.setText("Number of Guests : "+noG);
        r.setText("Number Of Rooms : "+noR);



        buttonCM = findViewById(R.id.cnfm);

        buttonC = findViewById(R.id.buttonC);
        buttonC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendData2();
            }
        });
        buttonN = findViewById(R.id.buttonN);
        buttonN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActicty5();
            }
        });

        AddData();
    }
    public void AddData() {
        buttonCM.setOnClickListener(new View.OnClickListener() {
                                       public void onClick(View v) {

                                           boolean isInserted = myDB.insertData(id.getText().toString(),
                                                   cki2.getText().toString(),cko2.getText().toString(),rm.getText().toString(),
                                                   r.getText().toString(),g.getText().toString());
                                           if (isInserted == true)
                                               Toast.makeText(MainActivity3.this, "Booking Inserted", Toast.LENGTH_LONG).show();
                                           else
                                               Toast.makeText(MainActivity3.this, "Booking not Inserted", Toast.LENGTH_LONG).show();

                                       }

                                   }

        );
    }


    /*public void openActicty4() {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);

    }*/

    public void openActicty5() {
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }

    public void sendData2(){
        gusID = id.getText().toString().trim();
        chki = cki2.getText().toString().trim();
        chko = cko2.getText().toString().trim();
        room = rm.getText().toString().trim();
        noG = g.getText().toString().trim();
        noR = r.getText().toString().trim();

        Intent in = new Intent(this,MainActivity4.class);
        in.putExtra(MainActivity4.GuestID2,gusID);
        in.putExtra(MainActivity4.CheckIN2,chki);
        in.putExtra(MainActivity4.CheckOut2,chko);
        in.putExtra(MainActivity4.Room2,room);
        in.putExtra(MainActivity4.NoOfGuest2,noG);
        in.putExtra(MainActivity4.NoOfRooms2,noR);
        startActivity(in);


    }
    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }
}
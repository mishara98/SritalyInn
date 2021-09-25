package com.example.mish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    DBHelper myDB;
    private Button buttonE,buttonD;
    public static final String GuestID2 = "GuestID2";
    public static final String Room2 = "Room2";
    public static final String CheckIN2 = "CheckIN2";
    public static final String CheckOut2 = "CheckOut2";
    public static final String NoOfGuest2 = "NoOfGuest2";
    public static final String NoOfRooms2 = "NoOfRooms2";

    private EditText id2,rm2,g2,r2,cki22,cko22;

    private String gusID2;
    private String room2;
    private String noG2;
    private String noR2;
    private String chki2;
    private String chko2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        myDB = new DBHelper(this);

        id2 = findViewById(R.id.id2);
        cki22 = findViewById(R.id.i2);
        cko22 = findViewById(R.id.o2);
        rm2 = findViewById(R.id.type);
        r2 = findViewById(R.id.r2);
        g2 = findViewById(R.id.g2);


        Intent in = getIntent();
        gusID2 = in.getStringExtra(GuestID2);
        chki2 = in.getStringExtra(CheckIN2);
        chko2 = in.getStringExtra(CheckOut2);
        room2 = in.getStringExtra(Room2);
        noG2 = in.getStringExtra(NoOfGuest2);
        noR2 = in.getStringExtra(NoOfRooms2);



        id2.setText(gusID2);
        cki22.setText(chki2);
        cko22.setText(chko2);
        rm2.setText(room2);
        g2.setText(noG2);
        r2.setText(noR2);




        buttonE = findViewById(R.id.buttonE);
        updateData();
        buttonD = findViewById(R.id.button3);
        DeleteData();

    }
    public void openActicty3a(){
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }
    public void updateData(){
        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = myDB.updateData(id2.getText().toString(),
                        cki22.getText().toString(),cko22.getText().toString(),rm2.getText().toString(),
                        r2.getText().toString(),g2.getText().toString());
                if(isUpdate == true)
                    Toast.makeText(MainActivity4.this, "Reservation Changed", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity4.this, "Reservation Not Change", Toast.LENGTH_LONG).show();
                openActicty3a();

            }
        });
    }
    public void DeleteData(){
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDB.deleteData(id2.getText().toString());
                if(deletedRows > 0)
                    Toast.makeText(MainActivity4.this, "Booking Deleted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity4.this, "Booking Not Deleted", Toast.LENGTH_LONG).show();
                openActicty3a();
            }
        });
    }
}
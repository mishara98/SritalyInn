package com.example.mish;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button;
    CalendarView calender;
    CalendarView calender2;
    TextView checkOut;
    TextView checkIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActicty2();
            }
        });
        calender = findViewById(R.id.calender1);
        checkIn = findViewById(R.id.checkIn);

        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String Date = dayOfMonth + "-" + (month+1) + "-" + year;
                checkIn.setText(Date);
            }
        });
        calender2 = findViewById(R.id.calender2);
        checkOut = findViewById(R.id.checkOut);

        calender2.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String Date = dayOfMonth + "-" + (month+1) + "-" + year;
                checkOut.setText(Date);
            }
        });
    }
    public void openActicty2(){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
}
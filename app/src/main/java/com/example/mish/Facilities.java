package com.example.mish;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class Facilities extends AppCompatActivity {

    DBVHelper myDb;
    Button seeoffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities);
        myDb = new DBVHelper(this);
        seeoffer = findViewById(R.id.seeoffer);

        viewAlloffer();

    }

    public void viewAlloffer() {
        seeoffer.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Cursor res = myDb.getofferdata();
                                            if(res.getCount() == 0) {
                                                showoffer("Sorry","today not have any offer");
                                                return;
                                            }
                                            StringBuilder buffer = new StringBuilder();
                                            while (res.moveToNext()) {
                                                buffer.append("offer  :"+ res.getString(0)+"\n");
                                            }
                                            showoffer("Offer",buffer.toString());
                                        }
                                    }
        );
    }
    public void showoffer(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
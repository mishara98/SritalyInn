package com.example.mish;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mish.DBPhandler;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteAct extends AppCompatActivity {
    DBPhandler myDB;
    private Button delc,canc;
    private String id;
    private EditText delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDB = new DBPhandler(this);
        setContentView(R.layout.activity_delete);
        delc=(Button)findViewById(R.id.delbu);
        canc=(Button)findViewById(R.id.cansbt);
        delete = findViewById(R.id.dlT);


        canc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),comments.class);
                startActivity(intent);
            }
        });
        DeleteInfo();
    }
    public void DeleteInfo(){
        delc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDB.deleteInfo(delete.getText().toString());
                if(deletedRows > 0)
                    Toast.makeText(DeleteAct.this, "Comment Deleted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DeleteAct.this, "Comment Not Deleted", Toast.LENGTH_LONG).show();

            }
        });
    }
}
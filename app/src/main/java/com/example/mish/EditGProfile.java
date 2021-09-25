package com.example.mish;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;

import android.os.Bundle;

public class EditGProfile extends AppCompatActivity {

    EditText eusername , epassword;
    Button viewbtn , Editbtn,deletebtn;
    MyDB DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_gprofile);
        eusername=findViewById(R.id.Euser);
        epassword=findViewById(R.id.Epwd);
        viewbtn =findViewById(R.id.button);
        Editbtn =findViewById(R.id.Updatebtn);
        update();
        deletebtn = findViewById(R.id.deletebtn);
        deletedata();

        DB = new MyDB(this);

        String edituser = getIntent().getStringExtra("Eusername");
        String editpwd = getIntent().getStringExtra("Epwd");

        eusername.setText(edituser);
        epassword.setText(editpwd);




    }

    public  void update(){
        Editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isupdated = DB.updatedata(eusername.getText().toString(),
                        epassword.getText().toString() );
                if (isupdated==true)
                    Toast.makeText(EditGProfile.this,"Data updated",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(EditGProfile.this,"Data not updated",Toast.LENGTH_LONG).show();

            }
        });
    }

    public void deletedata(){
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = DB.deleteData(eusername.getText().toString());
                if(deletedRows > 0)
                    Toast.makeText(EditGProfile.this, "User Deleted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(EditGProfile.this, "User Not Deleted", Toast.LENGTH_LONG).show();
                // openActicty3a();
            }
        });
    }

}
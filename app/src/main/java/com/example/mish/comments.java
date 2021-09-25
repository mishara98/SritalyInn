package com.example.mish;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mish.DBPhandler;

import java.util.ArrayList;

public class comments extends AppCompatActivity {

    ContactsAdapter contactsAdapter;
    RecyclerView CommentList;
    ArrayList<Contacts> contactsArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        CommentList = (RecyclerView) findViewById(R.id.comment_list);
        CommentList.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor = new DBPhandler(this).readAllInfo();
        while (cursor.moveToNext()) {
            Contacts obj = new Contacts(cursor.getString(1), cursor.getString(2), cursor.getString(3));
            contactsArrayList.add(obj);
        }


        ContactsAdapter adapter = new ContactsAdapter( this, contactsArrayList);
        CommentList.setAdapter(adapter);



    }


}

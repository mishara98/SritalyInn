package com.example.mish;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDB extends SQLiteOpenHelper {
    public static final String DBNAME = "sritaly.db";

    public MyDB( Context context) {
        super(context, "sritaly.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists users");
    }

    public boolean insertData(String username,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username",username);
        values.put("password",password);

        long results = db.insert("users",null,values);
        if (results==-1)
            return false;
        else
            return true;
    }

    public boolean checkusername(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=?", new String[] {username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;

    }

    public boolean checkusernamepassword(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from users where username=? and password=?",new String[]{username,password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;


    }
    public Cursor Getdata ()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users", null);
        return cursor;

    }


    public boolean updatedata(String username,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("password",password);
        db.update("users",values,"username = ?",new String[]{username});
        return true;
    }

    public Integer deleteData(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("users", "username = ?", new String[]{username});
    }
}

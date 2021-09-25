package com.example.mish;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DB_Name = "Sritaly.db";
    public static final String Table_Name = "booking";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "CheckIn";
    public static final String COL_3 = "CheckOut";
    public static final String COL_4 = "RoomType";
    public static final String COL_5 = "NumberOfRooms";
    public static final String COL_6 = "NumberOfGuests";

    /*public static final String Table_Name2 = "users";

    public static final String COL_7 = "username";
    public static final String COL_8 = "password";*/


    private String Table_Create_Name = "create table " + Table_Name + " (" +
            COL_1 + " TEXT PRIMARY KEY," +
            COL_2 + " TEXT," +
            COL_3 + " TEXT," +
            COL_4 + " TEXT," +
            COL_5 + " TEXT," +
            COL_6 + " TEXT)";



    /*private String Table_Create_Name2 = "create table " + Table_Name2 + " (" +
            COL_7 + " TEXT PRIMARY KEY," +
            COL_8 + " TEXT)";*/




    public DBHelper(@Nullable Context context) {
        super(context, DB_Name, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Table_Create_Name);
        //db.execSQL(Table_Create_Name2);
        db.execSQL("create table users(username TEXT primary key, password TEXT)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        //db.execSQL("DROP TABLE IF EXISTS " + Table_Name2);
        db.execSQL("drop table if exists users");

        onCreate(db);

    }

    public boolean insertData(String ID, String CheckIn, String CheckOut, String RoomType, String NumberOfRooms, String NumberOfGuests) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, ID);
        contentValues.put(COL_2, CheckIn);
        contentValues.put(COL_3, CheckOut);
        contentValues.put(COL_4, RoomType);
        contentValues.put(COL_5, NumberOfRooms);
        contentValues.put(COL_6, NumberOfGuests);

        long result = db.insert(Table_Name, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + Table_Name, null);
        return res;
    }

    public boolean updateData(String ID, String CheckIn, String CheckOut, String RoomType, String NumberOfRooms, String NumberOfGuests) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, ID);
        contentValues.put(COL_2, CheckIn);
        contentValues.put(COL_3, CheckOut);
        contentValues.put(COL_4, RoomType);
        contentValues.put(COL_5, NumberOfRooms);
        contentValues.put(COL_6, NumberOfGuests);
        db.update(Table_Name, contentValues, "ID = ?", new String[]{ID});
        return true;

    }

    public Integer deleteData(String ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Table_Name, "ID = ?", new String[]{ID});
    }







    /*public boolean InsertData(String username,String password){
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


    public boolean Updatedata(String username,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("password",password);
        db.update("users",values,"username = ?",new String[]{username});
        return true;
    }

    public Integer DeleteData(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("users", "username = ?", new String[]{username});
    }*/


}

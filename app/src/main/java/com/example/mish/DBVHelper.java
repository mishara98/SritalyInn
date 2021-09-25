package com.example.mish;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
public class DBVHelper extends SQLiteOpenHelper{
    public static final String DBNAME = "Sritally_new.db";
    public static final String TABLE_NAME10 = "admin_table";
    public static final String TABLE_NAME11 = "admin_offer";

    public DBVHelper(Context context) {
        super(context, "Sritally_new.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table admin_table(first_name TEXT, last_name TEXT, age INTEGER, email TEXT, contact_num INTEGER, admin_code INTEGER PRIMARY KEY, password TEXT)");
        MyDB.execSQL("create Table admin_offer(offer TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists admin_table");
        MyDB.execSQL("drop Table if exists admin_offer");
    }

    public Boolean insertData(String first_name, String last_name, String age, String email, String contact_number, String admin_code, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("first_name", first_name);
        contentValues.put("last_name", last_name);
        contentValues.put("age", age);
        contentValues.put("email", email);
        contentValues.put("contact_number", contact_number);
        contentValues.put("admin_code", admin_code);
        contentValues.put("password", password);
        long result = MyDB.insert("admin_table", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean insertofferData(String offer) {

        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("offer", offer);
        long result = MyDB.insert("admin_offer", null, contentValues);
        if(result==-1) return false;
        else
            return true;

    }

    public Cursor getofferdata() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME11+"  ",  null);
        return res;
    }

    public Integer deleteofferData (String offer) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME11, "offer == ?",new String[] {offer});
    }


    /*

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }



    public Integer deleteData (String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "username == ?",new String[] {username});
    }

     */



}

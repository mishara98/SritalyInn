package com.example.mish;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class DBAHelper extends SQLiteOpenHelper{
    Encrypter en = new Encrypter();
    public static final String DBNAME = "sritally.db";

    public DBAHelper(Context context) {
        super(context, "sritally.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table paymentdetails(name TEXT primary key, contactno TEXT, email TEXT, cardtype TEXT, cardno TEXT, expdate TEXT, cvcno TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists paymentdetails");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean insertdata(String name, String contactno, String email, String cardtype, String cardno) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("contactno", contactno);
        values.put("email", email);
        values.put("cardtype", cardtype);
        values.put("cardno", en.caesarCipherEncrypt(cardno));


      /*  public String encrypt(String cardno){
            String encryptedNo= KeyGenerator.
        }*/

        long results = db.insert("paymentdetails", null, values);
        if (results == -1)
            return false;
        else
            return true;

    }


}


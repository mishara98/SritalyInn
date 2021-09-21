package com.example.mish;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_Name = "Sritaly.db";
    public static final String Table_Name = "booking";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "CheckIn";
    public static final String COL_3 = "CheckOut";
    public static final String COL_4 = "RoomType";
    public static final String COL_5 = "NumberOfRooms";
    public static final String COL_6 = "NumberOfGuests";




    private String Table_Create_Name = "create table " + Table_Name + " (" +
            COL_1 + " TEXT PRIMARY KEY," +
            COL_2 + " TEXT," +
            COL_3 + " TEXT," +
            COL_4 + " TEXT," +
            COL_5 + " TEXT," +
            COL_6 + " TEXT)";




    public DBHelper(@Nullable Context context) {
        super(context, DB_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Table_Create_Name);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);

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


}

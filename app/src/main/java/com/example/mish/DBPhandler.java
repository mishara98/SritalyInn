package com.example.mish;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import static android.content.ContentValues.TAG;

public class DBPhandler extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SritallyDB.db";

    public static final String TABLE_NAME = "Review";
    public static final String COLUMN_1 = "id";
    public static final String COLUMN_2 = "username";
    public static final String COLUMN_3 = "Comment";
    public static final String COLUMN_4 = "date";

    private String TABLE_CREATE_NAME = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_2 + " TEXT, " +
            COLUMN_3 + " TEXT," +
            COLUMN_4 + " TEXT)";

    Context context;


    public DBPhandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_NAME);

    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public long addInfo(String username, String Comment, Date date) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_2, username);
        values.put(COLUMN_3, Comment);
        values.put(COLUMN_4, String.valueOf(date));

        long newRowId = db.insert(TABLE_NAME, null, values);
        return newRowId;
    }

    public Cursor readAllInfo() {
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);
        return cursor;
    }



    public void updateInfo(String row_id, String Comment) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_3, Comment);
        // values.put(COLUMN_4, String.valueOf(date));

        long result = db.update(TABLE_NAME, values, "_id=?", new String[]{row_id});

        if (result == -1) {

            Toast.makeText(context, "Failed to update", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully update!", Toast.LENGTH_SHORT).show();
        }
    }


    public Integer deleteInfo(String id) {

        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_NAME, "id=?", new String[] {id});

    }
}

package com.example.task37_sqlitetransaction;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    final String TAG = "dbLogs";
    DBHelper dbh;
    SQLiteDatabase db;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate activity_main");
        dbh = new DBHelper(this);
        myActions();
    }

    void myActions() {
        try {
            db = dbh.getWritableDatabase();
            delete(db, "sickTable");

            db.beginTransaction();
            insert(db, "sickTable", "sickNumber");

            Log.d(TAG, "create DBHelper");
            DBHelper dbh2 = new DBHelper(this);
            Log.d(TAG, "get db");
            SQLiteDatabase db2 = dbh2.getWritableDatabase();
            select(db2, "sickTable");
            dbh2.close();

            db.setTransactionSuccessful();
            db.endTransaction();

            select(db, "sickTable");
            dbh.close();

        } catch (Exception ex) {
            Log.d(TAG, ex.getClass() + " error: " + ex.getMessage());
        }
    }




    void insert(SQLiteDatabase db, String table, String value) {
        Log.d(TAG, "Insert into table " + table + " value = " + value);
        ContentValues cv = new ContentValues();
        cv.put("sickNumber", value);
        db.insert(table, null, cv);
    }

    void delete(SQLiteDatabase db, String table) {
        Log.d(TAG, "Delete all data from table " + table);
        db.delete(table, null, null);
    }

    @SuppressLint("Range")
    void select(SQLiteDatabase db, String table) {
        Log.d(TAG, "Select from table " + table);
        Cursor c = db.query(table, null, null, null, null, null, null);
        if (c != null) {
            Log.d(TAG, "Records number = " + c.getCount());
            if (c.moveToFirst()) {
                do {
                    Log.d(TAG, c.getString(c.getColumnIndex("sickNumber")));
                } while (c.moveToNext());
            }
            c.close();
        }
    }

    // class for working with DB
    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, "sickDB", null, 1);
        }

        public void onCreate(SQLiteDatabase db) {
            Log.d(TAG, "onCreate database");

            db.execSQL("create table sickTable ("
                    + "id integer primary key autoincrement,"
                    + "sickNumber text"
                    + ");");
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}

package com.example.task53_cursorloader;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ClassDB {

    // data array
    String[] items = {"Apple", "Plum", "Tomato", "Peach", "Apricot", "Banana", "Cabbage"};

    private static final String DB_NAME = "productDB";
    private static final int DB_VERSION = 1;
    private static final String DB_TABLE = "productTable";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_IMG = "img";
    public static final String COLUMN_TXT = "txt";

    private static final String DB_CREATE =
            "create table " + DB_TABLE + "(" +
                    COLUMN_ID + " integer primary key autoincrement, " +
                    COLUMN_IMG + " integer, " +
                    COLUMN_TXT + " text" +
                    ");";

    private DBHelper prodDBHelper;
    private SQLiteDatabase prodDB;

    private final Context ctx;

    public ClassDB(Context ctx1) {
        ctx = ctx1;
    }

    // open connection
    public void open() {
        prodDBHelper = new DBHelper(ctx, DB_NAME, null, DB_VERSION);
        prodDB = prodDBHelper.getWritableDatabase();
    }

    // close connection
    public void close() {
        if (prodDBHelper!=null) prodDBHelper.close();
    }

    // get data from DB_TABLE
    public Cursor getAllData() {
        return prodDB.query(DB_TABLE, null, null, null, null, null, null);
    }

    // add row into DB_TABLE
    public void addRecord(String txt, int img) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TXT, txt);
        cv.put(COLUMN_IMG, img);
        prodDB.insert(DB_TABLE, null, cv);
    }

    // delete row from DB_TABLE
    public void deleteRecord(long id) {
        prodDB.delete(DB_TABLE, COLUMN_ID + " = " + id, null);
    }

    // database class
    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, CursorFactory factory,
                        int version) {
            super(context, name, factory, version);
        }

        // create and fill DB in
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DB_CREATE);

            ContentValues cv = new ContentValues();
            for (int i = 0; i < items.length; i++) {
                cv.put(COLUMN_TXT, items[i] + " " + i);
                cv.put(COLUMN_IMG, android.R.drawable.star_big_on);
                db.insert(DB_TABLE, null, cv);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }
}

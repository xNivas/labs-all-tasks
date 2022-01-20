package com.example.task54_customsimpleadapter3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ClassDB {

    private static final String DB_NAME = "prodDB";
    private static final int DB_VERSION = 1;

    // category table
    private static final String CATEGORY_TABLE = "category";
    public static final String CATEGORY_COLUMN_ID = "_id";
    public static final String CATEGORY_COLUMN_NAME = "name";
    private static final String CATEGORY_TABLE_CREATE = "create table "
            + CATEGORY_TABLE + "(" + CATEGORY_COLUMN_ID
            + " integer primary key, " + CATEGORY_COLUMN_NAME + " text" + ");";

    // product table
    private static final String PRODUCT_TABLE = "product";
    public static final String PRODUCT_COLUMN_ID = "_id";
    public static final String PRODUCT_COLUMN_NAME = "name";
    public static final String PRODUCT_COLUMN_CATEGORY = "category";
    private static final String PRODUCT_TABLE_CREATE = "create table "
            + PRODUCT_TABLE + "(" + PRODUCT_COLUMN_ID
            + " integer primary key autoincrement, " + PRODUCT_COLUMN_NAME
            + " text, " + PRODUCT_COLUMN_CATEGORY + " integer" + ");";

    private final Context ctx;

    private DBHelper storeDBHelper;
    private SQLiteDatabase storeDB;

    public ClassDB(Context ctx1) {
        ctx = ctx1;
    }

    // open connection
    public void open() {
        storeDBHelper = new DBHelper(ctx, DB_NAME, null, DB_VERSION);
        storeDB = storeDBHelper.getWritableDatabase();
    }

    // close connection
    public void close() {
        if (storeDBHelper != null)
            storeDBHelper.close();
    }

    // category data
    public Cursor getCategoryData() {
        return storeDB.query(CATEGORY_TABLE, null, null, null, null, null, null);
    }

    // products of the defined category
    public Cursor getProductData(long categoryID) {
        return storeDB.query(PRODUCT_TABLE, null, PRODUCT_COLUMN_CATEGORY + " = "
                + categoryID, null, null, null, null);
    }

    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, CursorFactory factory,
                        int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            ContentValues cv = new ContentValues();

            // category names
            String[] category = new String[] { "Fruits", "Vegetables", "Berries" };

            // Fill in category table
            db.execSQL(CATEGORY_TABLE_CREATE);
            for (int i = 0; i < category.length; i++) {
                cv.put(CATEGORY_COLUMN_ID, i + 1);
                cv.put(CATEGORY_COLUMN_NAME, category[i]);
                db.insert(CATEGORY_TABLE, null, cv);
            }

            // product of the defined category
            String[] fruits = new String[] { "Apple", "Plum",
                    "Apricot", "Peach" };
            String[] vegetables = new String[] { "Onion", "Cabbage",
                    "Carrot", "Pumpkin" };
            String[] berries = new String[] { "Strawberry", "Raspberry", "Blueberry",
                    "Blackberry" };

            // Create and fill in product table
            db.execSQL(PRODUCT_TABLE_CREATE);
            cv.clear();
            for (int i = 0; i < fruits.length; i++) {
                cv.put(PRODUCT_COLUMN_CATEGORY, 1);
                cv.put(PRODUCT_COLUMN_NAME, fruits[i]);
                db.insert(PRODUCT_TABLE, null, cv);
            }
            for (int i = 0; i < vegetables.length; i++) {
                cv.put(PRODUCT_COLUMN_CATEGORY, 2);
                cv.put(PRODUCT_COLUMN_NAME, vegetables[i]);
                db.insert(PRODUCT_TABLE, null, cv);
            }
            for (int i = 0; i < berries.length; i++) {
                cv.put(PRODUCT_COLUMN_CATEGORY, 3);
                cv.put(PRODUCT_COLUMN_NAME, berries[i]);
                db.insert(PRODUCT_TABLE, null, cv);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }
}


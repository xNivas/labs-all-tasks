package com.example.task36_sqliteinnerjoin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    final String TAG = "dbLogs";

    int[] country_id = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    String country_name[] = { "Russia", "Japan", "China", "USA", "Brazil",
            "Germany", "Italy", "France", "Egypt", "Canada" };
    int sickNumber[] = { 1400, 5200, 1200, 4570, 4520, 7557, 7554, 7888, 4254, 4545 };

    // data for the people table
    String[] people_name = { "Bill", "Dana", "Joe", "Peter", "Melissa", "Jack", "Chris", "Paul" };
    int[] people_country_id = { 2, 3, 10, 5, 3, 1, 2, 5 };

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connect to DB
        DBHelper dbh = new DBHelper(this);
        SQLiteDatabase db = dbh.getWritableDatabase();

        // cursor
        Cursor cur;

        //log output data for country
        Log.d(TAG, "-=Table country=-");
        cur = db.query("country", null, null, null, null, null, null);
        logCursor(cur);
        cur.close();
        Log.d(TAG, "========");

        // log output data for people
        Log.d(TAG, "-=Table people=-");
        cur = db.query("people", null, null, null, null, null, null);
        logCursor(cur);
        cur.close();
        Log.d(TAG, "========");

        // output join result
        // use rawQuery
        Log.d(TAG, "-=INNER JOIN1=-");
        String sqlQuery = "select p.people_name as Person, c.country_name as Country, sickNumber as sickNumber "
                + "from people as p "
                + "inner join country as c "
                + "on p.people_country_id = c.country_id "
                + "where sickNumber < ?";
        cur = db.rawQuery(sqlQuery, new String[] {"2000"});
        logCursor(cur);
        cur.close();
        Log.d(TAG, "========");

        // output join result
        // use query
        Log.d(TAG, "-=INNER JOIN2=-");
        String table = "people as p inner join country as c on p.people_country_id = c.country_id";
        String columns[] = { "p.people_name as Person", "c.country_name as Country", "sickNumber as sickNumber" };
        String selection = "sickNumber >= ?";
        String[] selectionArgs = {"2000"};
        cur = db.query(table, columns, selection, selectionArgs, null, null, null);
        logCursor(cur);
        cur.close();
        Log.d(TAG, "========");

        // close DB
        dbh.close();
    }

    // log output from cursor
    @SuppressLint("Range")
    void logCursor(Cursor cur) {
        if (cur != null) {
            if (cur.moveToFirst()) {
                String str;
                do {
                    str = "";
                    for (String cn : cur.getColumnNames()) {
                        str = str.concat(cn + " = " + cur.getString(cur.getColumnIndex(cn)) + "; ");
                    }
                    Log.d(TAG, str);
                } while (cur.moveToNext());
            }
        } else
            Log.d(TAG, "No data available");
    }

    // class for working with DB
    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context)
        {
            super(context, "sickDB2", null, 1);
        }

        public void onCreate(SQLiteDatabase db) {
            Log.d(TAG, "onCreate database");

            ContentValues cv = new ContentValues();

            // create country table
            db.execSQL("create table country ("
                    + "country_id integer primary key,"
                    + "country_name text," + "sickNumber integer"
                    + ");");

            // fill in this table
            for (int i = 0; i < country_id.length; i++) {
                cv.clear();
                cv.put("country_id", country_id[i]);
                cv.put("country_name", country_name[i]);
                cv.put("sickNumber", sickNumber[i]);
                db.insert("country", null, cv);
            }

            // create people table
            db.execSQL("create table people ("
                    + "people_id integer primary key autoincrement,"
                    + "people_name text,"
                    + "people_country_id integer"
                    + ");");

            // fill in this table
            for (int i = 0; i < people_name.length; i++) {
                cv.clear();
                cv.put("people_name", people_name[i]);
                cv.put("people_country_id", people_country_id[i]);
                db.insert("people", null, cv);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}


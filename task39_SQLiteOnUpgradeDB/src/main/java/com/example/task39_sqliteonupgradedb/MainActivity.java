package com.example.task39_sqliteonupgradedb;

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
    final String DB_NAME = "sickDB2";
    //final int DB_VERSION = 1; // DB version
    final int DB_VERSION = 2; // DB version


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper dbh = new DBHelper(this);
        SQLiteDatabase db = dbh.getWritableDatabase();
        Log.d(TAG, "--------SickDB v." + db.getVersion() + "--------");
        outputPeople(db);
        dbh.close();
    }


    // data request and output to the log
    private void outputPeople(SQLiteDatabase db) {
        Cursor c = db.rawQuery("select * from people", null);
        logCursor(c, "Table People");
        c.close();

        c = db.rawQuery("select * from country", null);
        logCursor(c, "Table Country");
        c.close();

        String sqlQuery = "select p.name as Person, c.country_name as Country, sickNumber as sickNumber "
                + "from people as p "
                + "inner join country as c "
                + "on p.people_country_id = c.country_id ";
        c = db.rawQuery(sqlQuery, null);
        logCursor(c, "inner join");
        c.close();
    }



    // output to the log from the cursor
    @SuppressLint("Range")
    void logCursor(Cursor c, String title) {
        if (c != null) {
            if (c.moveToFirst()) {
                Log.d(TAG, title + ". " + c.getCount() + " rows");
                StringBuilder sb = new StringBuilder();
                do {
                    sb.setLength(0);
                    for (String cn : c.getColumnNames()) {
                        sb.append(cn + " = "
                                + c.getString(c.getColumnIndex(cn)) + "; ");
                    }
                    Log.d(TAG, sb.toString());
                } while (c.moveToNext());
            }
        } else
            Log.d(TAG, title + ". Cursor is null");
    }


    // class for working with DB
    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            Log.d(TAG, "onCreate database");

            // data for the people table
            String[] people_name = { "Bill", "Dana", "Joe", "Peter", "Melissa", "Jack", "Chris", "Paul" };
            int[] people_country_id = { 2, 3, 10, 5, 3, 1, 2, 5 };

            // data for country table
            int[] country_id = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
            String country_name[] = { "Russia", "Japan", "China", "USA", "Brasil",
                    "Germany", "Italy", "France", "Egipt", "Canada" };
            int sickNumber[] = { 1400, 5200, 1200, 4570, 4520, 7557, 7554, 7888, 4254, 4545 };
            ContentValues cv = new ContentValues();

            // create country table
            db.execSQL("create table country ("
                    + "country_id integer primary key,"
                    + "country_name text,"
                    + "sickNumber integer"
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
                    + "id integer primary key autoincrement,"
                    + "name text,"
                    + "people_country_id integer"
                    + ");");

            // fill in this table
            for (int i = 0; i < people_name.length; i++) {
                cv.clear();
                cv.put("name", people_name[i]);
                cv.put("people_country_id", people_country_id[i]);
                db.insert("people", null, cv);
            }
        }


        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d(TAG, "onUpgrade database from " + oldVersion  + " to " + newVersion + " version");

            if (oldVersion == 1 && newVersion == 2) {

                ContentValues cv = new ContentValues();

                // data for country table
                int[] country_id = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
                String country_name[] = { "Russia", "Japan", "China", "USA", "Brazil",
                        "Germany", "Italy", "France", "Egypt", "Canada" };
                int sickNumber[] = { 1400, 5200, 1200, 4570, 4520, 7557, 7554, 7888, 4254, 4545 };

                db.beginTransaction();
                try {
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

                    db.execSQL("alter table people add column people_country_id integer;");

                    for (int i = 0; i < country_id.length; i++) {
                        cv.clear();
                        cv.put("people_country_id", country_id[i]);
                        db.update("people", cv, "country = ?",
                                new String[] { country_name[i] });
                    }

                    db.execSQL("create table people_tmp ("
                            + "id integer primary key autoincrement,"
                            + "name text,"
                            + "people_country_id integer"
                            + ");");

                    db.execSQL("insert into people_tmp select id, name, people_country_id from people;");
                    db.execSQL("drop table people;");

                    db.execSQL("create table people ("
                            + "id integer primary key autoincrement,"
                            + "name text,"
                            + "people_country_id integer"
                            + ");");

                    db.execSQL("insert into people select id, name, people_country_id from people_tmp;");
                    db.execSQL("drop table people_tmp;");

                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
            }
        }


    }
}



package com.example.task35_query;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    final String TAG = "dbLogs";

    String country[] = { "Russia", "Japan", "China", "USA", "Brasil",
            "Germany", "Italy", "France", "Egipt", "Canada" };
    int sickNumber[] = { 1400, 5200, 1200, 4570, 4520, 7557, 7554, 7888, 4254, 4545 };
    String zone[] = { "Red", "Green", "Orange", "Red", "Yellow",
            "Yellow", "Red", "Orange", "Orange", "Yellow" };

    RadioGroup rgSort;
    Button btnFunction, btnSickNumber, btnGroup, btnSort, btnHaving, btnAll;
    EditText etFunction, etSickNumber, etZone;

    SQLiteDatabase db;
    DBHelper dbHelper;

    /** Called when the activity is first created. */

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAll = (Button) findViewById(R.id.btnAll);
        btnAll.setOnClickListener(this);

        btnFunction = (Button) findViewById(R.id.btnFunction);
        btnFunction.setOnClickListener(this);

        btnSickNumber = (Button) findViewById(R.id.btnSickNumber);
        btnSickNumber.setOnClickListener(this);

        btnGroup = (Button) findViewById(R.id.btnGroup);
        btnGroup.setOnClickListener(this);

        btnSort = (Button) findViewById(R.id.btnSort);
        btnSort.setOnClickListener(this);

        btnHaving = (Button) findViewById(R.id.btnHaving);
        btnHaving.setOnClickListener(this);

        etFunction = (EditText) findViewById(R.id.etFunction);
        etSickNumber = (EditText) findViewById(R.id.etSickNumber);
        etZone = (EditText) findViewById(R.id.etZone);

        rgSort = (RadioGroup) findViewById(R.id.rgSort);

        dbHelper = new DBHelper(this);
        // connect to db
        db = dbHelper.getWritableDatabase();

        // check if data exists
        Cursor c = db.query("dbtable", null, null, null, null, null, null);
        if (c.getCount() == 0) {
            ContentValues cv = new ContentValues();
            // fill in the table
            for (int i = 0; i < 10; i++) {
                cv.put("country", country[i]);
                cv.put("sickNumber", sickNumber[i]);
                cv.put("zone", zone[i]);
                Log.d(TAG, "inserted id = " + db.insert("dbtable", null, cv));
            }
        }
        c.close();
        dbHelper.close();
        // click button btnAll
        onClick(btnAll);

    }

    public void onClick(View view) {

        // connect to DB
        db = dbHelper.getWritableDatabase();

        // data from screen
        String function = etFunction.getText().toString();
        String sickNumber = etSickNumber.getText().toString();
        String zone = etZone.getText().toString();

        // variables for query
        String[] qColumns = null;
        String qSelection = null;
        String[] qArgs = null;
        String qGroupBy = null;
        String qHaving = null;
        String qOrderBy = null;

        // cursor
        Cursor cur = null;

        // define clicked button
        switch (view.getId()) {
            case R.id.btnAll:
                Log.d(TAG, "-=Get all data=-");
                cur = db.query("dbtable", null, null, null, null, null, null);
                break;
            case R.id.btnFunction:
                Log.d(TAG, "-=Function= " + function + "=-");
                qColumns = new String[] { function };
                cur = db.query("dbtable", qColumns, null, null, null, null, null);
                break;
            case R.id.btnSickNumber:
                Log.d(TAG, "-=Sick number is more than " + sickNumber + "=-");
                qSelection = "SickNumber > ?";
                qArgs = new String[] { sickNumber };
                cur = db.query("dbtable", null, qSelection, qArgs, null, null,
                        null);
                break;
            case R.id.btnGroup:
                Log.d(TAG, "-=Sick number by zone=-");
                qColumns = new String[] { "zone", "sum(sickNumber) as sickNumber" };
                qGroupBy = "zone";
                cur = db.query("dbtable", qColumns, null, null, qGroupBy, null, null);
                break;
            case R.id.btnHaving:
                Log.d(TAG, "-=Regions with population greater " + sickNumber + "=-");
                qColumns = new String[] { "zone", "sum(sickNumber) as sickNumber" };
                qGroupBy = "zone";
                qHaving = "sum(sickNumber) > " + zone;
                cur = db.query("dbtable", qColumns, null, null, qGroupBy, qHaving, null);
                break;
            // Sort
            case R.id.btnSort:
                // sort by
                switch (rgSort.getCheckedRadioButtonId()) {
                    case R.id.rCountry:
                        Log.d(TAG, "-=Sort by country=-");
                        qOrderBy = "country";
                        break;
                    case R.id.rSickNumber:
                        Log.d(TAG, "-=Sort by sick number=-");
                        qOrderBy = "sickNumber";
                        break;
                    case R.id.rZone:
                        Log.d(TAG, "-=Sort by zone=-");
                        qOrderBy = "zone";
                        break;
                }
                cur = db.query("dbtable", null, null, null, null, null, qOrderBy);
                break;
        }

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
            cur.close();
        } else
            Log.d(TAG, "No data available");

        dbHelper.close();
    }

    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            // superclass constructor
            super(context, "clientDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d(TAG, "onCreate database");
            // create a table with fields
            db.execSQL("create table dbtable ("
                    + "id integer primary key autoincrement,"
                    + "country text,"
                    + "sickNumber integer,"
                    + "zone text)" + ";");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d(TAG, "onUpgrade database");
        }
    }
}

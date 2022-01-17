package com.example.task34_simpledb2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    final String TAG = "dbLogs";

    Button btnSelect, btnAdd, btnDeleteAll, btnUpd, btnDel;;
    EditText etName, etSurname, etEmail, etMobile, etId;

    DBHelper dbHelper;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSelect = (Button) findViewById(R.id.btnSelect);
        btnSelect.setOnClickListener(this);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnDeleteAll = (Button) findViewById(R.id.btnDelete);
        btnDeleteAll.setOnClickListener(this);

        btnUpd = (Button) findViewById(R.id.btnUpd);
        btnUpd.setOnClickListener(this);

        btnDel = (Button) findViewById(R.id.btnDel);
        btnDel.setOnClickListener(this);

        etName = (EditText) findViewById(R.id.etName);
        etSurname =  (EditText) findViewById(R.id.etSurname);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etMobile = (EditText) findViewById(R.id.etMobile);
        etId = (EditText) findViewById(R.id.etId);

        //create an object for creating and managing database versions
        dbHelper = new DBHelper(this);
    }


    @Override
    public void onClick(View view) {

        //create an object for data
        ContentValues cv = new ContentValues();

        // get data from input fields
        String name = etName.getText().toString();
        String surname = etSurname.getText().toString();
        String email = etEmail.getText().toString();
        String mobile = etMobile.getText().toString();
        String id = etId.getText().toString();

        // connect to DB
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        switch (view.getId()) {
            case R.id.btnAdd:
                Log.d(TAG, "-=Insert into dbtable=-");
                //prepare the data for insertion in the form: column name - value

                cv.put("name", name);
                cv.put("surname", surname);
                cv.put("email", email);
                cv.put("mobile", mobile);
                // insert row and get its ID
                long rowID = db.insert("dbtable", null, cv);
                //Log.d(TAG, "row inserted, ID = " + rowID);
                Toast.makeText(this, "last inserted id="+rowID, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSelect:
                Log.d(TAG, "-=Select from dbtable=-");
                //make a request for all data from the table mytable, get Cursor
                Cursor c = db.query("dbtable", null, null, null, null, null, "surname");

                //put the cursor position on the first line of the selection
                //if there are no rows in the selection, return false
                if (c.moveToFirst()) {

                    //determine the column numbers by name
                    int idColIndex = c.getColumnIndex("id");
                    int nameColIndex = c.getColumnIndex("name");
                    int surnameColIndex = c.getColumnIndex("surname");
                    int emailColIndex = c.getColumnIndex("email");
                    int mobileColIndex = c.getColumnIndex("mobile");

                    do {
                        //get values by column numbers and write everything to the log
                        Log.d(TAG,
                                "ID = " + c.getInt(idColIndex) +
                                        ", name = " + c.getString(nameColIndex) +
                                        ", surname = " + c.getString(surnameColIndex) +
                                        ", email = " + c.getString(emailColIndex) +
                                        ", mobile = " + c.getString(mobileColIndex));
                        // move to next row
                        // if there is now next row (current row is the last ), return false and exit from the loop
                    } while (c.moveToNext());
                } else
                    //Log.d(TAG, "0 rows");
                    Toast.makeText(this, "no data available to select", Toast.LENGTH_SHORT).show();
                c.close();
                break;
            case R.id.btnDelete:
                Log.d(TAG, "-=Delete from dbtable=-");
                // delete all data
                int delCount = db.delete("dbtable", null, null);
                //Log.d(TAG, "deleted rows = " + delCount);
                Toast.makeText(this, "deleted rows = " + delCount, Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnUpd:
                if (id.equalsIgnoreCase("")) {
                    break;
                }
                Log.d(TAG, "-=Update dbtable... where id=...=-");
                // prepare data for update
                cv.put("name", name);
                cv.put("surname", surname);
                cv.put("email", email);
                cv.put("mobile", mobile);
                // update by id
                int updRowsCount = db.update("dbtable", cv, "id = ?",
                        new String[] { id });
                //Log.d(TAG, "updated rows count = " + updRowsCount);
                Toast.makeText(this, "updated rows = " + updRowsCount, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnDel:
                if (id.equalsIgnoreCase("")) {
                    break;
                }
                Log.d(TAG, "-=Delete from dbtable... where id=...=-");
                // delete by id
                int delRowsCount = db.delete("dbtable", "id = " + id, null);
                //Log.d(TAG, "deleted rows count = " + delCount);
                Toast.makeText(this, "deleted rows = " + delRowsCount, Toast.LENGTH_SHORT).show();
                break;
        }

        // close DB connection
        dbHelper.close();
    }


    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            // superclass constructor
            super(context, "clientDBDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d(TAG, "onCreate database");
            // create a table with fields
            db.execSQL("create table dbtable ("
                    + "id integer primary key autoincrement,"
                    + "name text,"
                    + "surname text,"
                    + "email text,"
                    + "mobile text" + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d(TAG, "onUpgrade database");
        }
    }
}
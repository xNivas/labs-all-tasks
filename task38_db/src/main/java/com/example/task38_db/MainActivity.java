package com.example.task38_db;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    final String TAG = "dbLogs";

    Button buttonSortujId, buttonSortujImie, buttonSortujNazwisko;
    Button buttonDodaj, buttonZmodyfikuj, buttonUsunId, buttonWyswietl, buttonUsunWszystko;
    EditText editTextId, editTextImie, editTextNazwisko, editTextMiasto, editTextMail;
    RadioGroup rgPlec;
    RadioButton radioButtonPlec;
    TextView textViewOutput;

    DBHelper dbHelper;

    public void selectSortowanie(String metodaSortowania, SQLiteDatabase db) {
        textViewOutput.setText("");

        Cursor c = db.query("dbtable", null, null, null, null, null, metodaSortowania);
        if (c.moveToFirst()) {
            int idColIndex = c.getColumnIndex("id");
            int imieColIndex = c.getColumnIndex("imie");
            int nazwiskoColIndex = c.getColumnIndex("nazwisko");
            int miastoColIndex = c.getColumnIndex("miasto");
            int mailColIndex = c.getColumnIndex("mail");
            int plecColIndex = c.getColumnIndex("plec");
            do {
                String nowaLinia = "ID = " + c.getInt(idColIndex) +
                        ", imie = " + c.getString(imieColIndex) +
                        ", nazwisko = " + c.getString(nazwiskoColIndex) +
                        ", miasto = " + c.getString(miastoColIndex) +
                        ", mail = " + c.getString(mailColIndex) +
                        ", plec = " + c.getString(plecColIndex);

//                if(textViewOutput.getText() == "") {
//                    textViewOutput.setText(nowaLinia);
//                }
//                else {
                    textViewOutput.append(nowaLinia + "\n\n");
//                }

                Log.d(TAG, nowaLinia);
            } while (c.moveToNext());
        } else
            Toast.makeText(this, "no data available to select", Toast.LENGTH_SHORT).show();
        c.close();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgPlec = (RadioGroup) findViewById(R.id.rgPlec);

        buttonSortujId = findViewById(R.id.buttonSortujId);
        buttonSortujId.setOnClickListener(this);
        buttonSortujImie = findViewById(R.id.buttonSortujImie);
        buttonSortujImie.setOnClickListener(this);
        buttonSortujNazwisko = findViewById(R.id.buttonSortujNazwisko);
        buttonSortujNazwisko.setOnClickListener(this);

        editTextId = findViewById(R.id.editTextId);
        editTextImie = findViewById(R.id.editTextImie);
        editTextNazwisko = findViewById(R.id.editTextNazwisko);
        editTextMiasto = findViewById(R.id.editTextMiasto);
        editTextMail = findViewById(R.id.editTextMail);

        buttonDodaj = findViewById(R.id.button);
        buttonDodaj.setOnClickListener(this);
        buttonZmodyfikuj = findViewById(R.id.button2);
        buttonZmodyfikuj.setOnClickListener(this);
        buttonUsunId = findViewById(R.id.button3);
        buttonUsunId.setOnClickListener(this);
        buttonWyswietl = findViewById(R.id.button4);
        buttonWyswietl.setOnClickListener(this);
        buttonUsunWszystko = findViewById(R.id.button5);
        buttonUsunWszystko.setOnClickListener(this);

        textViewOutput = findViewById(R.id.textViewOutput);

        dbHelper = new DBHelper(this);
    }


    @Override
    public void onClick(View view) {

        ContentValues cv = new ContentValues();

        String id = editTextId.getText().toString();
        String imie = editTextImie.getText().toString();
        String nazwisko = editTextNazwisko.getText().toString();
        String miasto = editTextMiasto.getText().toString();
        String mail = editTextMail.getText().toString();
        String plec = "";


        Log.d(TAG,
                "--- --- --- pobrano id imie nazwisko etc --- --- --- \n nazwisko: "
                        + nazwisko);

        int zaznaczonaPlec = rgPlec.getCheckedRadioButtonId();
        radioButtonPlec = (RadioButton) findViewById(zaznaczonaPlec);
        int indexPlec = rgPlec.indexOfChild(radioButtonPlec);

        switch (rgPlec.indexOfChild(radioButtonPlec)) {
            case 0:
                plec = "k";
                Log.d(TAG, "wartosc parametru plec ustawiono na k");
                break;
            case 1:
                plec = "m";
                Log.d(TAG, "wartosc parametru plec ustawiono na m");
                break;
        }

        Log.d(TAG,
                "--- --- --- pobrano radiobutton --- --- --- \n indexPlec: "
                        + String.valueOf(indexPlec));

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        switch(view.getId()) {
            case R.id.button:
                Log.d(TAG, "--- --- ---Dodanie rekordu do tabeli--- --- ---");

                cv.put("imie", imie);
                cv.put("nazwisko", nazwisko);
                cv.put("miasto", miasto);
                cv.put("mail", mail);
                cv.put("plec", plec);

                long rowID = db.insert("dbtable", null, cv);
                Toast.makeText(this, "last inserted id="+rowID, Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                if (id.equalsIgnoreCase("")) {
                    break;
                }
                Log.d(TAG, "--- --- ---Modyfikacja rekordu z tabeli--- --- ---");

                cv.put("imie", imie);
                cv.put("nazwisko", nazwisko);
                cv.put("miasto", miasto);
                cv.put("mail", mail);
                cv.put("plec", plec);

                int updRowsCount = db.update("dbtable", cv, "id = ?",
                        new String[] { id });
                //Log.d(TAG, "updated rows count = " + updRowsCount);
                Toast.makeText(this, "updated rows = " + updRowsCount, Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                if (id.equalsIgnoreCase("")) {
                    break;
                }
                Log.d(TAG, "--- --- ---Usuwanie rekordu z tabeli po ID--- --- ---");

                int delRowsCount = db.delete("dbtable", "id = " + id, null);

                Toast.makeText(this, "deleted rows = " + delRowsCount, Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4:
                Log.d(TAG, "--- --- ---Kwerenda wybierająca wszystkie rekordy z tabeli--- --- ---");
                selectSortowanie("nazwisko", db);
                break;
            case R.id.button5:
                Log.d(TAG, "--- -- --Usuwanie wszystkich rekordów z tabeli--- --- ---");

                int delCount = db.delete("dbtable", null, null);

                Toast.makeText(this, "deleted rows = " + delCount, Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonSortujId:
                Log.d(TAG, "--- -- --Sortowanie rekordów po Id--- --- ---");
                selectSortowanie("id", db);
                break;
            case R.id.buttonSortujImie:
                Log.d(TAG, "--- -- --Sortowanie rekordów po imieniu--- --- ---");
                selectSortowanie("imie", db);
                break;
            case R.id.buttonSortujNazwisko:
                Log.d(TAG, "--- -- --Sortowanie rekordów po nazwisku--- --- ---");
                selectSortowanie("nazwisko", db);
                break;



        }


        dbHelper.close();
    }

    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, "clientDBDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d(TAG, "onCreate database");

            db.execSQL("create table dbtable ("
                    + "id integer primary key autoincrement,"
                    + "imie text,"
                    + "nazwisko text,"
                    + "miasto text,"
                    + "mail text,"
                    + "plec text" + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d(TAG, "onUpgrade database");
        }
    }
}
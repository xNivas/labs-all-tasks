package com.example.task33_restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup rgPrzystawki, rgZupy, rgDodatki;
    RadioButton radioButtonPrzystawki, radioButtonZupy, radioButtonDodatki;
    Button btnZapisz, btnZaladuj, btnWyczysc;

    SharedPreferences prefValue;

    final String WYBRANE_PRZYSTAWKI = "wybrane_przystawki";
    final String WYBRANE_ZUPY = "wybrane_zupy";
    final String WYBRANE_DODATKI = "wybrane_dodatki";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgPrzystawki = (RadioGroup) findViewById(R.id.rgPrzystawki);
        rgZupy = (RadioGroup) findViewById(R.id.rgZupy);
        rgDodatki = (RadioGroup) findViewById(R.id.rgDodatki) ;

        btnZapisz = (Button) findViewById(R.id.btnZapisz);
        btnZapisz.setOnClickListener(this);

        btnZaladuj = (Button) findViewById(R.id.btnZaladuj);
        btnZaladuj.setOnClickListener(this);

        btnWyczysc = (Button) findViewById(R.id.btnWyczysc);
        btnWyczysc.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnZapisz:
                zapiszListe();
                break;
            case R.id.btnZaladuj:
                zaladujListe();
                break;
            case R.id.btnWyczysc:
                usunListe();
                break;
        }
    }

    public void zapiszListe() {
        int selectedPrzystawki = rgPrzystawki.getCheckedRadioButtonId();
        radioButtonPrzystawki = (RadioButton) findViewById(selectedPrzystawki);
        int indexPrzystawki = rgPrzystawki.indexOfChild(radioButtonPrzystawki);

        int selectedZupy =  rgZupy.getCheckedRadioButtonId();
        radioButtonZupy = (RadioButton) findViewById(selectedZupy);
        int indexZupy = rgZupy.indexOfChild(radioButtonZupy);

        int selectedDodatki =  rgDodatki.getCheckedRadioButtonId();
        radioButtonDodatki = (RadioButton) findViewById(selectedDodatki);
        int indexDodatki = rgDodatki.indexOfChild(radioButtonDodatki);

        prefValue = getPreferences(MODE_PRIVATE);
        Editor ed = prefValue.edit();

        ed.putString(WYBRANE_PRZYSTAWKI, String.valueOf(indexPrzystawki));
        ed.putString(WYBRANE_ZUPY, String.valueOf(indexZupy));
        ed.putString(WYBRANE_DODATKI, String.valueOf(indexDodatki));

        rgPrzystawki.clearCheck();
        rgZupy.clearCheck();
        rgDodatki.clearCheck();

        ed.commit();
        Toast.makeText(this, "Zapisano liste", Toast.LENGTH_SHORT).show();

    }

    public void zaladujListe() {

        try {
            prefValue = getPreferences(MODE_PRIVATE);

            String wybranaPrzystawka = prefValue.getString(WYBRANE_PRZYSTAWKI, "");
            ((RadioButton)rgPrzystawki.getChildAt(Integer.parseInt(wybranaPrzystawka))).setChecked(true);

            Toast.makeText(this, "Pomyślnie wczytano wybraną wcześniej przystawkę.", Toast.LENGTH_SHORT).show();
        }
        catch (Exception exception) {
            Toast.makeText(this, "Zapis nie zawierał wybranej opcji z menu przystawek", Toast.LENGTH_SHORT).show();
        }

        try {
            prefValue = getPreferences(MODE_PRIVATE);

            String wybranaZupa = prefValue.getString(WYBRANE_ZUPY, "");
            ((RadioButton)rgZupy.getChildAt(Integer.parseInt(wybranaZupa))).setChecked(true);

            Toast.makeText(this, "Pomyślnie wczytano wybraną wcześniej zupę.", Toast.LENGTH_SHORT).show();
        }
        catch (Exception exception) {
            Toast.makeText(this, "Zapis nie zawierał wybranej opcji z menu zup", Toast.LENGTH_SHORT).show();
        }

        try {
            prefValue = getPreferences(MODE_PRIVATE);

            String wybranyDodatek = prefValue.getString(WYBRANE_DODATKI, "");
            ((RadioButton)rgDodatki.getChildAt(Integer.parseInt(wybranyDodatek))).setChecked(true);

            Toast.makeText(this, "Pomyślnie wczytano wybrany wcześniej dodatek.", Toast.LENGTH_SHORT).show();
        }
        catch (Exception exception) {
            Toast.makeText(this, "Zapis nie zawierał wybranej opcji z menu dodatków", Toast.LENGTH_SHORT).show();
        }

    }

    public void usunListe() {
        rgPrzystawki.clearCheck();
        rgZupy.clearCheck();
        rgDodatki.clearCheck();

        int selectedPrzystawki = rgPrzystawki.getCheckedRadioButtonId();
        radioButtonPrzystawki = (RadioButton) findViewById(selectedPrzystawki);
        int indexPrzystawki = rgPrzystawki.indexOfChild(radioButtonPrzystawki);

        int selectedZupy =  rgZupy.getCheckedRadioButtonId();
        radioButtonZupy = (RadioButton) findViewById(selectedZupy);
        int indexZupy = rgZupy.indexOfChild(radioButtonZupy);

        int selectedDodatki =  rgDodatki.getCheckedRadioButtonId();
        radioButtonDodatki = (RadioButton) findViewById(selectedDodatki);
        int indexDodatki = rgDodatki.indexOfChild(radioButtonDodatki);

        prefValue = getPreferences(MODE_PRIVATE);
        Editor ed = prefValue.edit();

        ed.putString(WYBRANE_PRZYSTAWKI, String.valueOf(indexPrzystawki));
        ed.putString(WYBRANE_ZUPY, String.valueOf(indexZupy));
        ed.putString(WYBRANE_DODATKI, String.valueOf(indexDodatki));

        rgPrzystawki.clearCheck();
        rgZupy.clearCheck();
        rgDodatki.clearCheck();

        ed.commit();
        Toast.makeText(this, "Usunięto liste", Toast.LENGTH_SHORT).show();
    }


}
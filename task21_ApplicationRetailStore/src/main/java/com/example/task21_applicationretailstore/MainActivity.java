package com.example.task21_applicationretailstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    Do tego zadania można użyć własną aplikację z zadania 15 laboratoriów 2 lub utworzyć aplikację, która zawiera:
//    •	zagnieżdżone menu,
//    •	obrazki,
//    •	pola tekstowe,
//    •	wyskakujące komunikaty (polecenie Toast).
//    6.	Utworzyć zagnieżdżone menu (można rozbudować menu z laboratoriów 2).
//    7.	Po kliknięciu na punkt menu ma pojawić się odpowiednia informacja nad/pod każdym obrazkiem. Na przykład, jeśli mieliśmy sklep, wybraliśmy z menu kategorię „warzywa”, w kolejnych opcjach menu mamy „masę opakowania”, „cenę”, „producenta”, „kraj pochodzenia”, to przy wyborze np. menu „cena”, pojawia się cena w odpowiednich polach tekstowych nad/pod każdym obrazkiem.
//    8.	Dodać wyskakujący komunikat po kliknięciu na obrazek, np. „Promocja! Cena dziś ...”, „Z kartą stałego klienta cena ...”.
//    Temat aplikacji może być dowolny.

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void onOptionsClick(MenuItem item) {
        TextView infoTextView = (TextView) findViewById(R.id.message);
        infoTextView.setText("You selected " + item.getTitle() + ", id: " + item.getItemId());
        String tresc = "Wybrano " + item.getTitle() + " z kategorii " + item.getMenuInfo();

        ImageView image = (ImageView) findViewById(R.id.image);
            switch (item.getItemId()) {
                case 2131231197:
                    image.setImageResource(R.drawable.jablko);
                    Toast.makeText(getApplicationContext()
                            , tresc,
                            Toast.LENGTH_LONG).show();
                    break;
                case 2131231194:
                    image.setImageResource(R.drawable.banany);
                    break;
                case 2131231198:
                    image.setImageResource(R.drawable.truskawki);
                    break;
                case R.drawable.brokul:
                    image.setImageResource(R.drawable.brokul);
                    break;
                case R.drawable.czosnek:
                    image.setImageResource(R.drawable.czosnek);
                    break;
                case R.drawable.ziemniaki:
                    image.setImageResource(R.drawable.ziemniaki);
                    break;
            }

//            if (item.getTitle() == "Banany") {
//                image.setImageResource(R.drawable.banany);
//            }



    }






}
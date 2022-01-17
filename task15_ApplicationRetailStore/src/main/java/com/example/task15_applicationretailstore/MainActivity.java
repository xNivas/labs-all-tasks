package com.example.task15_applicationretailstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    CheckBox chb;
    TableLayout tbL;
    TableRow tbR1, tbR2;
    ImageView img1, img2, img3, img4, img5, img6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView);
        chb = (CheckBox) findViewById(R.id.chbExtMenu);

//        tbL = (TableLayout) findViewById(R.id.tbL);
//        tbR1 = (TableRow) findViewById(R.id.tbR1);
//        tbR2 = (TableRow) findViewById(R.id.tbR2);

        img1= (ImageView) findViewById(R.id.image1);
        img2= (ImageView) findViewById(R.id.image2);
        img3= (ImageView) findViewById(R.id.image3);
        img4= (ImageView) findViewById(R.id.image4);
        img5= (ImageView) findViewById(R.id.image5);
        img6= (ImageView) findViewById(R.id.image6);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"Fruits");
        menu.add(0,2,0,"Vegetables");
        menu.add(0,3,0,"Bakery");

        menu.add(1,4,0,"Drinks");
        menu.add(1,5,0,"Cakes");
        menu.add(1,6,0,"Chocolate");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.setGroupVisible(1, chb.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        String selectedCategory = "Selected category: " + String.valueOf(item.getTitle());
        tv.setText(selectedCategory);

        List<ImageView> listaObjektowImg = new ArrayList<>();
        listaObjektowImg.add(img1);
        listaObjektowImg.add(img2);
        listaObjektowImg.add(img3);
        listaObjektowImg.add(img4);
        listaObjektowImg.add(img5);
        listaObjektowImg.add(img6);

//        switch (item.getItemId()) {
//            case 1:
//                for (ImageView x: listaObjektowImg) {
//                    x.setVisibility(View.VISIBLE);
//                }
//
//                img1.setImageResource(R.drawable.jablko);
//                img2.setImageResource(R.drawable.awokado);
//                img3.setImageResource(R.drawable.banany);
//                img4.setImageResource(R.drawable.cytryna);
//                img5.setImageResource(R.drawable.winogrono);
//                img6.setImageResource(R.drawable.truskawki);
//                break;
//            case 2:
//                for (ImageView x: listaObjektowImg) {
//                    x.setVisibility(View.VISIBLE);
//                }
//
//                img1.setImageResource(R.drawable.brokul);
//                img2.setImageResource(R.drawable.pomidor);
//                img3.setImageResource(R.drawable.ogorek);
//                img4.setImageResource(R.drawable.ziemniaki);
//                img5.setImageResource(R.drawable.kapusta);
//                img6.setImageResource(R.drawable.czosnek);
//                break;
//            case 3:
//                for (ImageView x: listaObjektowImg) {
//                    x.setVisibility(View.INVISIBLE);
//                }
//                break;
//
//
//        }

        if (item.getItemId() == 1) {
            img1.setImageResource(R.drawable.jablko);
            img2.setImageResource(R.drawable.awokado);
            img3.setImageResource(R.drawable.banany);
            img4.setImageResource(R.drawable.cytryna);
            img5.setImageResource(R.drawable.winogrono);
            img6.setImageResource(R.drawable.truskawki);
        }
        else if (item.getItemId() == 2) {
            img1.setImageResource(R.drawable.brokul);
            img2.setImageResource(R.drawable.pomidor);
            img3.setImageResource(R.drawable.ogorek);
            img4.setImageResource(R.drawable.ziemniaki);
            img5.setImageResource(R.drawable.kapusta);
            img6.setImageResource(R.drawable.czosnek);
        }
        else if (item.getItemId() == 3) {
            img1.setImageResource(R.drawable.chleb);
            img2.setImageResource(R.drawable.chleb2);
            img3.setImageResource(R.drawable.chleb3);
            img4.setImageResource(R.drawable.chleb4);
            img5.setImageResource(R.drawable.chleb5);
            img6.setImageResource(R.drawable.chleb6);
        }
        else if (item.getItemId() == 4) {
            img1.setImageResource(R.drawable.sok);
            img2.setImageResource(R.drawable.sok);
            img3.setImageResource(R.drawable.sok);
            img4.setImageResource(R.drawable.sok);
            img5.setImageResource(R.drawable.sok);
            img6.setImageResource(R.drawable.sok);
        }
        else if (item.getItemId() == 5) {
            img1.setImageResource(R.drawable.kremowka);
            img2.setImageResource(R.drawable.kremowka2);
            img3.setImageResource(R.drawable.kremowka3);
            img4.setImageResource(R.drawable.kremowka4);
            img5.setImageResource(R.drawable.kremowka5);
            img6.setImageResource(R.drawable.kremowka6);
        }
        else if (item.getItemId() == 6) {
            img1.setImageResource(R.drawable.czekolada);
            img2.setImageResource(R.drawable.czekolada2);
            img3.setImageResource(R.drawable.czekolada3);
            img4.setImageResource(R.drawable.czekolada4);
            img5.setImageResource(R.drawable.czekolada5);
            img6.setImageResource(R.drawable.czekolada6);
        }
        else {
            for (ImageView i: listaObjektowImg) {
                i.setImageResource(0);
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
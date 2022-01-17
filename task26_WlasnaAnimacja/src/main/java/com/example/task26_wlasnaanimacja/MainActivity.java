package com.example.task26_wlasnaanimacja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //zmienna pomocnicza
    int numerSlajdu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tytulSlajdu = findViewById(R.id.tytulSlajdu);
        final ImageView obrazek = findViewById(R.id.obrazek);
        final TextView trescSlajdu = findViewById(R.id.trescSlajdu);

        SlideAnimation animation = new SlideAnimation();

        Button buttonNastepny = findViewById(R.id.buttonNastepny);
        buttonNastepny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (numerSlajdu) {
                    case 1:

                        numerSlajdu = 2;
                        tytulSlajdu.setText(R.string.tytulSlajdu2);
                        obrazek.setImageResource(R.drawable.banany);
                        trescSlajdu.setText(R.string.trescSlajdu2);
                        animation.runAnimation(tytulSlajdu, trescSlajdu, obrazek);

                        break;
                    case 2:

                        numerSlajdu = 3;
                        tytulSlajdu.setText(R.string.tytulSlajdu3);
                        obrazek.setImageResource(R.drawable.jablko);
                        trescSlajdu.setText(R.string.trescSlajdu3);
                        animation.runAnimation(tytulSlajdu, trescSlajdu, obrazek);

                        break;
                    case 3:

                        Toast.makeText(getApplicationContext(), "nie ma nastepnego slajdu",Toast.LENGTH_LONG).show();

                        break;
                    }

//                    SlideAnimation animation = new SlideAnimation();
//                    animation.runAnimation(tytulSlajdu, trescSlajdu, obrazek);
/*
                    Animation animationTitle =
                            AnimationUtils.loadAnimation(tytulSlajdu.getContext(), R.anim.slide_down);
                    tytulSlajdu.startAnimation(animationTitle);

                    Animation animationContent =
                            AnimationUtils.loadAnimation(trescSlajdu.getContext(), R.anim.scaling);
                    trescSlajdu.startAnimation(animationContent);

                    Animation animationImage =
                            AnimationUtils.loadAnimation(obrazek.getContext(), R.anim.fade_in);
                    obrazek.startAnimation(animationImage);
 */

                }
        });


        Button buttonPoprzedni = findViewById(R.id.buttonPoprzedni);
        buttonPoprzedni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (numerSlajdu) {
                    case 1:

                        Toast.makeText(getApplicationContext(), "nie ma poprzedniego slajdu",Toast.LENGTH_LONG).show();


                        break;
                    case 2:

                        numerSlajdu = 1;
                        tytulSlajdu.setText(R.string.tytulSlajdu1);
                        obrazek.setImageResource(R.drawable.truskawki);
                        trescSlajdu.setText(R.string.trescSlajdu1);
                        animation.runAnimation(tytulSlajdu, trescSlajdu, obrazek);

                        break;
                    case 3:

                        numerSlajdu = 2;
                        tytulSlajdu.setText(R.string.tytulSlajdu2);
                        obrazek.setImageResource(R.drawable.banany);
                        trescSlajdu.setText(R.string.trescSlajdu2);
                        animation.runAnimation(tytulSlajdu, trescSlajdu, obrazek);

                        break;
                }

            }
        });

        Button buttonPoczatek = findViewById(R.id.buttonPoczatek);
        buttonPoczatek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numerSlajdu == 1) {

                }
                else {
                    numerSlajdu = 1;
                    tytulSlajdu.setText(R.string.tytulSlajdu1);
                    obrazek.setImageResource(R.drawable.truskawki);
                    trescSlajdu.setText(R.string.trescSlajdu1);
                    animation.runAnimation(tytulSlajdu, trescSlajdu, obrazek);
                }

            }
        });

    }
}




//mainactivity
//final int menu_slide_down_id = 9;
//TextView tv;
//
//oncreate
//tv = (TextView) findViewById(R.id.tv);
//
//
//R.id.tv


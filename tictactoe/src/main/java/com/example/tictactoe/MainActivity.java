package com.example.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //metoda pomocnicza
    public void printTablica() {
        System.out.println("\r\r" +  "1: " + tablica[0][0] + " 2: " + tablica[0][1] + " 3: " + tablica[0][2] + "\n");
        System.out.println("4: " + tablica[1][0] + " 5: " + tablica[1][1] + " 6: " + tablica[1][2] + "\n");
        System.out.println("7: " + tablica[2][0] + " 8: " + tablica[2][1] + " 9: " + tablica[2][2] + "\n");
    }

    void spijSekunde() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Toast.makeText(getApplicationContext(), "Cos sie spierdoliło po drodze",
                    Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void restartCounter() {
        String wiadomosc;
        spijSekunde();
        spijSekunde();
        for (int i = 3; i > 0; i = i - 1){
            wiadomosc = "Restart za: " + i + "...";
            Toast.makeText(getApplicationContext(), wiadomosc,
                    Toast.LENGTH_SHORT).show();
            spijSekunde();
        }
        restart();
    }

    public String sprawdzWynik() {
        //sprawdzenie w poziomie
        if (tablica[0][0] == tablica[0][1] && tablica[0][0] == tablica[0][2]) {
            if (tablica[0][0] == "O") {
                System.out.println("kolko wygralo");
                Toast.makeText(getApplicationContext(),
                        "Koniec gry! Kółko zwycięża.",
                        Toast.LENGTH_SHORT).show();
                //restartCounter();
            }
            else if (tablica[0][0] == "X") {
                System.out.println("krzyzyk wygral");
                Toast.makeText(getApplicationContext(),
                        "Koniec gry! Krzyżyk zwycięża.",
                        Toast.LENGTH_SHORT).show();
                //restartCounter();
            }
            else {
                System.out.println();
            }
        }

        if (tablica[1][0] == tablica[1][1] && tablica[1][0] == tablica[1][2]) {
            if (tablica[1][0] == "O") {
                System.out.println("kolko wygralo");
                Toast.makeText(getApplicationContext(),
                        "Koniec gry! Kółko zwycięża.",
                        Toast.LENGTH_SHORT).show();
                //restartCounter();
            }
            else if (tablica[1][0] == "X") {
                System.out.println("krzyzyk wygral");
                Toast.makeText(getApplicationContext(),
                        "Koniec gry! Krzyżyk zwycięża.",
                        Toast.LENGTH_SHORT).show();
                //restartCounter();
            }
            else {
                System.out.println();
            }
        }

        if (tablica[2][0] == tablica[2][1] && tablica[2][0] == tablica[2][2]) {
            if (tablica[2][0] == "O") {
                System.out.println("kolko wygralo");
                Toast.makeText(getApplicationContext(),
                        "Koniec gry! Kółko zwycięża.",
                        Toast.LENGTH_SHORT).show();
                //restartCounter();
            }
            else if (tablica[2][0] == "X") {
                System.out.println("krzyzyk wygral");
                Toast.makeText(getApplicationContext(),
                        "Koniec gry! Krzyżyk zwycięża.",
                        Toast.LENGTH_SHORT).show();
                //restartCounter();
            }
            else {
                System.out.println();
            }
        }

        //sprawdzenie w pionie
        if (tablica[0][0] == tablica[1][0] && tablica[0][0] == tablica[2][0]) {
            if (tablica[0][0] == "O") {
                System.out.println("kolko wygralo");
                Toast.makeText(getApplicationContext(),
                        "Koniec gry! Kółko zwycięża.",
                        Toast.LENGTH_SHORT).show();
                //restartCounter();
            }
            else if (tablica[0][0] == "X") {
                System.out.println("krzyzyk wygral");
                Toast.makeText(getApplicationContext(),
                        "Koniec gry! Krzyżyk zwycięża.",
                        Toast.LENGTH_SHORT).show();
                //restartCounter();
            }
            else {
                System.out.println();
            }
        }
        if (tablica[0][1] == tablica[1][1] && tablica[0][1] == tablica[2][1]) {
            if (tablica[0][1] == "O") {
                System.out.println("kolko wygralo");
                Toast.makeText(getApplicationContext(),
                        "Koniec gry! Kółko zwycięża.",
                        Toast.LENGTH_SHORT).show();
                //restartCounter();
            }
            else if (tablica[0][1] == "X") {
                System.out.println("krzyzyk wygral");
                Toast.makeText(getApplicationContext(),
                        "Koniec gry! Krzyżyk zwycięża.",
                        Toast.LENGTH_SHORT).show();
                //restartCounter();
            }
            else {
                System.out.println();
            }
        }
        if (tablica[0][2] == tablica[1][2] && tablica[0][2] == tablica[2][2]) {
            if (tablica[0][2] == "O") {
                System.out.println("kolko wygralo");
                Toast.makeText(getApplicationContext(),
                        "Koniec gry! Kółko zwycięża.",
                        Toast.LENGTH_SHORT).show();
                //restartCounter();
            }
            else if (tablica[0][2] == "X") {
                System.out.println("krzyzyk wygral");
                Toast.makeText(getApplicationContext(),
                        "Koniec gry! Krzyżyk zwycięża.",
                        Toast.LENGTH_SHORT).show();
                //restartCounter();
            }
            else {
                System.out.println();
            }
        }

        //sprawdzanie na ukos
        if (tablica[0][0] == tablica[1][1] && tablica[0][0] == tablica[2][2]) {
            if (tablica[0][0] == "O") {
                System.out.println("kolko wygralo");
                Toast.makeText(getApplicationContext(),
                        "Koniec gry! Kółko zwycięża.",
                        Toast.LENGTH_SHORT).show();
                //restartCounter();
            }
            else if (tablica[0][0] == "X") {
                System.out.println("krzyzyk wygral");
                Toast.makeText(getApplicationContext(),
                        "Koniec gry! Krzyżyk zwycięża.",
                        Toast.LENGTH_SHORT).show();
                //restartCounter();
            }
            else {
                System.out.println();
            }
        }
        if (tablica[2][0] == tablica[1][1] && tablica[2][0] == tablica[0][2]) {
            if (tablica[2][0] == "O") {
                System.out.println("kolko wygralo");
                Toast.makeText(getApplicationContext(),
                        "Koniec gry! Kółko zwycięża.",
                        Toast.LENGTH_SHORT).show();
                //restartCounter();
            }
            else if (tablica[2][0] == "X") {
                System.out.println("krzyzyk wygral");
                Toast.makeText(getApplicationContext(),
                        "Koniec gry! Krzyżyk zwycięża.",
                        Toast.LENGTH_SHORT).show();
                //restartCounter();
            }
            else {
                System.out.println();
            }
        }

        return "heheszki";
    }

    final int BUTTONS_COLOR_RED = 1;
    final int BUTTONS_COLOR_BLUE = 2;
    final int BUTTONS_COLOR_DKGRAY = 3;
    int colorState = 0; //do sprawdzania warunkow

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9;

    int move;
    String queue;

    String[][] tablica = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};

    public String kolkoKrzyzyk() {
        if (move == 0) {
            queue = "O";
            move = 1;
        }
        else if (move == 1) {
            queue = "X";
            move = 0;
        }
        return queue;
    }

    public void restart() {
        button1.setText(" ");
        button2.setText(" ");
        button3.setText(" ");
        button4.setText(" ");
        button5.setText(" ");
        button6.setText(" ");
        button7.setText(" ");
        button8.setText(" ");
        button9.setText(" ");
        move = 0;

        tablica[0][0] = " ";
        tablica[0][1] = " ";
        tablica[0][2] = " ";

        tablica[1][0] = " ";
        tablica[1][1] = " ";
        tablica[1][2] = " ";

        tablica[2][0] = " ";
        tablica[2][1] = " ";
        tablica[2][2] = " ";

        printTablica();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);


        restart();
//        button1.setText(" ");
//        button2.setText(" ");
//        button3.setText(" ");
//        button4.setText(" ");
//        button5.setText(" ");
//        button6.setText(" ");
//        button7.setText(" ");
//        button8.setText(" ");
//        button9.setText(" ");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //restart();
        switch (item.getItemId()) {
            case R.id.restart:
                restart();
                break;
            case R.id.zmienKolor:
                if (colorState == 0) {
                    colorState = 1;
                    button1.setBackgroundColor(Color.RED);
                    button2.setBackgroundColor(Color.RED);
                    button3.setBackgroundColor(Color.RED);
                    button4.setBackgroundColor(Color.RED);
                    button5.setBackgroundColor(Color.RED);
                    button6.setBackgroundColor(Color.RED);
                    button7.setBackgroundColor(Color.RED);
                    button8.setBackgroundColor(Color.RED);
                    button9.setBackgroundColor(Color.RED);

                }
                else if (colorState == 1) {
                    colorState = 2;
                    button1.setBackgroundColor(Color.DKGRAY);
                    button2.setBackgroundColor(Color.DKGRAY);
                    button3.setBackgroundColor(Color.DKGRAY);
                    button4.setBackgroundColor(Color.DKGRAY);
                    button5.setBackgroundColor(Color.DKGRAY);
                    button6.setBackgroundColor(Color.DKGRAY);
                    button7.setBackgroundColor(Color.DKGRAY);
                    button8.setBackgroundColor(Color.DKGRAY);
                    button9.setBackgroundColor(Color.DKGRAY);
                }
                else if (colorState == 2) {
                    colorState = 0;
                    button1.setBackgroundColor(Color.BLUE);
                    button2.setBackgroundColor(Color.BLUE);
                    button3.setBackgroundColor(Color.BLUE);
                    button4.setBackgroundColor(Color.BLUE);
                    button5.setBackgroundColor(Color.BLUE);
                    button6.setBackgroundColor(Color.BLUE);
                    button7.setBackgroundColor(Color.BLUE);
                    button8.setBackgroundColor(Color.BLUE);
                    button9.setBackgroundColor(Color.BLUE);

                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        // define button handler by id
        switch (v.getId()) {
            case R.id.button1:
                if (button1.getText() == " ") {
                    button1.setText(kolkoKrzyzyk());
                    tablica[0][0] = (String) button1.getText();
                    printTablica();
                    sprawdzWynik();
                }
                break;
            case R.id.button2:
                if (button2.getText() == " ") {
                    button2.setText(kolkoKrzyzyk());
                    tablica[0][1] = (String) button2.getText();
                    printTablica();
                    sprawdzWynik();
                }
                break;
            case R.id.button3:
                if (button3.getText() == " ") {
                    button3.setText(kolkoKrzyzyk());
                    tablica[0][2] = (String) button3.getText();
                    printTablica();
                    sprawdzWynik();
                }
                break;
            case R.id.button4:
                if (button4.getText() == " ") {
                    button4.setText(kolkoKrzyzyk());
                    tablica[1][0] = (String) button4.getText();
                    printTablica();
                    sprawdzWynik();
                }
                break;
            case R.id.button5:
                if (button5.getText() == " ") {
                    button5.setText(kolkoKrzyzyk());
                    tablica[1][1] = (String) button5.getText();
                    printTablica();
                    sprawdzWynik();
                }
                break;
            case R.id.button6:
                if (button6.getText() == " ") {
                    button6.setText(kolkoKrzyzyk());
                    tablica[1][2] = (String) button6.getText();
                    printTablica();
                    sprawdzWynik();
                }
                break;
            case R.id.button7:
                if (button7.getText() == " ") {
                    button7.setText(kolkoKrzyzyk());
                    tablica[2][0] = (String) button7.getText();
                    printTablica();
                    sprawdzWynik();
                }
                break;
            case R.id.button8:
                if (button8.getText() == " ") {
                    button8.setText(kolkoKrzyzyk());
                    tablica[2][1] = (String) button8.getText();
                    printTablica();
                    sprawdzWynik();
                }
                break;
            case R.id.button9:
                if (button9.getText() == " ") {
                    button9.setText(kolkoKrzyzyk());
                    tablica[2][2] = (String) button9.getText();
                    printTablica();
                    sprawdzWynik();
                }
                break;
        }
    }


}
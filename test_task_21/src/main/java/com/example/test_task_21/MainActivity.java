package com.example.test_task_21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView img1, img2,img3,img4;
    TextView title,tv1, tv2, tv3,tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title=findViewById(R.id.title);
        tv1= findViewById(R.id.tv1);
        tv2= findViewById(R.id.tv2);
        tv3= findViewById(R.id.tv3);
        tv4= findViewById(R.id.tv4);
        img1= findViewById(R.id.img1);
        img2= findViewById(R.id.img2);
        img3= findViewById(R.id.img3);
        img4= findViewById(R.id.img4);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Promocja!");
                builder.setMessage("Dzisiejszy rabat: -20%");
                builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Promocja!");
                builder.setMessage("Z kartą stałego klienta, tylko dziś: 30% zniżki. Promocje nie łączą się.")    ;
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Informacja");
                builder.setMessage("Brak aktywnych promocji dla wybranego produktu.")    ;
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Informacja");
                builder.setMessage("Brak aktywnych promocji dla wybranego produktu.")    ;
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case(R.id.action_chleb):
                tv1.setText("");
                tv2.setText("");
                tv3.setText("");
                tv4.setText("");
                title.setText("Chleb");
                img1.setImageResource(R.drawable.chleb);
                img2.setImageResource(R.drawable.chleb2);
                img3.setImageResource(R.drawable.chleb3);
                img4.setImageResource(R.drawable.chleb4);
                Toast.makeText(MainActivity.this,"Wybrano "+item.getTitle(),Toast.LENGTH_LONG).show();

                return true;
            case(R.id.action_ciasta):
                tv1.setText("");
                tv2.setText("");
                tv3.setText("");
                tv4.setText("");
                title.setText("Ciasta");
                img1.setImageResource(R.drawable.kremowka);
                img2.setImageResource(R.drawable.kremowka2);
                img3.setImageResource(R.drawable.kremowka3);
                img4.setImageResource(R.drawable.kremowka4);
                Toast.makeText(MainActivity.this,"Wybrano "+item.getTitle(),Toast.LENGTH_LONG).show();

                break;
            case(R.id.action_czekolada):
                tv1.setText("");
                tv2.setText("");
                tv3.setText("");
                tv4.setText("");
                title.setText("Czekolada");
                img1.setImageResource(R.drawable.czekolada);
                img2.setImageResource(R.drawable.czekolada2);
                img3.setImageResource(R.drawable.czekolada3);
                img4.setImageResource(R.drawable.czekolada4);
                Toast.makeText(MainActivity.this,"Wybrano "+item.getTitle(),Toast.LENGTH_LONG).show();
                break;

            case(R.id.cena_chleba):
                tv1.setText("4,00 zł");
                tv2.setText("3,50 zł");
                tv3.setText("3,99 zł");
                tv4.setText("3,00 zł");
                break;
            case(R.id.waga_chleba):
                tv1.setText("500g");
                tv2.setText("400g");
                tv3.setText("400g");
                tv4.setText("400g");
                break;
            case(R.id.pochodzenie_chleba):
                tv1.setText("Wrocław");
                tv2.setText("Wrocław");
                tv3.setText("Wrocław");
                tv4.setText("Wrocław");
                break;

            case(R.id.cena_ciasta):
                tv1.setText("5,00 zł");
                tv2.setText("7,00 zł");
                tv3.setText("4,00 zł");
                tv4.setText("6,00 zł");
                break;

            case(R.id.waga_ciasta):
                tv1.setText("150g");
                tv2.setText("180g");
                tv3.setText("200g");
                tv4.setText("150g");
                break;
            case(R.id.pochodzenie_ciasta):
                tv1.setText("Wadowice");
                tv2.setText("Rzym");
                tv3.setText("Bydgoszcz");
                tv4.setText("Lublin");
                break;

            case(R.id.cena_czekolady):
                tv1.setText("4,00 zł");
                tv2.setText("3,99 zł");
                tv3.setText("3,50 ");
                tv4.setText("3,89 zł");
                break;

            case(R.id.waga_czekolady):
                tv1.setText("100g");
                tv2.setText("110g");
                tv3.setText("100g");
                tv4.setText("100g");
                break;
            case(R.id.pochodzenie_czekolady):
                tv1.setText("Włochy");
                tv2.setText("Francja");
                tv3.setText("Holandia");
                tv4.setText("Polska");
                break;

        }


        return super.onOptionsItemSelected(item);
    }

}
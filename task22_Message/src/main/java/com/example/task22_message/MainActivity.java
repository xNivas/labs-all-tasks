package com.example.task22_message;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvWinter = findViewById(R.id.tvWinter);
        final TextView tvSummer = findViewById(R.id.tvSummer);
        final TextView tvSpring = findViewById(R.id.tvSpring);
        final TextView tvAutumn = findViewById(R.id.tvAutumn);

        ImageView imgSpring = findViewById(R.id.imgSpring);
        imgSpring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] messages = {"The sun is shining",
                        "The temperature is +5 degrees",
                        "The weather is good",
                        "The weather is bad",
                        "It's rainy",
                        "It's cold",
                        "It's muddy"};

                shuffleArray(messages); // randomize sequence

                tvWinter.setText(messages[0]);
                tvSummer.setText(messages[1]);
                tvSpring.setText(messages[2]);
                tvAutumn.setText(messages[3]);
            }
        });
    }

    void shuffleArray(String[] ar){
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}


package com.example.task30_readintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        Intent intent = getIntent();
        String action = intent.getAction();
        String str = "";

        switch(action) {
            case "my.android.intent.action.producer":
                str = "Producer is Apple";
                break;
            case "my.android.intent.action.price":
                str = "Price is 1000 PLN";
                break;
        }

        TextView tvDetails = (TextView) findViewById(R.id.tvDetails);
        tvDetails.setText(str);
    }
}


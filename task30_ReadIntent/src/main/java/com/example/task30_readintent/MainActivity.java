package com.example.task30_readintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnIphone = (Button) findViewById(R.id.btnShowIphone);
        Button btnPrice = (Button) findViewById(R.id.btnShowPrice);

        btnIphone.setOnClickListener(this);
        btnPrice.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()) {
            case R.id.btnShowIphone:
                intent = new Intent("my.android.intent.action.producer");
                startActivity(intent);
                break;
            case R.id.btnShowPrice:
                intent = new Intent("my.android.intent.action.price");
                startActivity(intent);
                break;
        }
    }
}

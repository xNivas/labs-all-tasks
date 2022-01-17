package com.example.task29_navigationintent;

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

        Button btnShowIphone = (Button) findViewById(R.id.btnShowIphone);
        Button btnShowPrice = (Button) findViewById(R.id.btnShowPrice);

        btnShowIphone.setOnClickListener(this);
        btnShowPrice.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;

        switch(view.getId()) {
            case R.id.btnShowIphone:
                intent = new Intent("my.android.intent.action.showiphone");
                startActivity(intent);
                break;
            case R.id.btnShowPrice:
                intent = new Intent("my.android.intent.action.showprice");
                startActivity(intent);
                break;
        }
    }
}

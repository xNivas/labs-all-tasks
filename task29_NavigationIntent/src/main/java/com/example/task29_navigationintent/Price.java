package com.example.task29_navigationintent;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Price extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.price);

        SimpleDateFormat sdf = new SimpleDateFormat("hh 'o''clock' a, zzzz");
        String time = sdf.format(new Date(System.currentTimeMillis()));

        TextView tvTime = (TextView) findViewById(R.id.tvTime);
        tvTime.setText(time);
    }
}


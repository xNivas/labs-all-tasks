package com.example.task45_layoutinflaterlist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String TAG = "dbLogs";

    String country[] = {"Russia", "Japan", "China", "USA", "Brazil",
            "Germany", "Italy", "France", "Egypt", "Canada"};
    int sickNumber[] = {1400, 5200, 1200, 4570, 4520, 7557, 7554, 7888, 4254, 4545};
    String zone[] = {"Red", "Green", "Orange", "Red", "Yellow",
            "Yellow", "Red", "Orange", "Orange", "Yellow"};

    int[] colors = new int[2];

    /**
     * Called when the activity is first created.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors[0] = Color.parseColor("#FFC6FFB2");
        colors[1] = Color.parseColor("#FFFBEECD");

        LinearLayout linLayout = (LinearLayout) findViewById(R.id.scrollLayout);
        LayoutInflater ltInflater = getLayoutInflater();

        TextView tvCountryName;
        TextView tvZone;
        TextView tvSickNumber;

        for (int i = 0; i < country.length; i++) {
            Log.d(TAG, "country number = " + i);
            View item = ltInflater.inflate(R.layout.item, linLayout, false);

            tvCountryName = (TextView) item.findViewById(R.id.tvCountry);
            tvCountryName.setText(country[i]);

            tvZone = (TextView) item.findViewById(R.id.tvZone);
            tvZone.setText("Zone: " + zone[i]);

            tvSickNumber = (TextView) item.findViewById(R.id.tvSickNumber);
            tvSickNumber.setText("Sick number: " + String.valueOf(sickNumber[i]));

            item.getLayoutParams().width = LayoutParams.MATCH_PARENT;
            item.setBackgroundColor(colors[i % 2]);
            linLayout.addView(item);
        }
    }
}

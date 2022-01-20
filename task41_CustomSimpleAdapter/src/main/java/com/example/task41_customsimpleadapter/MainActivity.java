package com.example.task41_customsimpleadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView list1;

    // pictures
    final int temp_plus = android.R.drawable.arrow_up_float;
    final int temp_minus = android.R.drawable.arrow_down_float;

    final String attr_text = "text";
    final String attr_value = "value";
    final String attr_image = "image";

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // temperature array
        int[] temp_values = { 10, 8, -3, 2, -5, 2, 0, -7, 4, -1 };
        String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        // pack the data into a structure for the adapter
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(temp_values.length);
        Map<String, Object> m;
        int img = 0;
        int j = 0;
        for (int i = 0; i < temp_values.length; i++) {
            if (j>=weekdays.length){
                j=0;
            }
            m = new HashMap<String, Object>();
            m.put(attr_text, "Day " + (i + 1) + ", "+ weekdays[j]);
            m.put(attr_value,  (temp_values[i] > 0)? "+" + temp_values[i] : temp_values[i]);
            if (temp_values[i] == 0) img = 0; else
                img = (temp_values[i] > 0) ? temp_plus : temp_minus;
            m.put(attr_image, img);
            data.add(m);
            j++;
        }

        String[] read_from = { attr_text, attr_value, attr_image };
        int[] insert_to = { R.id.tvText, R.id.tvValue, R.id.ivImg };

        // create adapter
        TemperatureAdapter sAdapter = new TemperatureAdapter(this, data,
                R.layout.item, read_from, insert_to);

        // define a list and assign an adapter to it
        list1 = (ListView) findViewById(R.id.list1);
        list1.setAdapter(sAdapter);
    }

    class TemperatureAdapter extends SimpleAdapter {

        public TemperatureAdapter(Context context,
                                  List<? extends Map<String, ?>> data, int resource,
                                  String[] from, int[] to) {
            super(context, data, resource, from, to);
        }

        @Override
        public void setViewText(TextView v, String text) {
            super.setViewText(v, text);
            if (v.getId() == R.id.tvValue) {
                int i = Integer.parseInt(text);
                if (i < 0) v.setTextColor(Color.BLUE); else
                if (i > 0) v.setTextColor(Color.RED);
            }
        }

        @Override
        public void setViewImage(ImageView v, int value) {
            super.setViewImage(v, value);
            if (value == temp_minus) v.setBackgroundColor(Color.BLUE); else
            if (value == temp_plus) v.setBackgroundColor(Color.RED);
        }
    }
}

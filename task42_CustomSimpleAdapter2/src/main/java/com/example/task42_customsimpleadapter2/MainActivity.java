package com.example.task42_customsimpleadapter2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;

public class MainActivity extends AppCompatActivity {

    // attribute names for Map
    final String ATTR_NAME_TV = "TextView";
    final String ATTR_NAME_PB = "ProgressBar";
    final String ATTR_NAME_LL = "LinearLayout ";

    ListView lvList;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data array
        int persents[] = { 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};


        // pack the data into adapter structure
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(
                persents.length);
        Map<String, Object> m;
        int j = 0;
        for (int i = 0; i < persents.length; i++) {
            if (j>=weekdays.length){
                j=0;
            }
            m = new HashMap<String, Object>();
            m.put(ATTR_NAME_TV, weekdays[j] + " " + (i+1) + ". Server occupied space: " + persents[i] + "%");
            m.put(ATTR_NAME_PB, persents[i]);
            m.put(ATTR_NAME_LL, persents[i]);
            data.add(m);
            j++;
        }

        // array of attribute names from which data will be read
        String[] from = { ATTR_NAME_TV, ATTR_NAME_PB,
                ATTR_NAME_LL };
        // array of IDs of View-components, in which data will be put in
        int[] to = { R.id.tvInput, R.id.pbInput, R.id.llInput };

        // сreate adapter
        SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.item,
                from, to);
        // set binder for adapter
        sAdapter.setViewBinder(new MyViewBinder());

        // create list and assign it to adapter
        lvList = (ListView) findViewById(R.id.lvList);
        lvList.setAdapter(sAdapter);
    }

    class MyViewBinder implements SimpleAdapter.ViewBinder {

        int blue = getResources().getColor(R.color.Blue);
        int green = getResources().getColor(R.color.Green);
        int yellow = getResources().getColor(R.color.Yellow);
        int red = getResources().getColor(R.color.Red);

        @Override
        public boolean setViewValue(View view, Object data,
                                    String textRepresentation) {
            int i = 0;
            switch (view.getId()) {
                // LinearLayout
                case R.id.llInput:
                    i = ((Integer) data).intValue();
                    if (i < 20) view.setBackgroundColor(blue); else
                    if (i < 50) view.setBackgroundColor(green); else
                    if (i < 80) view.setBackgroundColor(yellow); else
                        view.setBackgroundColor(red);
                    return true;
                // ProgressBar
                case R.id.pbInput:
                    i = ((Integer) data).intValue();
                    ((ProgressBar)view).setProgress(i);
                    return true;
            }
            return false;
        }
    }
}

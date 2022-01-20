package com.example.task48_simpleadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends AppCompatActivity {

    // attribute names for Map
    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_CHECKED = "checked";
    final String ATTRIBUTE_NAME_IMAGE = "image";

    ListView lvSimple;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data arrays
        String[] texts = { "menu_item 1", "menu_item 2", "menu_item 3",
                "menu_item 4", "menu_item 5" };
        boolean[] checked = {  false, true, true, false, false };
        int img = R.drawable.image1;

        //pack the data into a structure understandable for adapter
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(
                texts.length);
        Map<String, Object> m;
        for (int i = 0; i < texts.length; i++) {
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_TEXT, texts[i]);
            m.put(ATTRIBUTE_NAME_CHECKED, checked[i]);
            m.put(ATTRIBUTE_NAME_IMAGE, img);
            data.add(m);
        }

        //array of name attributes from which data will be read
        String[] from = {
                ATTRIBUTE_NAME_TEXT,
                ATTRIBUTE_NAME_CHECKED,
                ATTRIBUTE_NAME_IMAGE
        };
        // array of IDs of View-components, in which data will be inserted
        int[] to = { R.id.tvText, R.id.cbChecked, R.id.ivImg };

        // create adapter
        SimpleAdapter sAdapter =
                new SimpleAdapter
                        (this, data, R.layout.item, from, to);

        // define a list and assign an adapter to it
        lvSimple = (ListView) findViewById(R.id.lvSimple);
        lvSimple.setAdapter(sAdapter);
    }
}

package com.example.task40_simplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String country[] = { "Russia", "Japan", "China", "USA", "Brazil",
            "Germany", "Italy", "France", "Egypt", "Canada" };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find list
        ListView lvMain = (ListView) findViewById(R.id.lvMain);

        // create adapter
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,
                R.layout.statistics_list_item, country);

        // assign adapter to list
        lvMain.setAdapter(adapter);

    }
}

package com.example.task47_simplelistevents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    final String TAG = "dbLogs";
    ListView lvMain;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMain = (ListView) findViewById(R.id.lvMain);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.names, android.R.layout.simple_list_item_1);
        lvMain.setAdapter(adapter);

        lvMain.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Log.d(TAG,
                        "itemClick: position = " + position + ", id = " + id);
            }
        });

        lvMain.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.d(TAG,
                        "itemSelect: position = " + position + ", id = " + id);
            }

            public void onNothingSelected(AdapterView<?> parent) {
                Log.d(TAG, "itemSelect: nothing");
            }
        });

        lvMain.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                 Log.d(TAG, "scrollState = " + scrollState);
            }

            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                Log.d(TAG, "scroll: firstVisibleItem = " + firstVisibleItem
                        + ", visibleItemCount" + visibleItemCount
                        + ", totalItemCount" + totalItemCount);
            }
        });

    }

}

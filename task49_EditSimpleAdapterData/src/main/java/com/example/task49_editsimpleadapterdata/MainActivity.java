package com.example.task49_editsimpleadapterdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends AppCompatActivity {

    // attribute names for Map
    final String ATTR_NAME_TEXT = "TextView";
    final String ATTR_NAME_IMAGE = "ImageView";

    private static final int DELETE_ID = 1;

    ListView lvList;
    SimpleAdapter sAdapter;
    ArrayList<Map<String, Object>> data;
    Map<String, Object> map;
    // data array
    String[] items = {"Apple", "Plum", "Tomato", "Peach", "Apricot", "Banana", "Cabbage"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // pack the data into adapter structure
        data = new ArrayList<Map<String, Object>>();
        for (int i = 1; i <= items.length; i++) {
            map = new HashMap<String, Object>();
            map.put(ATTR_NAME_TEXT, items[i-1] + " "+ i);
            map.put(ATTR_NAME_IMAGE, R.mipmap.ic_launcher);
            data.add(map);
        }

        // array of attribute names from which data will be read
        String[] from = { ATTR_NAME_IMAGE, ATTR_NAME_TEXT };
        // array of IDs of View-components, in which data will be put in
        int[] to = { R.id.ivImage, R.id.tvText };

        // сreate adapter
        sAdapter = new SimpleAdapter(this, data, R.layout.item, from, to);

        // create list and assign it to adapter
        lvList = (ListView) findViewById(R.id.lvList);
        lvList.setAdapter(sAdapter);
        registerForContextMenu(lvList);
    }

    public void onBtnClick(View v) {
        Random rand = new Random();
        int rand_int = rand.nextInt(items.length);

        // create new Map
        map = new HashMap<String, Object>();
        map.put(ATTR_NAME_TEXT, items[rand_int] + " " + (data.size() + 1));
        map.put(ATTR_NAME_IMAGE, R.mipmap.ic_launcher);
        // add it to collection
        data.add(map);
        // notify that data has been changed
        sAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, DELETE_ID, 0, "Delete item");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == DELETE_ID) {
            // get info about list item
            AdapterContextMenuInfo acmi = (AdapterContextMenuInfo) item.getMenuInfo();
            // delete Map from collection, using the position number in the list
            data.remove(acmi.position);
            //  notify that data has been changed
            sAdapter.notifyDataSetChanged();
            return true;
        }
        return super.onContextItemSelected(item);
    }
}

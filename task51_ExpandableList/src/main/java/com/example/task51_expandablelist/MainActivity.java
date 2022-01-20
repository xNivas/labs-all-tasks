package com.example.task51_expandablelist;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import android.app.Activity;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

public class MainActivity extends AppCompatActivity {

    // group names
    String[] groups = new String[] {"Fruits", "Vegetables", "Milk"};

    // fruits (item) names
    String[] listFruits = new String[] {"Apple", "Pea", "Orange", "Plum", "Banana"};
    String[] listVegetables = new String[] {"Onion", "Tomato", "Cabbage", "Carrot"};
    String[] listMilk = new String[] {"Yogurt", "Sour cream" , "Butter", "Milk"};

    // collection for groups
    ArrayList<Map<String, String>> groupData;

    // collection for elements of one group
    ArrayList<Map<String, String>> childDataItem;

    // general collection for item collections
    ArrayList<ArrayList<Map<String, String>>> childData;
    // so there will be  childData = ArrayList<childDataItem>

    // list of groups or element attributes
    Map<String, String> m;

    ExpandableListView elvMain;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int color = Color.parseColor("#FFC6FFB2");

        // fill in the collection of groups from an array with group names
        groupData = new ArrayList<Map<String, String>>();
        for (String group : groups) {
            // fill in the list of attributes for each group
            m = new HashMap<String, String>();
            m.put("groupName", group); // group name
            groupData.add(m);
        }

        // list of group attributes to read
        String groupFrom[] = new String[] {"groupName"};
        // list of view-element IDs, which will contain group attributes
        int groupTo[] = new int[] {android.R.id.text1};


        // create a collection for item collections
        childData = new ArrayList<ArrayList<Map<String, String>>>();

        // create a collection of items for the first group
        childDataItem = new ArrayList<Map<String, String>>();
        // fill in the list of attributes for each element
        for (String item : listFruits) {
            m = new HashMap<String, String>();
            m.put("itemName", item); // item name
            childDataItem.add(m);
        }
        // add to the collection of collections
        childData.add(childDataItem);

        // create a collection of items for the second group
        childDataItem = new ArrayList<Map<String, String>>();
        for (String item : listVegetables) {
            m = new HashMap<String, String>();
            m.put("itemName", item);
            childDataItem.add(m);
        }
        childData.add(childDataItem);

        // create a collection of items for the third group
        childDataItem = new ArrayList<Map<String, String>>();
        for (String item : listMilk) {
            m = new HashMap<String, String>();
            m.put("itemName", item);
            childDataItem.add(m);
        }
        childData.add(childDataItem);

        // list of element attributes to read
        String childFrom[] = new String[] {"itemName"};
        // list of view-element IDs, which will contain element attributes
        int childTo[] = new int[] {android.R.id.text1};

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this,
                groupData,
                android.R.layout.simple_expandable_list_item_1,
                groupFrom,
                groupTo,
                childData,
                android.R.layout.simple_list_item_1,
                childFrom,
                childTo);

        elvMain = (ExpandableListView) findViewById(R.id.elvMain);
        elvMain.setAdapter(adapter);
        elvMain.setBackgroundColor(color);
        elvMain.expandGroup(1);
    }

}

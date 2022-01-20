package com.example.task52_expandablelistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.widget.SimpleExpandableListAdapter;

public class AdapterHelper {
    final String ATTR_GROUP_NAME= "groupName";
    final String ATTR_ITEM_NAME= "itemName";

    // group names
    String[] groups = new String[] {"Fruits", "Vegetables", "Milk"};

    // item names
    String[] listFruits = new String[] {"Apple", "Pea", "Orange", "Plum", "Banana"};
    String[] listVegetables = new String[] {"Onion", "Tomato", "Cabbage", "Carrot"};
    String[] listMilk = new String[] {"Yogurt", "Sour cream" , "Butter", "Milk"};

    // collection for groups
    ArrayList<Map<String, String>> groupData;

    // collection for elements of one group
    ArrayList<Map<String, String>> childDataItem;

    // general collection for item collections
    ArrayList<ArrayList<Map<String, String>>> childData;
    // so there will be childData = ArrayList<childDataItem>

    // list of group and element attributes
    Map<String, String> m;

    Context ctx;

    AdapterHelper(Context _ctx) {
        ctx = _ctx;
    }

    SimpleExpandableListAdapter adapter;


    SimpleExpandableListAdapter getAdapter() {

        // fill in the collection of groups from an array with group names
        groupData = new ArrayList<Map<String, String>>();
        for (String group : groups) {
            // fill in the list of attributes for each group
            m = new HashMap<String, String>();
            m.put(ATTR_GROUP_NAME, group); // group name
            groupData.add(m);
        }

        // list of group attributes to read
        String groupFrom[] = new String[] {ATTR_GROUP_NAME};
        // list of view-element IDs, which will contain group attributes
        int groupTo[] = new int[] {android.R.id.text1};


        // create a collection for item collections
        childData = new ArrayList<ArrayList<Map<String, String>>>();

        // create a collection of items for the first group
        childDataItem = new ArrayList<Map<String, String>>();
        // fill in the list of attributes for each element
        for (String item : listFruits) {
            m = new HashMap<String, String>();
            m.put(ATTR_ITEM_NAME, item); // item name
            childDataItem.add(m);
        }
        // add to the collection of collections
        childData.add(childDataItem);

        // create a collection of items for the second group
        childDataItem = new ArrayList<Map<String, String>>();
        for (String item : listVegetables) {
            m = new HashMap<String, String>();
            m.put(ATTR_ITEM_NAME, item);
            childDataItem.add(m);
        }
        childData.add(childDataItem);

        // create a collection of elements for the third group
        childDataItem = new ArrayList<Map<String, String>>();
        for (String item : listMilk) {
            m = new HashMap<String, String>();
            m.put(ATTR_ITEM_NAME, item);
            childDataItem.add(m);
        }
        childData.add(childDataItem);

        // list of element attributes to read
        String childFrom[] = new String[] {ATTR_ITEM_NAME};
        // list of ID view-elements, which will contain the attributes of the elements
        int childTo[] = new int[] {android.R.id.text1};

        adapter = new SimpleExpandableListAdapter(
                ctx,
                groupData,
                android.R.layout.simple_expandable_list_item_1,
                groupFrom,
                groupTo,
                childData,
                android.R.layout.simple_list_item_1,
                childFrom,
                childTo);

        return adapter;
    }

    String getGroupText(int groupPos) {
        return ((Map<String,String>)(adapter.getGroup(groupPos))).get(ATTR_GROUP_NAME);
    }

    String getChildText(int groupPos, int childPos) {
        return ((Map<String,String>)(adapter.getChild(groupPos, childPos))).get(ATTR_ITEM_NAME);
    }

    String getGroupChildText(int groupPos, int childPos) {
        return getGroupText(groupPos) + " " +  getChildText(groupPos, childPos);
    }
}


package com.example.task52_expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String TAG = "dbLogs";

    AdapterHelper ah;
    ExpandableListView elvMain;
    SimpleExpandableListAdapter adapter;
    TextView tvDetails;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDetails = (TextView) findViewById(R.id.tvDetails);

        // create adapter
        ah = new AdapterHelper(this);
        adapter = ah.getAdapter();

        elvMain = (ExpandableListView) findViewById(R.id.elvMain);
        elvMain.setAdapter(adapter);

        // clicking on an element
        elvMain.setOnChildClickListener(new OnChildClickListener() {
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition,   int childPosition, long id) {
                Log.d(TAG, "onChildClick groupPosition = " + groupPosition +
                        " childPosition = " + childPosition +
                        " id = " + id);
                tvDetails.setText(ah.getGroupChildText(groupPosition, childPosition));
                return false;
            }
        });

        // clicking on a group
        elvMain.setOnGroupClickListener(new OnGroupClickListener() {
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                Log.d(TAG, "onGroupClick groupPosition = " + groupPosition +
                        " id = " + id);
                // block further processing of the event for the group with position 1
                //if (groupPosition == 1) return true;

                return false;
            }
        });

        // group collapse
        elvMain.setOnGroupCollapseListener(new OnGroupCollapseListener() {
            public void onGroupCollapse(int groupPosition) {
                Log.d(TAG, "onGroupCollapse groupPosition = " + groupPosition);
                tvDetails.setText("Expand " + ah.getGroupText(groupPosition));
            }
        });

        // group expand
        elvMain.setOnGroupExpandListener(new OnGroupExpandListener() {
            public void onGroupExpand(int groupPosition) {
                Log.d(TAG, "onGroupExpand groupPosition = " + groupPosition);
                tvDetails.setText("Collapse " + ah.getGroupText(groupPosition));
            }
        });
    }

}

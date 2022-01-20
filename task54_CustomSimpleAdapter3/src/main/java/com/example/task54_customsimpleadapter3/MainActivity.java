package com.example.task54_customsimpleadapter3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.database.Cursor;
import android.widget.ExpandableListView;
import android.widget.SimpleCursorTreeAdapter;

public class MainActivity extends AppCompatActivity {
    ExpandableListView elvMain;
    ClassDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // connect to DB
        db = new ClassDB(this);
        db.open();

        // prepare data for adapter
        Cursor cursor = db.getCategoryData();
        startManagingCursor(cursor);
        // data and View for categories
        String[] groupFrom = { ClassDB.CATEGORY_COLUMN_NAME };
        int[] groupTo = { android.R.id.text1 };
        // data and View for products
        String[] childFrom = { ClassDB.PRODUCT_COLUMN_NAME };
        int[] childTo = { android.R.id.text1 };

        // create adapter and list
        SimpleCursorTreeAdapter sctAdapter = new MyAdapter(this, cursor,
                android.R.layout.simple_expandable_list_item_1, groupFrom,
                groupTo, android.R.layout.simple_list_item_1, childFrom,
                childTo);
        elvMain = (ExpandableListView) findViewById(R.id.elvMain);
        elvMain.setAdapter(sctAdapter);
    }

    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

    class MyAdapter extends SimpleCursorTreeAdapter {

        public MyAdapter(Context context, Cursor cursor, int groupLayout,
                         String[] groupFrom, int[] groupTo, int childLayout,
                         String[] childFrom, int[] childTo) {
            super(context, cursor, groupLayout, groupFrom, groupTo,
                    childLayout, childFrom, childTo);
        }

        protected Cursor getChildrenCursor(Cursor groupCursor) {
            // get cursor on elements on the given group
            int idColumn = groupCursor.getColumnIndex(ClassDB.CATEGORY_COLUMN_ID);
            return db.getProductData(groupCursor.getInt(idColumn));
        }
    }
}

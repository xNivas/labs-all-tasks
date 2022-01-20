package com.example.task53_cursorloader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.os.Bundle;
import java.util.concurrent.TimeUnit;

import android.content.Context;
import android.database.Cursor;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int DELETE_ID = 1;
    ListView lvList;
    ClassDB db;
    SimpleCursorAdapter adapter;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new ClassDB(this);
        db.open();

        // create columns
        String[] from = new String[] { ClassDB.COLUMN_IMG, ClassDB.COLUMN_TXT };
        int[] to = new int[] { R.id.ivImage, R.id.tvText };

        // create adapter and list
        adapter = new SimpleCursorAdapter(this, R.layout.item, null, from, to, 0);
        lvList = (ListView) findViewById(R.id.lvList);
        lvList.setAdapter(adapter);

        // create context menu
        registerForContextMenu(lvList);

        // createloader for reading data
        getSupportLoaderManager().initLoader(0, null, this);
    }

    public void onBtnClick(View view) {
        // add row
        db.addRecord("new item " + (adapter.getCount() + 1), android.R.drawable.star_big_on);
        // create new cursor with data
        getSupportLoaderManager().getLoader(0).forceLoad();
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, DELETE_ID, 0, R.string.delete_item);
    }

    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == DELETE_ID) {
            // get context menu info
            AdapterContextMenuInfo menu_info = (AdapterContextMenuInfo) item
                    .getMenuInfo();
            // gelete record
            db.deleteRecord(menu_info.id);
            // get new cursor with data
            getSupportLoaderManager().getLoader(0).forceLoad();
            return true;
        }
        return super.onContextItemSelected(item);
    }

    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle bndl) {
        return new MyCursorLoader(this, db);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        adapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    static class MyCursorLoader extends CursorLoader {

        ClassDB db;

        public MyCursorLoader(Context context, ClassDB db) {
            super(context);
            this.db = db;
        }

        @Override
        public Cursor loadInBackground() {
            Cursor cursor = db.getAllData();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return cursor;
        }

    }
}

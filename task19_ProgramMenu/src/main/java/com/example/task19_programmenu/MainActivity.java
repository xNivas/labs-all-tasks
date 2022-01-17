package com.example.task19_programmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0,1,0,"Fruits");
        menu.add(0,2,1,"Vegetables");
        menu.add(0,3,3,"Milk");
        menu.add(0,4,2,"Bread");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView messageView = (TextView) findViewById(R.id.message);
        int id = item.getItemId();

        switch(id){
            case 1 :
                messageView.setText("Select at least 1 fruit");
                return true;
            case 2:
                messageView.setText("Select 2 vegetables");
                return true;
            case 3:
                messageView.setText("Select 1 bottle of milk");
                return true;
            case 4:
                messageView.setText("Select bread");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

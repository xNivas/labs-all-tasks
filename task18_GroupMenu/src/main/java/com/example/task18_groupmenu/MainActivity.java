package com.example.task18_groupmenu;

import androidx.annotation.NonNull;
import  androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void onSaltMenuClick(MenuItem item) {
        TextView message = (TextView) findViewById(R.id.message);
        message.setText("You selected salt");
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
//        return super.onOptionsItemSelected(item);
//    }
}
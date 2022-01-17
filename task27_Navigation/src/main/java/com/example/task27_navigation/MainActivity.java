package com.example.task27_navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnScreen2;
    Button btnScreen3;
    Button btnScreen4;

    final String TAG = "Status";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScreen2 = (Button) findViewById(R.id.btnScreen2);
        btnScreen2.setOnClickListener(this);

        btnScreen3 = (Button) findViewById(R.id.btnScreen3);
        btnScreen3.setOnClickListener(this);

        btnScreen4 = (Button) findViewById(R.id.btnScreen4);
        btnScreen4.setOnClickListener(this);

        Log.d(TAG, "MainActivity: onCreate()");
        Toast.makeText(this, "MainActivity: onCreate()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MainActivity: onRestart()");
        Toast.makeText(this, "MainActivity: onRestart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity: onStart()");
        Toast.makeText(this, "MainActivity: onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity: onResume()");
        Toast.makeText(this, "MainActivity: onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity: onPause()");
        Toast.makeText(this, "MainActivity: onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity: onStop()");
        Toast.makeText(this, "MainActivity: onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity: onDestroy()");
        Toast.makeText(this, "MainActivity: onDestroy()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnScreen2:
                Intent intent2 = new Intent(this, Screen2.class);
                startActivity(intent2);
                break;
            case R.id.btnScreen3:
                Intent intent3 = new Intent(this, Screen3.class);
                startActivity(intent3);
                break;
            case R.id.btnScreen4:
                Intent intent4 = new Intent(this, Screen4.class);
                startActivity(intent4);
                break;
            default:
                break;
        }
    }

}

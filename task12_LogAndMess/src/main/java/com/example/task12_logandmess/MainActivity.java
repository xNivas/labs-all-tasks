package com.example.task12_logandmess;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.task12_logandmess.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvOut;
    Button btnOk;
    Button btnCancel;
    private static final String TAG = "myLogs";


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find View-elements
        Log.d(TAG, "find View-elements");
        tvOut = (TextView) findViewById(R.id.tvOut);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        //assign event handler to buttons
        Log.d(TAG, "assign event handler to buttons");
        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // define button handler by id
        switch (v.getId()) {
            case R.id.btnOk:
                // button ОК
                Log.d(TAG, "button ОК");
                Toast.makeText(this, "Ok button was pressed", Toast.LENGTH_LONG).show();
                tvOut.setText("ОК button was pressed");
                break;
            case R.id.btnCancel:
                // button Cancel
                Log.d(TAG, "button Cancel");
                Toast.makeText(this, "Cancel button was pressed", Toast.LENGTH_LONG).show();
                tvOut.setText("Cancel button was pressed");
                break;
        }
    }
}

package com.example.task10_activitylistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvOut;
    Button btnOk;
    Button btnCancel;
    Button btnStart;

    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOut = (TextView) findViewById(R.id.tvOut);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnStart = (Button) findViewById(R.id.btnStart);

        //assign event handler to buttons
        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        btnStart.setOnClickListener(this);
    }

    //@Override
    public void onClick(View v) {
        // define button handler by id
        switch (v.getId()) {
            case R.id.btnOk:
                // button ОК
                tvOut.setText("ОК button was pressed");
                break;
            case R.id.btnCancel:
                // button Cancel
                tvOut.setText("Cancel button was pressed");
                break;
            case R.id.btnStart:
                // button Start
                tvOut.setText("Start button was pressed");
                break;
        }
    }

}
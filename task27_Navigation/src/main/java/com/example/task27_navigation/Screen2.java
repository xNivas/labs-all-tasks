package com.example.task27_navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class Screen2 extends AppCompatActivity implements View.OnClickListener {

    LinearLayout layout;
    RadioGroup rgGravity;
    Button btnCreate;
    Button btnClear;

    final static int min = 1;
    final static int max = 10;

    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        layout = (LinearLayout) findViewById(R.id.layout3);
        rgGravity = (RadioGroup) findViewById(R.id.rgGravity);

        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCreate:
                // Create LayoutParams with width and height wrapContent
                LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                        wrapContent, wrapContent);
                // variable to store alignment value
                // by default set to LEFT
                int tvGravity = Gravity.LEFT;
                // define RadioButton is selected and
                // fill in btnGravity
                switch (rgGravity.getCheckedRadioButtonId()) {
                    case R.id.rbLeft:
                        tvGravity = Gravity.LEFT;
                        break;
                    case R.id.rbCenter:
                        tvGravity = Gravity.CENTER_HORIZONTAL;
                        break;
                    case R.id.rbRight:
                        tvGravity = Gravity.RIGHT;
                        break;
                }
                // move received alignment value into LayoutParams
                lParams.gravity = tvGravity;

                // create TextView, add text, add into LinearLayout
                TextView tvNew = new TextView(this);
                Random r = new Random();
                int randomNum = r.nextInt((max - min) + 1) + min;
                tvNew.setText("  test "+String.valueOf(randomNum)+"  ");
                tvNew.setTextSize(20);

                int red=r.nextInt(255 - 0 + 1)+0;
                int green=r.nextInt(255 - 0 + 1)+0;
                int blue=r.nextInt(255 - 0 + 1)+0;
                GradientDrawable draw = new GradientDrawable();
                draw.setShape(GradientDrawable.OVAL);
                draw.setColor(Color.rgb(red,green,blue));
                tvNew.setBackground(draw);

                layout.addView(tvNew, lParams);

                break;
            case R.id.btnClear:
                layout.removeAllViews();
                Toast.makeText(this, "All messages were deleted", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

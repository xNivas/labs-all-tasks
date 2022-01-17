package com.example.task27_navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import java.util.Random;

public class Screen4 extends AppCompatActivity  implements SeekBar.OnSeekBarChangeListener{

    SeekBar sbWeight;
    Button btn1, btn2, btn3, btn4;

    LinearLayout.LayoutParams params1, params2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);

        sbWeight = (SeekBar) findViewById(R.id.sbWeight);
        sbWeight.setOnSeekBarChangeListener(this);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);

        params1 = (LinearLayout.LayoutParams) btn1.getLayoutParams();
        params2 = (LinearLayout.LayoutParams) btn2.getLayoutParams();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        int leftValue = progress;
        int rightValue = seekBar.getMax() - progress;

        params1.weight = leftValue;
        params2.weight = rightValue;

        Random r = new Random();
        int red1=r.nextInt(255 - 0 + 1)+0;
        int green1=r.nextInt(255 - 0 + 1)+0;
        int blue1=r.nextInt(255 - 0 + 1)+0;
        GradientDrawable draw1 = new GradientDrawable();
        draw1.setShape(GradientDrawable.OVAL);
        draw1.setColor(Color.rgb(red1,green1,blue1));
        btn1.setText(String.valueOf(leftValue));
        btn1.setBackground(draw1);

        int red2=r.nextInt(255 - 0 + 1)+0;
        int green2=r.nextInt(255 - 0 + 1)+0;
        int blue2=r.nextInt(255 - 0 + 1)+0;
        GradientDrawable draw2 = new GradientDrawable();
        draw2.setShape(GradientDrawable.OVAL);
        draw2.setColor(Color.rgb(red2,green2,blue2));

        btn2.setText(String.valueOf(rightValue));
        btn2.setBackground(draw2);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Random r = new Random();

        int red=r.nextInt(255 - 0 + 1)+0;
        int green=r.nextInt(255 - 0 + 1)+0;
        int blue=r.nextInt(255 - 0 + 1)+0;
        GradientDrawable draw = new GradientDrawable();
        draw.setShape(GradientDrawable.RECTANGLE);
        draw.setColor(Color.rgb(red,green,blue));

        btn3.setText("Start");
        btn3.setBackground(draw);
        btn4.setText("");
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        Random r = new Random();

        int red=r.nextInt(255 - 0 + 1)+0;
        int green=r.nextInt(255 - 0 + 1)+0;
        int blue=r.nextInt(255 - 0 + 1)+0;
        GradientDrawable draw = new GradientDrawable();
        draw.setShape(GradientDrawable.RECTANGLE);
        draw.setColor(Color.rgb(red,green,blue));

        btn3.setText("");
        btn4.setText("Stop");
        btn4.setBackground(draw);
    }
}

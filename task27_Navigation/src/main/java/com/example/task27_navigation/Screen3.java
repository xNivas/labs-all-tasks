package com.example.task27_navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class Screen3 extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        ViewGroup.LayoutParams linLayoutParam = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setContentView(layout, linLayoutParam);

        ViewGroup.LayoutParams paramsView = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView tv = new TextView(this);
        tv.setText("Screen 3");
        tv.setLayoutParams(paramsView);
        layout.addView(tv);

        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params1.gravity = Gravity.LEFT;

        Button btn1 = new Button(this);
        btn1.setText("Button1");
        layout.addView(btn1, params1);

        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params2.gravity = Gravity.CENTER;

        Button btn2 = new Button(this);
        btn2.setText("Button2");
        layout.addView(btn2, params2);

        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params3.gravity = Gravity.RIGHT;

        Button btn3 = new Button(this);
        btn3.setText("Button3");
        layout.addView(btn3, params3);

        Random r = new Random();

        LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params4.leftMargin = 70;
        params4.gravity = Gravity.LEFT;
        int red4=r.nextInt(255 - 0 + 1)+0;
        int green4=r.nextInt(255 - 0 + 1)+0;
        int blue4=r.nextInt(255 - 0 + 1)+0;
        GradientDrawable draw4 = new GradientDrawable();
        draw4.setShape(GradientDrawable.OVAL);
        draw4.setColor(Color.rgb(red4,green4,blue4));
        Button btn4 = new Button(this);
        btn4.setText("Button4");
        btn4.setBackground(draw4);
        layout.addView(btn4, params4);

        LinearLayout.LayoutParams params5 = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params5.topMargin = 250;
        params5.gravity = Gravity.CENTER;
        int red5=r.nextInt(255 - 0 + 1)+0;
        int green5=r.nextInt(255 - 0 + 1)+0;
        int blue5=r.nextInt(255 - 0 + 1)+0;
        GradientDrawable draw5 = new GradientDrawable();
        draw5.setShape(GradientDrawable.OVAL);
        draw5.setColor(Color.rgb(red5,green5,blue5));
        Button btn5 = new Button(this);
        btn5.setText("Button5");
        btn5.setBackground(draw5);
        layout.addView(btn5, params5);

        LinearLayout.LayoutParams params6 = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params6.rightMargin = 70;
        params6.gravity = Gravity.RIGHT;
        int red6=r.nextInt(255 - 0 + 1)+0;
        int green6=r.nextInt(255 - 0 + 1)+0;
        int blue6=r.nextInt(255 - 0 + 1)+0;
        GradientDrawable draw6 = new GradientDrawable();
        draw6.setShape(GradientDrawable.OVAL);
        draw6.setColor(Color.rgb(red6,green6,blue6));
        Button btn6 = new Button(this);
        btn6.setText("Button6");
        btn6.setBackground(draw6);
        layout.addView(btn6, params6);
    }

}

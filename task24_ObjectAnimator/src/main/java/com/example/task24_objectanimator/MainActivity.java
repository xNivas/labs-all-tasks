package com.example.task24_objectanimator;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvWinter;
    TextView tvSpring;
    TextView tvSummer;
    TextView tvAutumn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWinter = (TextView) findViewById(R.id.tvWinter);
        ObjectAnimator winterAnim = ObjectAnimator.ofFloat(tvWinter, "alpha", 0.3f);
        winterAnim.setDuration(2000);
        winterAnim.start();

        tvSummer = (TextView) findViewById(R.id.tvSummer);
        ObjectAnimator summerAnim = ObjectAnimator.ofFloat(tvSummer, "Y", 1000);
        summerAnim.setDuration(1000);
        summerAnim.setInterpolator(new BounceInterpolator());
        summerAnim.start();

        tvAutumn = (TextView) findViewById(R.id.tvAutumn);
        ObjectAnimator autumnAnim = ObjectAnimator.ofFloat(tvAutumn, "scaleX", 1.0f, 2.5f);
        autumnAnim.setDuration(2000);
        autumnAnim.start();

        tvSpring = (TextView) findViewById(R.id.tvSpring);
        ObjectAnimator springAnim = ObjectAnimator.ofFloat(tvSpring, "scaleY", 1.0f, 5.0f);
        springAnim.setDuration(1000);
        springAnim.setRepeatCount(springAnim.INFINITE);
        springAnim.setRepeatMode(springAnim.REVERSE);
        springAnim.start();

    }
}

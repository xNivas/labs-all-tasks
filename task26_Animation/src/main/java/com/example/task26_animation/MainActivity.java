package com.example.task26_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get link to the sun
        ImageView sunImageView = (ImageView) findViewById(R.id.sun);
        // Sunrize animation
        Animation sunRiseAnimation = AnimationUtils.loadAnimation(this, R.anim.sun_rise);
        // Assign animation to View
        sunImageView.startAnimation(sunRiseAnimation);
        // Get link to the clock
        ImageView clockImageView = (ImageView) findViewById(R.id.clock);
        // clock turn animation
        Animation clockTurnAnimation = AnimationUtils.loadAnimation(this, R.anim.clock_turn);
        clockImageView.startAnimation(clockTurnAnimation);
        // Get link to the hour turn
        ImageView hourImageView = (ImageView) findViewById(R.id.hour_hand);
        // arrow animation
        Animation hourTurnAnimation = AnimationUtils.loadAnimation(this, R.anim.hour_turn);
        // add animation
        hourImageView.startAnimation(hourTurnAnimation);
        // Get link to the ship
        ImageView shipImageView = (ImageView) findViewById(R.id.ship);
        // Ship animation
        Animation shipRunAnimation = AnimationUtils.loadAnimation(this, R.anim.ship_run);
        // Assign animation to View
        shipImageView.startAnimation(shipRunAnimation);




    }

}
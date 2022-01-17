package com.example.task26_wlasnaanimacja;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SlideAnimation {

    public void runAnimation (TextView tytul, TextView tresc, ImageView obrazek){
        Animation animationTitle =
                AnimationUtils.loadAnimation(tytul.getContext(), R.anim.fade_in);
        tytul.startAnimation(animationTitle);

        Animation animationContent =
                AnimationUtils.loadAnimation(tresc.getContext(), R.anim.movement);
        tresc.startAnimation(animationContent);

        Animation animationImage =
                AnimationUtils.loadAnimation(obrazek.getContext(), R.anim.slide_down);
        obrazek.startAnimation(animationImage);
    }


}




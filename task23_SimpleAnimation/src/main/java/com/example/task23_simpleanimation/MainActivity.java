package com.example.task23_simpleanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // constants for menu items ID
    final int menu_fade_in_id = 1;
    final int menu_fade_out_id = 2;
    final int menu_blink_id = 3;
    final int menu_movement_id = 4;
    final int menu_rotation1_id = 5;
    final int menu_rotation2_id = 6;
    final int menu_scaling_id = 7;
    final int menu_slide_up_id = 8;
    final int menu_slide_down_id = 9;
    final int menu_zoom_in_id = 10;
    final int menu_zoom_out_id = 11;
    final int menu_triple_id = 12;

    TextView tv;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        // register context menu for tv component
        registerForContextMenu(tv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.tv:
                // add menu items
                menu.add(0, menu_fade_in_id, 0, "fade in");
                menu.add(0, menu_fade_out_id, 0, "fade out");
                menu.add(0, menu_blink_id, 0, "blink");
                menu.add(0, menu_movement_id, 0, "movement");
                menu.add(0, menu_rotation1_id, 0, "rotation1");
                menu.add(0, menu_rotation2_id, 0, "rotation2");
                menu.add(0, menu_scaling_id, 0, "scaling");
                menu.add(0, menu_slide_up_id, 0, "slide up");
                menu.add(0, menu_slide_down_id, 0, "slide down");
                menu.add(0, menu_zoom_in_id, 0, "zoom in");
                menu.add(0, menu_zoom_out_id, 0, "zoom out");
                menu.add(0, menu_triple_id, 0, "tripple");

                break;
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Animation anim = null;
        // determine which item was clicked
        switch (item.getItemId()) {
            case menu_fade_in_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.fade_in);
                break;
            case menu_fade_out_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.fade_out);
                break;
            case menu_blink_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.blink);
                break;
            case menu_movement_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.movement);
                break;
            case menu_rotation1_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.rotation1);
                break;
            case menu_rotation2_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.rotation2);
                break;
            case menu_scaling_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.scaling);
                break;
            case menu_slide_up_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.slide_up);
                break;
            case menu_slide_down_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.slide_down);
                break;
            case menu_zoom_in_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
                break;
            case menu_zoom_out_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
                break;
            case menu_triple_id:
                anim = AnimationUtils.loadAnimation(this, R.anim.triple);
                break;
        }
        // run animation for tv component
        tv.startAnimation(anim);
        return super.onContextItemSelected(item);
    }

}
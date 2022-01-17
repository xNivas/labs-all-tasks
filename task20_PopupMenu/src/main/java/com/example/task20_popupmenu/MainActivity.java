package com.example.task20_popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btn);
        TextView textView = findViewById(R.id.textView);
        ImageView imageView = findViewById(R.id.imageView);

        button.setOnClickListener(viewClickListener);
        textView.setOnClickListener(viewClickListener);
        imageView.setOnClickListener(viewClickListener);
    }

    View.OnClickListener viewClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showPopupMenu(v);
        }
    };

    private void showPopupMenu(View v) {
        PopupMenu menu = new PopupMenu(this, v);
        menu.inflate(R.menu.main_menu);

        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.milk:
                                Toast.makeText(getApplicationContext(),
                                        "You selected milk",
                                        Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.sugar:
                                Toast.makeText(getApplicationContext(),
                                        "You selected sugar",
                                        Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.egg:
                                Toast.makeText(getApplicationContext(),
                                        "You selected egg",
                                        Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.fruits:
                                Toast.makeText(getApplicationContext(),
                                        "You selected fruits",
                                        Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.vegetables:
                                Toast.makeText(getApplicationContext(),
                                        "You selected vegetables",
                                        Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return false;
                        }
                    }
                });

        menu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
                Toast.makeText(getApplicationContext(), "onDismiss",
                        Toast.LENGTH_SHORT).show();
            }
        });
        menu.show();
    }
}

package com.yash.fooddonationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yash.fooddonationapplication.R;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         fab = findViewById(R.id.floatingActionButton);
         imageView = (ImageView)findViewById(R.id.imageViewMain);
/*MediaPlayer mediaPlayer = MediaPlayer.create(this,R.bombSound);*/
         imageView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 imageView.animate().alpha(0).setDuration(2000);
                 imageView.animate().alpha(1).setDuration(2000);
                 imageView.animate().alpha(0).setDuration(2000);
                 imageView.animate().alpha(1).setDuration(2000);
             }
         });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DecidingActivity.class));
                Toast.makeText(MainActivity.this, "Hi", LENGTH_LONG).show();
            }
        });
    }
}
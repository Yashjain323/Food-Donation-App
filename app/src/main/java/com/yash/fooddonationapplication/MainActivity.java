package com.yash.fooddonationapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* imageView = (ImageView)findViewById(R.id.imageViewMain);
        imageView.animate().alpha(0).setDuration(1000);
        imageView.animate().alpha(1).setDuration(1000);
        imageView.animate().alpha(0).setDuration(1000);
        imageView.animate().alpha(1).setDuration(1000);*/
///*MediaPlayer mediaPlayer = MediaPlayer.create(this,R.bombSound);*/
        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                    startActivity(new Intent(MainActivity.this, DecidingActivity.class));
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {

                }
            }

        } ;thread.start();
        }
    }
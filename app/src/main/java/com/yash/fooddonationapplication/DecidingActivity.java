package com.yash.fooddonationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class DecidingActivity extends AppCompatActivity {
    Button Button1 =(Button)findViewById(R.id.donorDecide);
    Button Button2 =(Button)findViewById(R.id.recipientDecide);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deciding);
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DonorSignIn.class));
                Toast.makeText(getApplicationContext(),"Welcome Donor! Let's Sign IN",LENGTH_LONG).show();
            }
        });
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RecipientSignIn.class));
                Toast.makeText(getApplicationContext(),"Welcome User! Let's Register", LENGTH_LONG).show();
            }
        });

        }
    }
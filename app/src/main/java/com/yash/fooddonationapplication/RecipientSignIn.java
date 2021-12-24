package com.yash.fooddonationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class RecipientSignIn extends AppCompatActivity {
    Button Button1 = (Button)findViewById(R.id.dSignUpButton);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipient_sign_in);
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ReciepientRegistration.class));
                Toast.makeText(getApplicationContext(),"Enter your details Recipient",LENGTH_LONG).show();
            }
        });
    }
}
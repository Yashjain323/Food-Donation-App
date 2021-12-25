package com.yash.fooddonationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yash.fooddonationapplication.R;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {
     private Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.mainbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DonorSignIn.class));
                Toast.makeText(MainActivity.this, "Hi", LENGTH_LONG).show();
            }
        }
        );
    }
}
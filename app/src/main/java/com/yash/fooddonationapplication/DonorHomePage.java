package com.yash.fooddonationapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class DonorHomePage extends AppCompatActivity {
    private Button readRecipientBtn;
    private Button FoodPostBtn;

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.donormenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        switch(item.getItemId()) {
            case R.id.menuProfile:
                Intent intent = new Intent(DonorHomePage.this, DonorProfile.class);
                startActivity(intent);
                return true;
            case R.id.menuAchieve:
                intent = new Intent(DonorHomePage.this, DonorList.class);
                startActivity(intent);
                return true;
            case R.id.menuMaps:
                intent = new Intent(DonorHomePage.this,MapsActivity.class);
                startActivity(intent);
                return true;
            case R.id.donorLogOut:
                intent = new Intent(DonorHomePage.this,DecidingActivity.class);
                startActivity(intent);
                return true;
            case R.id.donorContactUs:
                intent = new Intent(DonorHomePage.this,DonorContactUs.class);
                startActivity(intent);
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_home_page);

        readRecipientBtn = findViewById(R.id.BtnReadRecipient);
        FoodPostBtn = findViewById(R.id.orgSetupBtn);
        readRecipientBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(DonorHomePage.this, ReciepientList.class);
                startActivity(i);
            }
        });
            FoodPostBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // opening a new activity via a intent.
                    Intent i = new Intent(DonorHomePage.this, DonorFoodDetailsPost.class);
                    startActivity(i);
                }
            });
    }
}
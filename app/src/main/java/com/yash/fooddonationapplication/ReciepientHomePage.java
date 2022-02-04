package com.yash.fooddonationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

  public class ReciepientHomePage extends AppCompatActivity {
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.recipientmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        switch(item.getItemId()) {
            case R.id.recepientProfile:
                Intent intent = new Intent(ReciepientHomePage.this, RecipientProfile.class);
                startActivity(intent);
                return true;
            case R.id.recepientAchieve:
                intent = new Intent(ReciepientHomePage.this, DonorAchievements.class);
                startActivity(intent);
                return true;
            case R.id.menuMaps:
                intent = new Intent(ReciepientHomePage.this,MapsActivity.class);
                startActivity(intent);
                return true;
            case R.id.recepientLogOut:
                intent = new Intent(ReciepientHomePage.this,RecipientSignIn.class);
                startActivity(intent);
            default:
                return false;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciepient_home_page);
        Button reciepientSetupBtn = findViewById(R.id.orgSetupBtn);
        Button showListDonorBtn = findViewById(R.id.BtnReadRecipient);
        reciepientSetupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(ReciepientHomePage.this, reciepientSetup.class);
                startActivity(i);
            }
        });
        showListDonorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(ReciepientHomePage.this, DonorList.class);
                startActivity(i);
            }
        });
    }
}
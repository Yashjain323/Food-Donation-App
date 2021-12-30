package com.yash.fooddonationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class DonorHomePage extends AppCompatActivity {
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.donormenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        switch(item.getItemId()) {
            case R.id.menuProfile:
                Intent intent = new Intent(DonorHomePage.this, DonatorProfile.class);
                startActivity(intent);
                return true;
            case R.id.menuAchieve:
                intent = new Intent(DonorHomePage.this, DonorAchievements.class);
                startActivity(intent);
                return true;
            case R.id.menuMaps:
                intent = new Intent(DonorHomePage.this,MapsActivity.class);
                startActivity(intent);
                return true;
            case R.id.donorLogOut:
                intent = new Intent(DonorHomePage.this,DonorSignIn.class);
                startActivity(intent);
            default:
                return false;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_home_page);
    }
}
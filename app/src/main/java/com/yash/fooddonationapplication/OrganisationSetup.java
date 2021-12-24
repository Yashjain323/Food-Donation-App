package com.yash.fooddonationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class OrganisationSetup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organisation_setup);
        ListView myListView = findViewById(R.id.reciepientList);
        ArrayList <String> rList = new ArrayList<String>();

/* ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.database.)*/
    }
}
package com.yash.fooddonationapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReciepientList extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<RecipientDisplayModal> RecipientModalArrayList;
    private DbHandler dbHandler;
    private ReciepientRVAdapter reciepientRVAdapter;
    private RecyclerView recipientRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciepient_list);

        // initializing our all variables.
        RecipientModalArrayList = new ArrayList<>();
        dbHandler = new DbHandler(ReciepientList.this);

        // getting our course array
        // list from db handler class.
        RecipientModalArrayList = dbHandler.readCourses();

        // on below line passing our array lost to our adapter class.
        reciepientRVAdapter = new ReciepientRVAdapter(RecipientModalArrayList, ReciepientList.this);
        recipientRV = findViewById(R.id.idRVCourses);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ReciepientList.this, RecyclerView.VERTICAL, false);
        recipientRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        recipientRV.setAdapter(reciepientRVAdapter);
    }
}

package com.yash.fooddonationapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ReciepientList extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<RecipientDisplayModal> RecipientModalArrayList;
    private ReciepientRVAdapter reciepientRVAdapter;
    private RecyclerView recipientRV;
    private FirebaseFirestore db1;
    ProgressBar loadingPB1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciepient_list);

        // initializing our all variables.
        RecipientModalArrayList = new ArrayList<>();
        // getting our course array
        // list from db handler class.
        //RecipientModalArrayList = dbHandler.readCourses();
        db1 = FirebaseFirestore.getInstance();
        loadingPB1 = findViewById(R.id.idProgressBar1);
        // on below line passing our array lost to our adapter class.
        reciepientRVAdapter = new ReciepientRVAdapter(RecipientModalArrayList, ReciepientList.this);
        recipientRV = findViewById(R.id.idRVCourses);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ReciepientList.this, RecyclerView.VERTICAL, false);
        recipientRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        recipientRV.setAdapter(reciepientRVAdapter);

        db1.collection("RecipientDetailsPostDBhandler").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        // after getting the data we are calling on success method
                        // and inside this method we are checking if the received
                        // query snapshot is empty or not.
                        if (!queryDocumentSnapshots.isEmpty()) {
                            // if the snapshot is not empty we are
                            // hiding our progress bar and adding
                            // our data in a list.
                            loadingPB1.setVisibility(View.GONE);
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                // after getting this list we are passing
                                // that list to our object class.
                                RecipientDisplayModal c = d.toObject(RecipientDisplayModal.class);

                                // and we will pass this object class
                                // inside our arraylist which we have
                                // created for recycler view.
                                RecipientModalArrayList.add(c);
                            }
                            // after adding the data to recycler view.
                            // we are calling recycler view notifuDataSetChanged
                            // method to notify that data has been changed in recycler view.
                            reciepientRVAdapter.notifyDataSetChanged();
                        } else {
                            // if the snapshot is empty we are displaying a toast message.
                            Toast.makeText(ReciepientList.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // if we do not get any data or any error we are displaying
                // a toast message that we do not get any data
                Toast.makeText(ReciepientList.this, "Fail to get the data.", Toast.LENGTH_SHORT).show();
            }
        });
    }
    }

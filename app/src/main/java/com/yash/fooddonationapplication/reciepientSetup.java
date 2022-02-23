package com.yash.fooddonationapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class reciepientSetup extends AppCompatActivity {
    private EditText orgName;
    private EditText orgAddress;
    private EditText orgPhone;
    private EditText orgDesc;
    private ImageView addOrgButton;
    private FirebaseFirestore db1;
    private String Name,Phone,Address,Desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciepient_setup);
        addOrgButton = findViewById(R.id.addOrgButton);
        orgName = findViewById(R.id.orgSetName);
        orgAddress = findViewById(R.id.orgSetAddress);
        orgPhone = findViewById(R.id.orgSetupPhone);
        orgDesc = findViewById(R.id.orgSetupDesc);
        db1 = FirebaseFirestore.getInstance();
        //dbHandler = new DbHandler(reciepientSetup.this);
        addOrgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                Name = orgName.getText().toString();
                Address = orgAddress.getText().toString();
                Phone = orgPhone.getText().toString();
                Desc = orgDesc.getText().toString();

                // validating if the text fields are empty or not.
                if (Name.isEmpty() && Address.isEmpty() && Phone.isEmpty() && Desc.isEmpty()) {
                    Toast.makeText(reciepientSetup.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                //dbHandler.addNewCourse(Name, Address, Phone, Desc);
                addRDataToFirestore(Name, Address, Phone, Desc);
                // after adding the data we are displaying a toast message.
                orgName.setText("");
                orgAddress.setText("");
                orgPhone.setText("");
                orgDesc.setText("");
            }
        });
    }
    private void addRDataToFirestore (String postName, String postAddress, String postPhone, String postDesc){
        // creating a collection reference
        // for our Firebase Firetore database.
        CollectionReference dbCourses = db1.collection("RecipientDetailsPostDBhandler");

        // adding our data to our courses object class.
        RecipientDisplayModal rDetails = new RecipientDisplayModal(postName,postAddress,postPhone,postDesc);

        // below method is use to add data to Firebase Firestore.
        dbCourses.add(rDetails).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                // after the data addition is successful
                // we are displaying a success toast message.
                Toast.makeText(reciepientSetup.this, "Your organisation details have been saved", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // this method is called when the data addition process is failed.
                // displaying a toast message when data addition is failed.
                Toast.makeText(reciepientSetup.this, "Failed to add food details \n" + e, Toast.LENGTH_SHORT).show();
            }
        });
    }
}


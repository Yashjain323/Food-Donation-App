package com.yash.fooddonationapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class DonorFoodDetailsPost extends AppCompatActivity {
   private EditText quantity;
   private EditText perishability;
   private EditText nutritionValue;
   private EditText personsFed;
   private EditText DonorFoodDetails;
   private EditText postName;
   private FirebaseFirestore db;
   private Button buttonClickPost;
   private String postNameText,quantityText,perishablilityText,nutritionalValueText,personFedText,
           DonorFoodDetailsText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        postName = findViewById(R.id.foodPostName);
        quantity = findViewById(R.id.DonorFoodDetail_Quantity);
        perishability = findViewById(R.id.DonorFoodDetail_Parishability);
        nutritionValue = findViewById(R.id.DonorFoodDetail_NutritionValue);
        personsFed = findViewById(R.id.DonorFoodDetail_PersonsFed);
        DonorFoodDetails = findViewById(R.id.DonorFoodDetail_MultiLine);
        buttonClickPost = findViewById(R.id.buttonPost);

        setContentView(R.layout.activity_donor_food_details_post);
        db = FirebaseFirestore.getInstance();
        buttonClickPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                postNameText = postName.getText().toString();
                quantityText = quantity.getText().toString();
                perishablilityText = perishability.getText().toString();
                nutritionalValueText = nutritionValue.getText().toString();
                personFedText = personsFed.getText().toString();
                DonorFoodDetailsText = DonorFoodDetails.getText().toString();

                // validating the text fields if empty or not.
                if (TextUtils.isEmpty(postNameText)) {
                    postName.setError("Please enter Course Name");
                } else if (TextUtils.isEmpty(quantityText)) {
                    quantity.setError("Please enter Course Description");
                } else if (TextUtils.isEmpty(perishablilityText)) {
                    perishability.setError("Please enter Course Duration");
                } else {
                    // calling method to add data to Firebase Firestore.
                    addDataToFirestore(postNameText, quantityText, perishablilityText,
                            nutritionalValueText, personFedText, DonorFoodDetailsText);
                }
            }
        });
    }

        private void addDataToFirestore (String postNameText, String quantityText,
                String perishablilityText, String nutritionalValueText, String personFedText,
                String DonorFoodDetailsText){

            // creating a collection reference
            // for our Firebase Firetore database.
            CollectionReference dbCourses = db.collection("FoodDetailsPostDBhandler");

            // adding our data to our courses object class.
            FoodDetailsPostDBhandler foodDetails = new FoodDetailsPostDBhandler
                    (postNameText, quantityText, perishablilityText,
                            nutritionalValueText, personFedText, DonorFoodDetailsText);

            // below method is use to add data to Firebase Firestore.
            dbCourses.add(foodDetails).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    // after the data addition is successful
                    // we are displaying a success toast message.
                    Toast.makeText(DonorFoodDetailsPost.this, "Your Course has been added to Firebase Firestore", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    // this method is called when the data addition process is failed.
                    // displaying a toast message when data addition is failed.
                    Toast.makeText(DonorFoodDetailsPost.this, "Fail to add course \n" + e, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
package com.yash.fooddonationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class DonorFoodDetailsPost extends AppCompatActivity {
    EditText Quantity=findViewById(R.id.DonorFoodDetail_Quantity);
    EditText Parishability=findViewById(R.id.DonorFoodDetail_Parishability);
    EditText NutritionValue=findViewById(R.id.DonorFoodDetail_NutritionValue);
    EditText PersonsFed=findViewById(R.id.DonorFoodDetail_PersonsFed);
    EditText DonorFoodDetail=findViewById(R.id.DonorFoodDetail_MultiLine);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_food_details_post);
    }
}
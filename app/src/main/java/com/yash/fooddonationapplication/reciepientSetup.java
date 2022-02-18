package com.yash.fooddonationapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class reciepientSetup extends AppCompatActivity {
    private EditText orgName;
    private EditText orgAddress;
    private EditText orgPhone;
    private EditText orgDesc;
    private ImageView addOrgButton;
    private DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciepient_setup);
        addOrgButton = findViewById(R.id.addOrgButton);
        orgName = findViewById(R.id.orgSetName);
        orgAddress = findViewById(R.id.orgSetAddress);
        orgPhone = findViewById(R.id.orgSetupPhone);
        orgDesc = findViewById(R.id.orgSetupDesc);

        dbHandler = new DbHandler(reciepientSetup.this);

        addOrgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String Name = orgName.getText().toString();
                String Address = orgAddress.getText().toString();
                String Phone = orgPhone.getText().toString();
                String Desc = orgDesc.getText().toString();

                // validating if the text fields are empty or not.
                if (Name.isEmpty() && Address.isEmpty() && Phone.isEmpty() && Desc.isEmpty()) {
                    Toast.makeText(reciepientSetup.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewCourse(Name, Address, Phone, Desc);

                // after adding the data we are displaying a toast message.
                Toast.makeText(reciepientSetup.this, "Data has been added.", Toast.LENGTH_SHORT).show();
                orgName.setText("");
                orgAddress.setText("");
                orgPhone.setText("");
                orgDesc.setText("");
            }
        });
    }
}


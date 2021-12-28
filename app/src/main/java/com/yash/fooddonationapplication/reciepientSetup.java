package com.yash.fooddonationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

import static java.sql.Types.VARCHAR;

public class reciepientSetup extends AppCompatActivity {
    private EditText orgName;
    private EditText orgAddress;
    private EditText orgPhone;
    private EditText orgDesc;
    private Button addOrgButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciepient_setup);
        addOrgButton = findViewById(R.id.addOrgButton);
    /*
        currentUser = FirebaseAuth.getInstance().getCurrentUser().getUid();
*/

        addOrgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orgName = findViewById(R.id.orgSetName);
                orgAddress = findViewById(R.id.orgSetAddress);
                orgPhone = findViewById(R.id.orgSetupPhone);
                orgDesc = findViewById(R.id.orgSetupDesc);
                String orgNameText= orgName.getText().toString();
                String orgAddressText = orgAddress.getText().toString();
                String orgDescText = orgDesc.getText().toString();
                String orgPhoneText = orgPhone.getText().toString();

                SQLiteDatabase myDatabase = openOrCreateDatabase("OrgTable", MODE_PRIVATE, null);
                myDatabase.execSQL("CREATE TABLE IF NOT EXISTS orgs(name VARCHAR, address VARCHAR, description VARCHAR,phone INT(10))");
                myDatabase.execSQL("INSERT INTO orgs(name,address,description,phone) " +
                        "VALUES ('"+ orgNameText +"','"+orgAddressText +"','" + "'"+orgDescText+"','"+orgPhoneText+"');");
            }
        });

        }
    }
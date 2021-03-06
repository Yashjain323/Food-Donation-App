package com.yash.fooddonationapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class RecipientProfile extends AppCompatActivity {
    FloatingActionButton camera_open_id;
    ImageView click_image_id;
    private static final int pic_id = 123;
    private EditText NameEdt,NameRegister, EmailEdt, AddressEdt, ContactEdt;
    private Button addCourseBtn;
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 2) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipient_profile);
            // creating variables for our edittext, button and dbhandle
                // initializing all our variables.
                NameRegister = findViewById(R.id.fName);
                NameEdt = findViewById(R.id.rNameSet);
                EmailEdt = findViewById(R.id.rEmailSet);
                AddressEdt = findViewById(R.id.rAddressSet);
                ContactEdt = findViewById(R.id.rContactSet);
                camera_open_id= (FloatingActionButton)findViewById(R.id.clickpicR);
                click_image_id = (ImageView)findViewById(R.id.imageViewRecepient);
                addCourseBtn = (Button)findViewById(R.id.rUpdateButton);
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                   ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA}, 2);
                 }
                // below line is to add on click listener for our add course button.
                addCourseBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // below line is to get data from all edit text fields.
                        String courseName = NameEdt.getText().toString();
                        String courseTracks = EmailEdt.getText().toString();
                        String courseDuration = AddressEdt.getText().toString();
                        String courseDescription = ContactEdt.getText().toString();
                        EditText editRText = (EditText)findViewById(R.id.rNameSet);
                        NameEdt.setText(NameRegister.getText().toString());
                        // validating if the text fields are empty or not.
                        if (courseName.isEmpty() && courseTracks.isEmpty() && courseDuration.isEmpty() && courseDescription.isEmpty()) {
                            Toast.makeText(RecipientProfile.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        // after adding the data we are displaying a toast message.
                        Toast.makeText(RecipientProfile.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                    }
                });
             camera_open_id.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View v)
             {
                // Create the camera_intent ACTION_IMAGE_CAPTURE
                // it will open the camera for capture the image
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // Start the activity with camera_intent,
                // and request pic id
                startActivityForResult(camera_intent, pic_id);
             }
        });
            }
    @Override
    protected void onStart() {
        super.onStart();
        loadImageFromStorage("/data/data/com.yash.fooddonationapplication/app_imageDir/");
    }
        // This method will help to retrieve the image
        protected void onActivityResult(int requestCode,int resultCode, Intent data) {

            // Match the request 'pic id with requestCode
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == pic_id) {

                // BitMap is data structure of image file
                // which stor the image in memory
                Bitmap photo = (Bitmap) data.getExtras()
                        .get("data");
                saveToInternalStorage(photo);
                // Set the image in imageview for display
                //click_image_id.setImageBitmap(photo);
            }
        }
    private String saveToInternalStorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,"profileR.jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }
    public void loadImageFromStorage(String path)
    {
        try {
            File f=new File(path, "profileR.jpg");
            Bitmap photoTaken = BitmapFactory.decodeStream(new FileInputStream(f));
            //ImageView img=(ImageView)findViewById(R.id.imgPicker);
            click_image_id.setImageBitmap(photoTaken);
            //img.setImageBitmap(b);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    }
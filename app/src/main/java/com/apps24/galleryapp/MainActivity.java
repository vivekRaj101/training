package com.apps24.galleryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button list = (Button) findViewById(R.id.btn_list);
        Button fetchImage = (Button) findViewById(R.id.btn_fetch_image);
        Button fetchContact = (Button) findViewById(R.id.btn_fetch_contact);

//        Log.i(TAG, "onCreate: vvv..1");

        list.setOnClickListener(this);
        fetchImage.setOnClickListener(this);
        fetchContact.setOnClickListener(this);


//        list.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.i(TAG, "onCreate: vvv..2");
//                startActivity(new Intent(getApplicationContext(), ListActivity.class));
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btn_list:
                startActivity(new Intent(getApplicationContext(), ListActivity.class));
                break;
            case R.id.btn_fetch_image:
                startActivity(new Intent(getApplicationContext(), GalleryActivity.class));
                break;
            case R.id.btn_fetch_contact:
                startActivity(new Intent(getApplicationContext(), GalleryActivity.class));
                break;
        }
    }
}
package com.apps24.galleryapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView listView = findViewById(R.id.listView);

        ArrayList<String> carList = new ArrayList();
        carList.add("XUV");
        carList.add("BMW");
        carList.add("RENULT");
        carList.add("ALTO");
        carList.add("SWIFT");
        carList.add("NISAN");
        carList.add("VOLVO");
        carList.add("JAGUAR");
        carList.add("SCORPIO");
        carList.add("MAHINDRA");
        carList.add("TOYOTA");
        carList.add("ZEN");
        carList.add("XUV");

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item, carList);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            private Object TextView;

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = "Item "+i+" "+((TextView) view).getText().toString();
                Toast.makeText(ListActivity.this, ""+text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

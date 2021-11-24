package com.apps24.galleryapp;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    private static final String TAG="MainContactActivity";
    public static final int PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    ListView listView;
    Button btnGetContacts;
    List<ContactsInfo> contactsInfoList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        listView = findViewById(R.id.contact_list);
        Button contact =(Button) findViewById(R.id.txt_heading);

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAllContacts();
            }
        });


//        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS)
//                == PackageManager.PERMISSION_GRANTED) {
//            mobileArray = getAllContacts();
//        } else {
//            requestPermission();
//        }
//        listView = findViewById(R.id.contact_list);
//        ArrayAdapter adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1, mobileArray);
//        listView.setAdapter(adapter);
    }

    public  void getAllContacts(){
        Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");  startManagingCursor(cursor);

        String[] data = {ContactsContract.CommonDataKinds.Phone.NUMBER,
                         ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                          ContactsContract.CommonDataKinds.Phone._ID};
        int[] to = {android.R.id.text1, android.R.id.text2};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.support_simple_spinner_dropdown_item, cursor,data, to);

        listView.setAdapter(adapter);
        listView.setChoiceMode(listView.CHOICE_MODE_MULTIPLE);

    }

//    private void requestPermission() {
//        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.READ_CONTACTS)) {
//            // show UI part if you want here to show some rationale !!!
//        } else {
//            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_CONTACTS},
//                    REQUEST_READ_CONTACTS);
//        }
//        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.READ_CONTACTS)) {
//        } else {
//            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_CONTACTS},
//                    REQUEST_READ_CONTACTS);
//        }
//    }

/*    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_READ_CONTACTS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mobileArray = getAllContacts();
                } else {
                    // permission denied,Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }
    }*/

   /* private ArrayList getAllContacts() {
        ArrayList<String> nameList = new ArrayList<>();
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);
        if ((cur ! = null ? cur.getCount() : 0) > 0) {
            while (cur ! = null && cur.moveToNext()) {
                String id = cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(
                        ContactsContract.Contacts.DISPLAY_NAME));
                nameList.add(name);
                if (cur.getInt(cur.getColumnIndex( ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    Cursor pCur = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id}, null);
                    while (pCur.moveToNext()) {
                        String phoneNo = pCur.getString(pCur.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER));
                    }
                    pCur.close();
                }
            }
        }
        if (cur ! = null) {
            cur.close();
        }
        return nameList;
    }*/
}


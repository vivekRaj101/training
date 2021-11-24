package com.apps24.galleryapp;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;

public class ImagesGallery {

    public static ArrayList<String> listOfImages(Context context){
        Uri uri;
        Cursor cursor=null;

        int column_index_data, column_index_folder_name;

        ArrayList<String> listOfAllImages = new ArrayList<>();
        String absolutePathOfImage;
        uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

//       String[] absolutePathOfImage = {MediaStore.Images.Media.DATA};
        String[] projection = {MediaStore.Images.Media.DATA,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME};
        String imageId=null;
        if(imageId!=null){
            imageId=cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media._ID));
        }


        String orderBy = MediaStore.Images.Media.DISPLAY_NAME;
        cursor = context.getContentResolver().query(uri, projection,null, null,orderBy+"DESC");

        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);

        // get Folder Name.
//        column_index_folder_name = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);

        while (cursor.moveToNext()){
            absolutePathOfImage = cursor.getString(column_index_data);

            listOfAllImages.add(absolutePathOfImage);
        }
        return listOfAllImages;
    }
}

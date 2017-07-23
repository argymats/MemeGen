package com.thenewboston.memegen;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Bacon extends MainActivity{




    public static final int IMAGE_GALLERY_REQUEST = 20;
    private ImageView imgPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText topTextInput = (EditText) findViewById(R.id.topTextInput);
        bottomTextInput = (EditText) findViewById(R.id.bottomTextInput);





        imgPicture = (ImageView) findViewById(R.id.imgPicture);

    }




}
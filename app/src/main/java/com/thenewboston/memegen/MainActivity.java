package com.thenewboston.memegen;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Bitmap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static com.thenewboston.memegen.Bacon.IMAGE_GALLERY_REQUEST;
import static com.thenewboston.memegen.R.id.imgPicture;
import static com.thenewboston.memegen.R.id.meme1;
import static com.thenewboston.memegen.R.id.meme2;
import static com.thenewboston.memegen.R.id.top;
import static com.thenewboston.memegen.R.id.topPanel;
import static com.thenewboston.memegen.R.id.topTextInput;

public class MainActivity extends ActionBarActivity {

    EditText topTextInput;
    EditText bottomTextInput;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }





    public void onImageGalleryClicked(View v) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String pictureDirectoryPath = pictureDirectory.getPath();
        Uri data = Uri.parse(pictureDirectoryPath);
        photoPickerIntent.setDataAndType(data, "image/*");
        startActivityForResult(photoPickerIntent, IMAGE_GALLERY_REQUEST);


    }

    ImageView imgPicture;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {




        imgPicture = (ImageView) findViewById(R.id.imgPicture);
        if (resultCode == RESULT_OK) {
            if (requestCode == IMAGE_GALLERY_REQUEST) {
                Uri imageUri = data.getData();

                InputStream inputStream;
                try {
                    inputStream = getContentResolver().openInputStream(imageUri);

                    Bitmap image = BitmapFactory.decodeStream(inputStream);
                    imgPicture.setImageBitmap(image);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Unable to load image", Toast.LENGTH_LONG).show();
                }

            }
            EditText topTextInput = (EditText) findViewById(R.id.topTextInput);

            String top = topTextInput.getText().toString();

            TextView meme1 = (TextView) findViewById(R.id.meme1);

            meme1.setText(top);


            EditText bottomTextInput = (EditText) findViewById(R.id.bottomTextInput);

            String bottom = bottomTextInput.getText().toString();

            TextView meme2 = (TextView) findViewById(R.id.meme2);

            meme2.setText(bottom);

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

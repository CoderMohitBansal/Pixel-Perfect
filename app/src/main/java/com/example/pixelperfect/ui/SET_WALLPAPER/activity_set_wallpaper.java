package com.example.pixelperfect.ui.SET_WALLPAPER;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pixelperfect.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class activity_set_wallpaper extends AppCompatActivity {

    private static final String PREFS_KEY_IMAGE_URLS = "image_urls";
    private ImageView wallpaperImageView;
    private Button setWallpaper;
    private String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_wallpaper);

        setWallpaper = findViewById(R.id.set_wallpaper);
        wallpaperImageView = findViewById(R.id.wallpaperImageView); // Replace with the ID of your ImageView in the layout

        Intent intent = getIntent();
        imageUrl = intent.getStringExtra("image_url");

        // Load the image from the URL using Picasso library
        Picasso.get().load(imageUrl).into(wallpaperImageView);

        setWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SetWallpaperTask().execute();
            }
        });
    }

    // AsyncTask to set the wallpaper in the background thread
    private class SetWallpaperTask extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Void... voids) {
            try {
                // Download the image from the URL
                Bitmap bitmap = Picasso.get().load(imageUrl).get();

                // Set the downloaded image as wallpaper
                WallpaperManager.getInstance(getApplicationContext()).setBitmap(bitmap);
                addImageUrlToPreferences(imageUrl);

                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if (success) {
                Toast.makeText(getApplicationContext(), "Wallpaper set successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Failed to set wallpaper", Toast.LENGTH_SHORT).show();
            }
        }
        private void addImageUrlToPreferences(String imageUrl) {
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            Set<String> imageUrlSet = sharedPreferences.getStringSet(PREFS_KEY_IMAGE_URLS, new HashSet<>());
            imageUrlSet.add(imageUrl);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putStringSet(PREFS_KEY_IMAGE_URLS, imageUrlSet);
            editor.apply();
        }
    }
}

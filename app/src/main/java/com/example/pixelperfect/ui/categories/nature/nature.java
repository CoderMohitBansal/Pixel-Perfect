package com.example.pixelperfect.ui.categories.nature;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import com.example.pixelperfect.R;
import com.example.pixelperfect.ui.SET_WALLPAPER.activity_set_wallpaper;
import com.example.pixelperfect.ui.categories.space.GridAdapter;

public class nature extends AppCompatActivity {
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature);

        String[] imageUrls = {
                "https://images.pexels.com/photos/3225517/pexels-photo-3225517.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/1770809/pexels-photo-1770809.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/15286/pexels-photo.jpg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/3408744/pexels-photo-3408744.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/1761279/pexels-photo-1761279.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/2832034/pexels-photo-2832034.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/3224156/pexels-photo-3224156.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/2770933/pexels-photo-2770933.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/15379/pexels-photo.jpg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/3225529/pexels-photo-3225529.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/2406785/pexels-photo-2406785.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/3265460/pexels-photo-3265460.jpeg?auto=compress&cs=tinysrgb&w=600",
                // Add more image URLs as needed
        };

        gridView = findViewById(R.id.natureGrid);
        GridAdapter gridAdapter = new GridAdapter(this, imageUrls);
        gridView.setAdapter(gridAdapter);

        gridAdapter.setOnItemClickListener(new GridAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String imageUrl) {
                // Handle the click event here, e.g., show a toast with the image URL
                Intent intent = new Intent(getApplication(), activity_set_wallpaper.class);
                intent.putExtra("image_url", imageUrl);
                startActivity(intent);
            }
        });
    }
}
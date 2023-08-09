package com.example.pixelperfect.ui.categories.ocean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import com.example.pixelperfect.R;
import com.example.pixelperfect.ui.SET_WALLPAPER.activity_set_wallpaper;
import com.example.pixelperfect.ui.categories.space.GridAdapter;

public class ocean extends AppCompatActivity {
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocean);

        String[] imageUrls = {
                "https://images.pexels.com/photos/1533720/pexels-photo-1533720.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/1646311/pexels-photo-1646311.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/1439226/pexels-photo-1439226.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/2583833/pexels-photo-2583833.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=699.825&fit=crop&h=1133.05",
                "https://images.pexels.com/photos/2402995/pexels-photo-2402995.jpeg?auto=compress&cs=tinysrgb&h=566.525&fit=crop&w=633.175&dpr=1",
                "https://images.pexels.com/photos/2397652/pexels-photo-2397652.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/4666751/pexels-photo-4666751.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/2707645/pexels-photo-2707645.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/3410956/pexels-photo-3410956.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/1894350/pexels-photo-1894350.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/4751278/pexels-photo-4751278.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/4751263/pexels-photo-4751263.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/1667004/pexels-photo-1667004.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/1904849/pexels-photo-1904849.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/4797143/pexels-photo-4797143.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/4628404/pexels-photo-4628404.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/4940754/pexels-photo-4940754.jpeg?auto=compress&cs=tinysrgb&w=600",
                // Add more image URLs as needed
        };

        gridView = findViewById(R.id.oceanGrid);
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
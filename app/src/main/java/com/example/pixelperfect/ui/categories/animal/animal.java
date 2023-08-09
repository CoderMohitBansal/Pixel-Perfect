package com.example.pixelperfect.ui.categories.animal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import com.example.pixelperfect.R;
import com.example.pixelperfect.ui.SET_WALLPAPER.activity_set_wallpaper;
import com.example.pixelperfect.ui.categories.space.GridAdapter;

public class animal extends AppCompatActivity {
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        String[] imageUrls = {
                "https://images.pexels.com/photos/17811/pexels-photo.jpg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/1851164/pexels-photo-1851164.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/11760851/pexels-photo-11760851.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=699.825&fit=crop&h=1133.05",
                "https://images.pexels.com/photos/12715260/pexels-photo-12715260.jpeg?auto=compress&cs=tinysrgb&h=566.525&fit=crop&w=633.175&dpr=1",
                "https://images.pexels.com/photos/3493730/pexels-photo-3493730.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/1321524/pexels-photo-1321524.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/1181181/pexels-photo-1181181.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/3608263/pexels-photo-3608263.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/133459/pexels-photo-133459.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/1661179/pexels-photo-1661179.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/1405930/pexels-photo-1405930.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/3396657/pexels-photo-3396657.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/704454/pexels-photo-704454.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/568022/pexels-photo-568022.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/2313396/pexels-photo-2313396.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/3889695/pexels-photo-3889695.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/660266/pexels-photo-660266.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/674318/pexels-photo-674318.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/41315/africa-african-animal-cat-41315.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/3162755/pexels-photo-3162755.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/3656870/pexels-photo-3656870.jpeg?auto=compress&cs=tinysrgb&w=600",
                // Add more image URLs as needed
        };

        gridView = findViewById(R.id.animalGrid);
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
package com.example.pixelperfect.ui.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pixelperfect.R;
import com.example.pixelperfect.databinding.FragmentHomeBinding;
import com.example.pixelperfect.ui.SET_WALLPAPER.activity_set_wallpaper;
import com.example.pixelperfect.ui.categories.animal.animal;
import com.example.pixelperfect.ui.categories.nature.nature;
import com.example.pixelperfect.ui.categories.ocean.ocean;
import com.example.pixelperfect.ui.categories.space.space;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    TextView spaceButton;
    TextView natureButton;
    TextView oceanButton;
    TextView animalButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getActivity().getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            );
            getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        String[] imageUrls = {
                "https://images.pexels.com/photos/1211839/pexels-photo-1211839.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "https://images.pexels.com/photos/2724664/pexels-photo-2724664.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "https://images.pexels.com/photos/1647972/pexels-photo-1647972.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "https://images.pexels.com/photos/3617453/pexels-photo-3617453.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "https://images.pexels.com/photos/3387175/pexels-photo-3387175.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                // Add more image URLs as needed
        };
        RecyclerView monthRecyclerView = root.findViewById(R.id.monthRecyclerView);
        monthRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)); // Use requireContext() for the context
        MonthAdapter adapter = new MonthAdapter(imageUrls, new MonthAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Handle item click event here
                // For example, show a toast with the clicked item position
                // Get the clicked image URL
                String imageUrl = imageUrls[position];

                // Create an instance of the activity_set_wallpaper activity and pass the image URL as an extra
                Intent intent = new Intent(requireActivity(), activity_set_wallpaper.class);
                intent.putExtra("image_url", imageUrl);
                startActivity(intent);
            }
        });
        monthRecyclerView.setAdapter(adapter);

        spaceButton = root.findViewById(R.id.spaceTextView);
        spaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireActivity(), space.class);
                startActivity(intent);
            }
        });

        natureButton = root.findViewById(R.id.natureTextView);
        natureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireActivity(), nature.class);
                startActivity(intent);
            }
        });

        oceanButton = root.findViewById(R.id.oceanTextView);
        oceanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireActivity(), ocean.class);
                startActivity(intent);
            }
        });

        animalButton = root.findViewById(R.id.animalTextView);
        animalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireActivity(), animal.class);
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

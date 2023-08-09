package com.example.pixelperfect.ui.notifications;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pixelperfect.R;
import com.example.pixelperfect.databinding.FragmentNotificationsBinding;
import com.example.pixelperfect.ui.categories.space.GridAdapter;

import java.util.HashSet;
import java.util.Set;

public class NotificationsFragment extends Fragment {
    GridView gridView;
    private FragmentNotificationsBinding binding;
    private static final String PREFS_KEY_IMAGE_URLS = "image_urls";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Set<String> imageUrlSet = getImageUrlsFromPreferences();
        String[] imageUrlArray = imageUrlSet.toArray(new String[0]);

        gridView = root.findViewById(R.id.recentGrid);
        GridAdapter gridAdapter = new GridAdapter(requireContext(), imageUrlArray);
        gridView.setAdapter(gridAdapter);

        return root;
    }

    private Set<String> getImageUrlsFromPreferences() {
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        return sharedPreferences.getStringSet(PREFS_KEY_IMAGE_URLS, new HashSet<>());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

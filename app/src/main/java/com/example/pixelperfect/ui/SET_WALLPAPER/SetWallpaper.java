package com.example.pixelperfect.ui.SET_WALLPAPER;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pixelperfect.R;

public class SetWallpaper extends Fragment {

    private SetWallpaperViewModel mViewModel;

    public static SetWallpaper newInstance() {
        return new SetWallpaper();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_set_wallpaper, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SetWallpaperViewModel.class);
        // TODO: Use the ViewModel
    }

}
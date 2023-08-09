package com.example.pixelperfect.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pixelperfect.R;
import com.squareup.picasso.Picasso;

public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.ViewHolder> {
    private String[] localDataSet;
    private static OnItemClickListener itemClickListener; // Step 1: Remove 'static' from the declaration

    public interface OnItemClickListener { // Step 2: Add the item click listener interface
        void onItemClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.wallpaper);

            // Step 3: Set OnClickListener on the item view
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClickListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            itemClickListener.onItemClick(position);
                        }
                    }
                }
            });
        }

        public ImageView getImageView() {
            return imageView;
        }
    }

    public MonthAdapter(String[] dataSet, OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.month_recycler_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Picasso.get().load(localDataSet[position]).into(viewHolder.getImageView());
    }

    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}

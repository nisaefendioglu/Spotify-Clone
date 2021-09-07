package com.nisaefendioglu.spotifyclone.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.nisaefendioglu.spotifyclone.Data.HomeArtists;
import com.nisaefendioglu.spotifyclone.R;

import java.util.List;

public class ArtistsAdapter extends RecyclerView.Adapter<ArtistsAdapter.ArtistsViewHolder> {

    private final List<HomeArtists> artistList;

    private ViewGroup context;

    public ArtistsAdapter(List<HomeArtists> artistList) {
        this.artistList = artistList;
    }

    @NonNull
    @Override
    public ArtistsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;

        if (parent.getTag().toString().equals("topArtists")) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.artists_item, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_artists_item, parent, false);
        }

        context = parent;

        return new ArtistsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistsViewHolder holder, int position) {

        Glide.with(context.getContext())
                .load("https://64.media.tumblr.com/2ef3c0566f8d8be09381e200bd9a0b4c/tumblr_pboxmkphxT1u88rcgo5_500.jpg")
                .error(R.drawable.song_error_image)
                .circleCrop()
                .into(holder.artistImage);
        holder.artistName.setText(artistList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }

    class ArtistsViewHolder extends RecyclerView.ViewHolder {

        ImageView artistImage;
        TextView artistName;

        public ArtistsViewHolder(@NonNull View itemView) {
            super(itemView);

            if (context.getTag().equals("topArtists")) {
                artistImage = itemView.findViewById(R.id.artistImageView);
                artistName = itemView.findViewById(R.id.nameTextView);
            } else {
                artistImage = itemView.findViewById(R.id.favArtistImageView);
                artistName = itemView.findViewById(R.id.favArtistTextView);
            }
        }
    }
}

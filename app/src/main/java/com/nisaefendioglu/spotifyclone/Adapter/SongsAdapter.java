package com.nisaefendioglu.spotifyclone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.nisaefendioglu.spotifyclone.R;
import com.nisaefendioglu.spotifyclone.Data.HomeSongs;

import java.util.Arrays;
import java.util.List;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongsViewHolder> {

    private final List<HomeSongs> songList;

    private Context context;

    public SongsAdapter(HomeSongs[] songList) {
        this.songList = Arrays.asList(songList);
    }

    @NonNull
    @Override
    public SongsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.songs_item, parent, false);

        context = parent.getContext();

        return new SongsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongsViewHolder holder, int position) {
        Glide.with(context)
                .load("https://1.bp.blogspot.com/-OLrbHUBNKoQ/YPmZqZB4BSI/AAAAAAAACOQ/sj7f-FOmI20uieQyBbvK6yV7sWu_L7-BwCLcBGAsYHQ/s0/En_iyi-50-global.png")
                .transform(new RoundedCorners(25))
                .error(R.drawable.song_error_image)
                .into(holder.coverImage);
        holder.name.setText(songList.get(position).getSongName());
        holder.artist.setText(songList.get(position).getSongSinger());
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }


    static class SongsViewHolder extends RecyclerView.ViewHolder {

        public ImageView coverImage;
        public TextView name;
        public TextView artist;

        public SongsViewHolder(@NonNull View itemView) {
            super(itemView);

            coverImage = itemView.findViewById(R.id.artistImageView);
            name = itemView.findViewById(R.id.songNameTextView);
            artist = itemView.findViewById(R.id.artistNameTextView);
        }
    }
}

package com.nisaefendioglu.spotifyclone.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nisaefendioglu.spotifyclone.ArtistsAdapter;
import com.nisaefendioglu.spotifyclone.ArtistsModel;
import com.nisaefendioglu.spotifyclone.R;
import com.nisaefendioglu.spotifyclone.SongsAdapter;
import com.nisaefendioglu.spotifyclone.SongsModel;

import java.util.Arrays;

public class Home extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        RecyclerView topSongsRecycleView = view.findViewById(R.id.topSongsRecycleView);
        RecyclerView topSingersRecycleView = view.findViewById(R.id.topArtistsRecycleView);

        SongsModel[] songs = {
                new SongsModel(R.drawable.spotify_icon_green, "So Far Away", "Avenged Sevenfold"),
                new SongsModel(R.drawable.spotify_icon_green, "Ahora", "Yeika"),
                new SongsModel(R.drawable.spotify_icon_green, "It Was a Good Day", "Ice Cub"),
                new SongsModel(R.drawable.spotify_icon_green, "The Law", "Leonard Cohen"),
                new SongsModel(R.drawable.spotify_icon_green, "Lovely Day", "Bill Withers"),
        };

        ArtistsModel[] singers = {
                new ArtistsModel(R.drawable.spotify_icon_green, "Rihanna"),
                new ArtistsModel(R.drawable.spotify_icon_green, "Yeika"),
                new ArtistsModel(R.drawable.spotify_icon_green, "Ice Cub"),
                new ArtistsModel(R.drawable.spotify_icon_green, "Avenged Sevenfold"),
                new ArtistsModel(R.drawable.spotify_icon_green, "Blump"),
        };


        topSongsRecycleView.setAdapter(new SongsAdapter(songs));

        topSingersRecycleView.setAdapter(new ArtistsAdapter(Arrays.asList(singers)));


        topSongsRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        topSingersRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        return view;
    }
}
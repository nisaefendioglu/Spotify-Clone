package com.nisaefendioglu.spotifyclone;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class TopArtists extends Fragment {

    View view;
    ListView artistslistListView;
    final ArrayList<ArtistList> artistList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.top_artist, container, false);

        artistslistListView = view.findViewById(R.id.artistslistListView);


        artistList.add(new ArtistList("Drake",R.drawable.drake));
        artistList.add(new ArtistList("Dua Lipa",R.drawable.dualipa));
        artistList.add(new ArtistList("The Weeknd",R.drawable.theweeknd));
        artistList.add(new ArtistList("Taylor Swift",R.drawable.taylor));
        artistList.add(new ArtistList("Ariana Grande",R.drawable.ariana));
        artistList.add(new ArtistList("Rihanna",R.drawable.rihanna));
        artistList.add(new ArtistList("Drake",R.drawable.drake));
        artistList.add(new ArtistList("Dua Lipa",R.drawable.dualipa));
        artistList.add(new ArtistList("The Weeknd",R.drawable.theweeknd));
        artistList.add(new ArtistList("Taylor Swift",R.drawable.taylor));
        artistList.add(new ArtistList("Ariana Grande",R.drawable.ariana));
        artistList.add(new ArtistList("Rihanna",R.drawable.rihanna));

        ArtistAdapter mailAdapter = new ArtistAdapter(getActivity(), artistList);
        if (artistslistListView != null) {
            artistslistListView.setAdapter(mailAdapter);
        }
        return view;
    }

}

package com.nisaefendioglu.spotifyclone.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.nisaefendioglu.spotifyclone.Data.Artists;
import com.nisaefendioglu.spotifyclone.R;
import com.nisaefendioglu.spotifyclone.Services.Songs;

import java.util.ArrayList;

public class ArtistsFragment  extends Fragment  {
    private ArrayList<Artists> artists = new ArrayList<>();
    private ArrayList<String> artistNameList = new ArrayList<>();;
    private Songs songs;
    private RequestQueue q;
    private ArrayAdapter arrayAdapter;
    View view;
    ListView artistListView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.artists_fragment, container,false);

        artistListView = view.findViewById(R.id.Artist_listview);

        songs = new Songs(getContext());
        getArtistsForListView();

        arrayAdapter = new ArrayAdapter<>(
            getActivity(),
            R.layout.row_artist,
            artistNameList
        );


        return view;
    }

    private void getArtistsForListView(){
        songs.getTopArtists(() -> {
            artists = songs.getArtists();
            updateListView(artists);
        });
    }

    private void updateListView(ArrayList<Artists> a) {
        artists = a;
        for(Artists artist : a ){
            artistNameList.add(artist.getName());
        }
        if (artistListView != null) {
            artistListView.setAdapter(arrayAdapter);
            artistListView.setOnItemClickListener((parent, view, position, id) -> {
                String name = artistNameList.get(position);
            });
        }

    }
}

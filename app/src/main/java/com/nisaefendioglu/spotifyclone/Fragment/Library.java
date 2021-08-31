package com.nisaefendioglu.spotifyclone.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.nisaefendioglu.spotifyclone.LibraryAdapter;
import com.nisaefendioglu.spotifyclone.LibraryList;
import com.nisaefendioglu.spotifyclone.R;

import java.util.ArrayList;

public class Library extends Fragment {

    View view;
    ListView playlistListView;
    final ArrayList<LibraryList> libraryLists = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.library, container, false);

        playlistListView = view.findViewById(R.id.playlistListView);

        libraryLists.add(new LibraryList("Dance","Playlists","G",R.drawable.dance));
        libraryLists.add(new LibraryList("Hits","Playlists","G",R.drawable.hits));
        libraryLists.add(new LibraryList("Rap","Playlists","G",R.drawable.rap));
        libraryLists.add(new LibraryList("HipHop","Playlists","G",R.drawable.hiphop));
        libraryLists.add(new LibraryList("Love","Playlists","G",R.drawable.lovesong));
        libraryLists.add(new LibraryList("Happy","Playlists","G",R.drawable.happy));
        libraryLists.add(new LibraryList("Dance","Playlists","G",R.drawable.dance));
        libraryLists.add(new LibraryList("Hits","Playlists","G",R.drawable.hits));
        libraryLists.add(new LibraryList("Rap","Playlists","G",R.drawable.rap));
        libraryLists.add(new LibraryList("HipHop","Playlists","G",R.drawable.hiphop));
        libraryLists.add(new LibraryList("Love","Playlists","G",R.drawable.lovesong));
        libraryLists.add(new LibraryList("Happy","Playlists","G",R.drawable.happy));

        LibraryAdapter mailAdapter = new LibraryAdapter(getActivity(), libraryLists);
        if (playlistListView != null) {
            playlistListView.setAdapter(mailAdapter);
        }


        return view;
    }
}
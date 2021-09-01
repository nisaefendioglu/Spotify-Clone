package com.nisaefendioglu.spotifyclone.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nisaefendioglu.spotifyclone.LibraryAdapter;
import com.nisaefendioglu.spotifyclone.LibraryList;
import com.nisaefendioglu.spotifyclone.R;
import com.nisaefendioglu.spotifyclone.TopArtists;

import java.util.ArrayList;

public class Library extends Fragment {

    View view;
    ListView playlistListView;
    BottomNavigationView librarynav_view;
    LinearLayout playlistLinearLayout;

    final ArrayList<LibraryList> libraryLists = new ArrayList<>();
    Fragment fragment = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.library, container, false);
        playlistListView = view.findViewById(R.id.playlistListView);
        playlistLinearLayout = view.findViewById(R.id.playlistLinearLayout);
        libraryLists.add(new LibraryList("Liked Songs", "4,302 songs", R.drawable.liked));
        libraryLists.add(new LibraryList("Dance", "Playlists", R.drawable.dance));
        libraryLists.add(new LibraryList("Hits", "Playlists", R.drawable.hits));
        libraryLists.add(new LibraryList("Rap", "Playlists", R.drawable.rap));
        libraryLists.add(new LibraryList("HipHop", "Playlists", R.drawable.hiphop));
        libraryLists.add(new LibraryList("Love", "Playlists",  R.drawable.lovesong));
        libraryLists.add(new LibraryList("Happy", "Playlists",  R.drawable.happy));
        libraryLists.add(new LibraryList("Dance", "Playlists",  R.drawable.dance));
        libraryLists.add(new LibraryList("Hits", "Playlists", R.drawable.hits));
        libraryLists.add(new LibraryList("Rap", "Playlists", R.drawable.rap));
        libraryLists.add(new LibraryList("HipHop", "Playlists",  R.drawable.hiphop));
        libraryLists.add(new LibraryList("Love", "Playlists",  R.drawable.lovesong));
        libraryLists.add(new LibraryList("Happy", "Playlists",  R.drawable.happy));

        LibraryAdapter mailAdapter = new LibraryAdapter(getActivity(), libraryLists);
        if (playlistListView != null) {
            playlistListView.setAdapter(mailAdapter);
        }

        librarynav_view = view.findViewById(R.id.librarynav_view);
        librarynav_view.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.topartist:
                    fragment = new TopArtists();
                    playlistLinearLayout.setVisibility(View.INVISIBLE);
                    break;
                case R.id.playlist:
                    fragment = new Library();
                    break;

            }
            getFragmentManager().beginTransaction().replace(R.id.fragmentContainer2, fragment).commit();
            return true;
        });
        return view;
    }
}
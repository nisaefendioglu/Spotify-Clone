package com.nisaefendioglu.spotifyclone.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.nisaefendioglu.spotifyclone.Adapter.LibraryAdapter;
import com.nisaefendioglu.spotifyclone.Data.LibraryList;
import com.nisaefendioglu.spotifyclone.R;

import java.util.ArrayList;

public class PlaylistsFragment extends Fragment{

    View view;
    ListView playlistListView;
    LinearLayout playlistLinearLayout;

    final ArrayList<LibraryList> libraryLists = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.playlists_fragment, container, false);
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

        return view;
    }
}

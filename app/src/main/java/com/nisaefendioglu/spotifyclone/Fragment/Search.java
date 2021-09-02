package com.nisaefendioglu.spotifyclone.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.nisaefendioglu.spotifyclone.R;

public class Search extends Fragment {

    View view;
    ConstraintLayout search_layout;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.search_fragment,container,false);
        search_layout = view.findViewById(R.id.search_layout);
        return view;

    }
}
package com.nisaefendioglu.spotifyclone.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.nisaefendioglu.spotifyclone.R;

public class Home extends Fragment {

    View view;
    LinearLayout welcome_layout,heard_recently_layout;
    RecyclerView welcome_recycler,heard_recently_recycler;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment,container,false);
        welcome_layout = view.findViewById(R.id.welcome_layout);
        heard_recently_layout = view.findViewById(R.id.heard_recently_layout);
        welcome_recycler = view.findViewById(R.id.welcome_recycler);
        heard_recently_recycler = view.findViewById(R.id.heard_recently_recycler);
        return view;
    }
}

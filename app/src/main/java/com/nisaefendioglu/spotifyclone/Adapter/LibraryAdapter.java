package com.nisaefendioglu.spotifyclone.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nisaefendioglu.spotifyclone.Data.LibraryList;
import com.nisaefendioglu.spotifyclone.R;

import java.util.ArrayList;

public class LibraryAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<LibraryList> libraryArrayList;

    public LibraryAdapter(Activity activity, ArrayList<LibraryList> libraryArrayList) {

        this.mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.libraryArrayList = libraryArrayList;
    }

    @Override
    public int getCount() {
        return libraryArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return libraryArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = mInflater.inflate(R.layout.library_listview, null);
        TextView Name =  convertView.findViewById(R.id.playlistName);
        TextView musicContent = convertView.findViewById(R.id.playlistContent);
        ImageView imageView = convertView.findViewById(R.id.imageView);
        LibraryList music = libraryArrayList.get(position);
        Name.setText(music.getName());
        musicContent.setText(music.getMusic());
        imageView.setImageResource(music.getImage());
        return convertView;
    }
}
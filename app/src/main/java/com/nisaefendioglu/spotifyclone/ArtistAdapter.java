package com.nisaefendioglu.spotifyclone;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<ArtistList> mailArrayList;

    public ArtistAdapter(Activity activity, ArrayList<ArtistList> gmailArrayList) {

        this.mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mailArrayList = gmailArrayList;
    }

    @Override
    public int getCount() {
        return mailArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mailArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = mInflater.inflate(R.layout.library_artist_view, null);
        TextView Name =  convertView.findViewById(R.id.libraryArtistName);
        ImageView imageView = convertView.findViewById(R.id.libraryArtistCover);
        ArtistList artist = mailArrayList.get(position);
        Name.setText(artist.getName());
        imageView.setImageResource(artist.getImage());
        return convertView;
    }
}
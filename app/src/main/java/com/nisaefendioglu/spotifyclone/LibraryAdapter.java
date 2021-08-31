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

public class LibraryAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<LibraryList> mailArrayList;

    public LibraryAdapter(Activity activity, ArrayList<LibraryList> gmailArrayList) {

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

        convertView = mInflater.inflate(R.layout.library_listview, null);
        TextView mailName =  convertView.findViewById(R.id.playlistName);
        TextView mailContent = convertView.findViewById(R.id.playlistContent);
        ImageView imageView = convertView.findViewById(R.id.imageView);
        LibraryList mail = mailArrayList.get(position);
        mailName.setText(mail.getName());
        mailContent.setText(mail.getMail());
        imageView.setImageResource(mail.getImage());
        return convertView;
    }
}
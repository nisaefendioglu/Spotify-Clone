package com.nisaefendioglu.spotifyclone.Data;


public class LibraryList {
    private String name;
    private String music;
    private int image;

    public LibraryList(String name, String music, int image) {
        this.name = name;
        this.music = music;
        this.image = image;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

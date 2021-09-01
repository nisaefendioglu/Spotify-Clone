package com.nisaefendioglu.spotifyclone;

public class ArtistList {
    private String name;
    private int image;

    public ArtistList(String name, int image) {
        this.name = name;
        this.image = image;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}

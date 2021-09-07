package com.nisaefendioglu.spotifyclone.Data;

public class HomeSongs {

    private int songCover;
    private String songName;
    private String songSinger;

    public HomeSongs(int songCover, String songName, String songSinger) {
        this.songCover = songCover;
        this.songName = songName;
        this.songSinger = songSinger;
    }

    public int getSongCover() {
        return songCover;
    }

    public void setSongCover(int songCover) {
        this.songCover = songCover;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongSinger() {
        return songSinger;
    }

    public void setSongSinger(String songSinger) {
        this.songSinger = songSinger;
    }
}

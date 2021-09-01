package com.nisaefendioglu.spotifyclone;

public class Artists {
    private String name ;
    private String id;
    private int followers;
    private int popularity;

    public Artists() {
    }

    public Artists(String name) {
        this.name = name;
    }

    public Artists(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Artists(String name, String id, int followers) {
        this.name = name;
        this.id = id;
        this.followers = followers;
    }

    public Artists(String name, String id, int followers, int popularity) {
        this.name = name;
        this.id = id;
        this.followers = followers;
        this.popularity = popularity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

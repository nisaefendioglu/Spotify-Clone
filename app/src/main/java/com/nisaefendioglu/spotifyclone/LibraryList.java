package com.nisaefendioglu.spotifyclone;


public class LibraryList {
    private String name;
    private String mail;
    private String mailNames;
    private int image;

    public LibraryList(String name, String mail, String mailNames, int image) {
        this.name = name;
        this.mail = mail;
        this.mailNames = mailNames;
        this.image = image;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getMailNames() {
        return mailNames;
    }

    public void setMailNames(String mailNames) {
        this.mailNames = mailNames;
    }
}

package com.example.enotita_4_7;

public class Recipe {

    private String recTitle;
    private String recDescription;
    private int imgid;

    public Recipe() {

    }

    public Recipe(String recTitle, String recDescription, int imgid) {
        this.recTitle = recTitle;
        this.recDescription = recDescription;
        this.imgid = imgid;
    }

    public String getRecTitle() {
        return recTitle;
    }

    public void setRecTitle(String recTitle) {
        this.recTitle = recTitle;
    }

    public String getRecDescription() {
        return recDescription;
    }

    public void setRecDescription(String recDescription) {
        this.recDescription = recDescription;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
}

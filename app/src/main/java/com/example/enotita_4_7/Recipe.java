package com.example.enotita_4_7;

public class Recipe {

    private int id;
    private String recTitle;
    private String recDescription;
    private String Img;

    public Recipe() {

    }

    public Recipe(String recTitle, String recDescription, String Img) {
        this.recTitle = recTitle;
        this.recDescription = recDescription;
        this.Img = Img;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

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

    public String getImg() {return Img;}

    public void setImg(String img) {this.Img = img;}

}

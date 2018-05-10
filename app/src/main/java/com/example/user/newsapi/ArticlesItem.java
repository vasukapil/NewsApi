package com.example.user.newsapi;

/**
 * Created by user on 09-May-18.
 */

public class ArticlesItem {

    private String image;
    private String title;
    private String description;
    private  String url;

    public ArticlesItem() {
        super();
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }


}

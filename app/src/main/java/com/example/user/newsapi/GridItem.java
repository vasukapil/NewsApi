package com.example.user.newsapi;

/**
 * Created by user on 10-May-18.
 */

public class GridItem {

    public GridItem()
    {
        super();
    }
    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    private String image;
    private String title;
    private String id;
}

package com.example.brandshoesapp.model;

import java.io.Serializable;

public class CategoryModel implements Serializable {
    String name;
    String type;
    String img_url;

    public CategoryModel() {
    }

    public CategoryModel(String name, String type, String img_url) {
        this.name = name;
        this.type = type;
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}

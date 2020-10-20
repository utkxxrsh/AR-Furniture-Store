package com.example.furnished.model;

public class popularfur {
    String name;
    String price;
    Integer imgageurl;

    public popularfur(String name, String price, Integer imgageurl) {
        this.name = name;
        this.price = price;
        this.imgageurl = imgageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getImgageurl() {
        return imgageurl;
    }

    public void setImgageurl(Integer imgageurl) {
        this.imgageurl = imgageurl;
    }
}

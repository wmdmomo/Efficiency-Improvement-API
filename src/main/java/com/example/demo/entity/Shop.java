package com.example.demo.entity;

import java.util.List;


public class Shop {

    private int id;
    private String name;
    private Float rating;
    private Integer order;
    private Integer premium;
    private String flavors;
    private String img;
//    private Restaurant restaurants;

    private List<Act> act;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getOrder() {
        return order;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Float getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Act> getAct() {
        return act;
    }

    public void setAct(List<Act> act) {
        this.act = act;
    }

//    public Restaurant getRestaurants() {
//        return restaurants;
//    }
//
//    public void setRestaurants(Restaurant restaurants) {
//        this.restaurants = restaurants;
//    }
        public void setFlavors(String flavors) {
        this.flavors = flavors;
    }

    public void setPremium(Integer premium) {
        this.premium = premium;
    }

    public Integer getPremium() {
        return premium;
    }

    public String getFlavors() {
        return flavors;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }
}

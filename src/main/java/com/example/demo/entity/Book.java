package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //也要加
    private Integer id;
    private String name;
    private String detail;
    private String quote;
    private String img;

    public String getDetail() {
        return detail;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getQuote() {
        return quote;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}

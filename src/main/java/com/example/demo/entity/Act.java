package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Act {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //也要加
    private int id;
    private String action;
    private String icon;
    private Integer resid;
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getResid() {
        return resid;
    }

    public String getAction() {
        return action;
    }

    public String getIcon() {
        return icon;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setResid(Integer res_id) {
        this.resid = res_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

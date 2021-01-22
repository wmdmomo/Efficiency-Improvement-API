package com.example.demo.entity.applets;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //也要加
    private Integer id;
    private String name;
    private  Integer bud;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getBud() {
        return bud;
    }

    public void setBud(Integer bud) {
        this.bud = bud;
    }
}

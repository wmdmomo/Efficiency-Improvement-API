package com.example.demo.entity.applets;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Monall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //也要加
    private Integer id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM",timezone = "GMT+08")
    private Date time;
    private Integer pay;
    private Integer earn;

    public Integer getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEarn() {
        return earn;
    }

    public Integer getPay() {
        return pay;
    }

    public void setEarn(Integer earn) {
        this.earn = earn;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }
}

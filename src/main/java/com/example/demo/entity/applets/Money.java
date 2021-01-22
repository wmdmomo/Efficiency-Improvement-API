package com.example.demo.entity.applets;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Money {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //也要加
    private Integer id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+08")
    private Date time;
    private float money;
    private  Integer flag;
    private Integer tag;
    private String remark;
    private String usr;
    private String year;
    private String month;
    private String day;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public Integer getFlag() {
        return flag;
    }

    public Date getTime() {
        return time;
    }

    public float getMoney() {
        return money;
    }

    public String getRemark() {
        return remark;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}


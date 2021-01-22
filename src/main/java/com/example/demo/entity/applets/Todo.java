package com.example.demo.entity.applets;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //也要加
    private Integer id;
    private String name;
    private String detail;
    private Integer flag;
    private Integer tag;

    //    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+08")
    private Date time;

    public Date getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFlag() {
        return flag;
    }

    public String getDetail() {
        return detail;
    }

    public Integer getTag() {
        return tag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}

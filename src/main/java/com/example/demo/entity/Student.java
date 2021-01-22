package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id //一定要加，然后你数据库里的表是什么名字，上面的class就是什么名字
    @GeneratedValue(strategy = GenerationType.IDENTITY) //也要加
    private Integer id;
    private String name;
    private String gender;
    private String tel;

    public void setName(String name){
        this.name=name;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public void setTel(String tel){
        this.tel=tel;
    }
    //这里的get 这些方法，到后面返回数据时会用到
    public Integer getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
    public String getTel(){return tel;}
}

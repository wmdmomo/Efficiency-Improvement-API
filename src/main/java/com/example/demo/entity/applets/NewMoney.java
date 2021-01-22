package com.example.demo.entity.applets;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class NewMoney {
    private float income;
    private float expenditure;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+08")
    private Date date;
    private List<Money> details;


    public float getExpenditure() {
        return expenditure;
    }

    public float getIncome() {
        return income;
    }

    public void setExpenditure(float expenditure) {
        this.expenditure = expenditure;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public List<Money> getDetails() {
        return details;
    }

    public void setDetails(List<Money> details) {
        this.details = details;
    }
}

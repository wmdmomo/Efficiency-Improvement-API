package com.example.demo.entity.applets;

import java.util.List;

public class TotalMoney {
    private float all_income;
    private float all_exp;
    List<NewMoney> newMoneyList;

    public float getAll_exp() {
        return all_exp;
    }

    public float getAll_income() {
        return all_income;
    }

    public List<NewMoney> getNewMoneyList() {
        return newMoneyList;
    }

    public void setAll_exp(float all_exp) {
        this.all_exp = all_exp;
    }

    public void setAll_income(float all_income) {
        this.all_income = all_income;
    }

    public void setNewMoneyList(List<NewMoney> newMoneyList) {
        this.newMoneyList = newMoneyList;
    }
}

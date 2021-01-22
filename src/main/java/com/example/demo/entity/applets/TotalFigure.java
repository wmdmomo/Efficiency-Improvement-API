package com.example.demo.entity.applets;

import java.util.List;

public class TotalFigure {
    private float in_money;
    private float exp_money;
    List<TagMoney> incomeList;
    List<TagMoney> expList;

    public float getExp_money() {
        return exp_money;
    }

    public float getIn_money() {
        return in_money;
    }

    public void setExp_money(float exp_money) {
        this.exp_money = exp_money;
    }

    public void setIn_money(float in_money) {
        this.in_money = in_money;
    }

    public List<TagMoney> getExpList() {
        return expList;
    }

    public List<TagMoney> getIncomeList() {
        return incomeList;
    }

    public void setExpList(List<TagMoney> expList) {
        this.expList = expList;
    }

    public void setIncomeList(List<TagMoney> incomeList) {
        this.incomeList = incomeList;
    }
}

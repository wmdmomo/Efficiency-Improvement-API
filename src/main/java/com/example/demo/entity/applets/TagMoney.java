package com.example.demo.entity.applets;

import java.util.List;

public class TagMoney {
    private int tag;
    private float val;
    private List<Money> details;

    public float getVal() {
        return val;
    }

    public void setVal(float val) {
        this.val = val;
    }

    public void setDetails(List<Money> details) {
        this.details = details;
    }

    public List<Money> getDetails() {
        return details;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getTag() {
        return tag;
    }
}

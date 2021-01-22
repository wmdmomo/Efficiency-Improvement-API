package com.example.demo.service;

import com.example.demo.entity.applets.NewMoney;
import com.example.demo.entity.applets.TagMoney;
import com.example.demo.entity.applets.TotalFigure;
import com.example.demo.entity.applets.TotalMoney;

import java.util.List;

public interface MoneyService {
    List<NewMoney> getAll(String year, String month, String usr);
    TotalMoney getTotal(String year, String month, String usr);
    List<TagMoney> getFigure(String year, String month, String usr,int flag);
    TotalFigure getTotalFigure(String year, String month, String usr);
}

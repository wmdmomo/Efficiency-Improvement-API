package com.example.demo.service;

import com.example.demo.entity.MenuIn;

import java.util.List;

public interface BarService {
    List<MenuIn> getMenu(Integer resid);
}

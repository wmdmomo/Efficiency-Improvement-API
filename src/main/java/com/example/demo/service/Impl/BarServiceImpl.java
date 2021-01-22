package com.example.demo.service.Impl;

import com.example.demo.Dao.FoodDao;
import com.example.demo.Dao.MenuDao;
import com.example.demo.entity.Food;
import com.example.demo.entity.Menu;
import com.example.demo.entity.MenuIn;
import com.example.demo.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BarServiceImpl implements BarService {
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private FoodDao foodDao;
    @Override
    public List<MenuIn> getMenu(Integer resid) {
        List<MenuIn> menuInList=new ArrayList<>();
        List<Menu> menuList=new ArrayList<>();
        menuList=menuDao.findByResid(resid);
        Menu menu=new Menu();
        for(int i=0;i<menuList.size();i++){
            MenuIn menuIn=new MenuIn();
            menu=menuList.get(i);
            menuIn.setId(menu.getId());
            menuIn.setName(menu.getName());
            menuIn.setDes(menu.getDes());
            menuIn.setIcon(menu.getIcon());
            menuIn.setDes(menu.getDes());
            List<Food> foodList=new ArrayList<>();
            foodList=foodDao.findByMenuid(menu.getId());
            menuIn.setFoodList(foodList);
            menuInList.add(menuIn);
        }

        return menuInList;
    }
}

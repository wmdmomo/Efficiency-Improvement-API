package com.example.demo.service.Impl;

import com.example.demo.Dao.ActDao;
import com.example.demo.Dao.RestDao;
import com.example.demo.entity.Act;
import com.example.demo.entity.Restaurant;
import com.example.demo.entity.Shop;
import com.example.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private RestDao restDao;
    @Autowired
    private ActDao actDao;
    @Override
    public List<Shop> getAll() {

        List<Shop> shopList=new ArrayList<>();
        List<Restaurant> restaurantList;
        restaurantList=(List)restDao.findAll();
        for(int i=0;i<restaurantList.size();i++){
            List<Act> actList=new ArrayList<>();
            Shop shop=new Shop();
            Restaurant restaurant;
            restaurant=restaurantList.get(i);
            shop.setId(restaurant.getId());
            shop.setName(restaurant.getName());
            shop.setRating(restaurant.getRating());
            shop.setOrder(restaurant.getOrder());
            shop.setPremium(restaurant.getPremium());
            shop.setFlavors(restaurant.getFlavors());
            shop.setImg(restaurant.getImg());
//            shop.setRestaurants(restaurant);
            actList=actDao.findByResid(restaurant.getId());
            shop.setAct(actList);
            shopList.add(shop);
        }
        return shopList;
    }
}

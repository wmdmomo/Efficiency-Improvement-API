package com.example.demo.Dao;

import com.example.demo.entity.Food;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodDao extends CrudRepository<Food,Integer> {
    List<Food> findByMenuid(Integer id);
}

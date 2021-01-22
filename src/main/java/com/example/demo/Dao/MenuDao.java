package com.example.demo.Dao;

import com.example.demo.entity.Menu;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuDao extends CrudRepository<Menu,Integer> {
    List<Menu> findByResid(Integer resid);
}

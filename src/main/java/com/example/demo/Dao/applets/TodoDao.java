package com.example.demo.Dao.applets;

import com.example.demo.entity.applets.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface TodoDao extends CrudRepository<Todo,Integer> {
    List<Todo> findByTimeAndTagAndName (Date time,Integer tag,String name);
}

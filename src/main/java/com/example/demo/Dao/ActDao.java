package com.example.demo.Dao;

import com.example.demo.entity.Act;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActDao extends CrudRepository<Act,Integer> {
    List<Act> findByResid(Integer resid);
}

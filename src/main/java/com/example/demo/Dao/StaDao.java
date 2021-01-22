package com.example.demo.Dao;

import com.example.demo.entity.State;
import org.springframework.data.repository.CrudRepository;

public interface StaDao extends CrudRepository<State,Integer> {
}

package com.example.demo.Dao.applets;

import com.example.demo.entity.applets.Bud;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BudDao extends CrudRepository<Bud,Integer> {
    List<Bud> findByName (String name);
}

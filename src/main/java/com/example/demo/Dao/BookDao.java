package com.example.demo.Dao;

import com.example.demo.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookDao extends CrudRepository<Book,Integer> {
}

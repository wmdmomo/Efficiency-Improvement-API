package com.example.demo.Dao;
import com.example.demo.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface UsrDao extends CrudRepository<Student,Integer> {
}

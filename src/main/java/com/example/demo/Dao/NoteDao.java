package com.example.demo.Dao;

import com.example.demo.entity.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface NoteDao extends CrudRepository<Note,Integer> {
    List<Note> findByTimeAndAndFlag(Date time,Integer flag);
}

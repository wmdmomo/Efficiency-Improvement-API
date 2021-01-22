package com.example.demo.Dao.applets;

import com.example.demo.entity.applets.Money;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface MoneyDao extends CrudRepository<Money, Integer> {
    List<Money> findByYearAndMonthAndUsrOrderByDayDescIdDesc(String year,
                                                             String month,
                                                             String usr);

    List<Money> findByYearAndMonthAndUsrAndFlagOrderByTagAscIdDesc(String year,
                                                            String month,
                                                            String usr,int flag);
}


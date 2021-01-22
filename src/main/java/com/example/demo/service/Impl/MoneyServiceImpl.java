package com.example.demo.service.Impl;

import com.example.demo.Dao.applets.MoneyDao;
import com.example.demo.entity.applets.*;
import com.example.demo.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MoneyServiceImpl implements MoneyService {
    @Autowired
    private MoneyDao moneyDao;

    @Override
    public List<NewMoney> getAll(String year, String month, String usr) {
        List<Money> monies;
        monies = moneyDao.findByYearAndMonthAndUsrOrderByDayDescIdDesc(year, month, usr);

        List<NewMoney> moneyList = new ArrayList<>();
        if(monies.isEmpty()) return moneyList;
//        先把第一个加入到数组中
        Money mm=monies.get(0);
        String day_start = mm.getDay();
        NewMoney newMoney = new NewMoney();
        newMoney.setDate(mm.getTime());
        List<Money> monies1 = new ArrayList<>();
        monies1.add(mm);
        newMoney.setDetails(monies1);
        if(mm.getFlag()==0){
            newMoney.setExpenditure(mm.getMoney());
            newMoney.setIncome(0);
        }else{
            newMoney.setExpenditure(0);
            newMoney.setIncome(mm.getMoney());
        }
        moneyList.add(newMoney);

//        从index=1开始
        for (int i = 1; i < monies.size(); i++) {
            Money money = monies.get(i);
            String day = money.getDay();
            if (day.equals(day_start)) {
//                跟前一个天数是相同的，要添加到前一个的details里面去,钱也要添加
                NewMoney nn=moneyList.get(moneyList.size() - 1);
                float in=nn.getIncome();
                float out=nn.getExpenditure();
                if(money.getFlag()==0){
                    nn.setExpenditure(money.getMoney()+out);
                }else{
                    nn.setIncome(money.getMoney()+in);
                }
                nn.getDetails().add(money);
            } else {
//                新建一个对
                day_start = day;
                NewMoney newMoneys = new NewMoney();
                newMoneys.setDate(money.getTime());
                List<Money> monies_ = new ArrayList<>();
                monies_.add(money);
                newMoneys.setDetails(monies_);
                if(money.getFlag()==0){
                    newMoneys.setExpenditure(money.getMoney());
                    newMoneys.setIncome(0);
                }else{
                    newMoneys.setExpenditure(0);
                    newMoneys.setIncome(money.getMoney());
                }
                moneyList.add(newMoneys);
            }
        }
        return moneyList;
    }

    @Override
    public TotalMoney getTotal(String year, String month, String usr) {
        float all_income=0;
        float all_exp=0;
        TotalMoney totalMoney=new TotalMoney();
        List<NewMoney> moneyList = new ArrayList<>();
        moneyList=getAll(year,month,usr);
        for(int i=0;i<moneyList.size();i++){
            float in=moneyList.get(i).getIncome();
            float out=moneyList.get(i).getExpenditure();
            all_income+=in;
            all_exp+=out;
        }
        totalMoney.setAll_exp(all_exp);
        totalMoney.setAll_income(all_income);
        totalMoney.setNewMoneyList(moneyList);
        return totalMoney;
    }

    @Override
    public List<TagMoney> getFigure(String year, String month, String usr,int flag) {
        List<Money> monies;
        monies = moneyDao.findByYearAndMonthAndUsrAndFlagOrderByTagAscIdDesc(year, month, usr,flag);
        List<TagMoney> moneyList = new ArrayList<>();
        if(monies.isEmpty()) return moneyList;
//        先把第一个加入到数组中
        Money mm=monies.get(0);
        int tag_start=mm.getTag();
        TagMoney tagMoney=new TagMoney();
        tagMoney.setTag(tag_start);
        tagMoney.setVal(mm.getMoney());
        List<Money> monies1 = new ArrayList<>();
        monies1.add(mm);
        tagMoney.setDetails(monies1);
        moneyList.add(tagMoney);

//        从index=1开始
        for (int i = 1; i < monies.size(); i++) {
            Money money = monies.get(i);
            int tag=money.getTag();
            if (tag==tag_start) {
//                跟前一个tag是相同的，要添加到前一个的details里面去,钱也要添加
                TagMoney nn=moneyList.get(moneyList.size() - 1);
                nn.setVal(nn.getVal()+money.getMoney());
                nn.getDetails().add(money);
            } else {
//                新建一个对
                tag_start = tag;
                TagMoney tagMoney1=new TagMoney();
                List<Money> monies_ = new ArrayList<>();
                monies_.add(money);
                tagMoney1.setTag(tag_start);
                tagMoney1.setDetails(monies_);
                tagMoney1.setVal(money.getMoney());
                moneyList.add(tagMoney1);
            }
        }
        return moneyList;
    }

    @Override
    public TotalFigure getTotalFigure(String year, String month, String usr) {
        float in=0;
        float out=0;
        TotalFigure totalFigure=new TotalFigure();
        List<TagMoney> tagMoneyList1=getFigure(year, month, usr, 1);
        for(int i=0;i<tagMoneyList1.size();i++){
            in+=tagMoneyList1.get(i).getVal();
        }
        List<TagMoney> tagMoneyList2=getFigure(year, month, usr, 0);
        for(int i=0;i<tagMoneyList2.size();i++){
            out+=tagMoneyList2.get(i).getVal();
        }
        totalFigure.setExp_money(out);
        totalFigure.setIn_money(in);
        totalFigure.setExpList(tagMoneyList2);
        totalFigure.setIncomeList(tagMoneyList1);

        return totalFigure;
    }
}

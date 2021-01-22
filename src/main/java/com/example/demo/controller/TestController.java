package com.example.demo.controller;

import com.example.demo.Dao.*;
import com.example.demo.Dao.applets.BudDao;
import com.example.demo.Dao.applets.MoneyDao;
import com.example.demo.Dao.applets.TodoDao;
import com.example.demo.Restful.RetCode;
import com.example.demo.Restful.RetResult;
import com.example.demo.entity.*;
import com.example.demo.entity.applets.Bud;
import com.example.demo.entity.applets.Money;
import com.example.demo.entity.applets.Todo;
import com.example.demo.service.BarService;
import com.example.demo.service.MoneyService;
import com.example.demo.service.ShopService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;



import java.util.*;

@RestController
@RequestMapping(value = "test")
@CrossOrigin
public class TestController {


    private UsrDao usrDao;
    private StaDao staDao;
    private BookDao bookDao;
    private NoteDao noteDao;
    private ShopService shopService;
    private BarService barService;
//   小程序相关
    private TodoDao todoDao;
    private MoneyService moneyService;
    private MoneyDao moneyDao;
    private BudDao budDao;

    public TestController(UsrDao usrDao, StaDao staDao, BookDao bookDao, NoteDao noteDao, ShopService shopService, BarService barService, TodoDao todoDao, MoneyService moneyService, MoneyDao moneyDao, BudDao budDao){
        this.staDao = staDao;
        this.bookDao = bookDao;
        this.noteDao=noteDao;
        this.shopService=shopService;
        this.barService=barService;
        this.todoDao=todoDao;
        this.moneyService=moneyService;
        this.moneyDao=moneyDao;
        this.budDao=budDao;

    }

    @GetMapping(value = "studentMan")

    public RetResult getStudent() {
        //这里比原来的接口返回数据多了code msg 返回RetResult结果 map 是因为data : student{...}
        Map<String, Object> test = new HashMap<String, Object>();
        test.put("student", usrDao.findAll());
        return new RetResult(RetCode.SUCCESS.getCode(), test);
    }

    //得到豆瓣前几的书 用页码按键来分页获取
    @GetMapping(value = "getTop")
    public RetResult getTop(@RequestParam Integer page) {
        Map<String, Object> res = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
//        @RequestParam(value = "page", required = false, defaultValue = "1") Integer page
        Integer start = 25 * page - 24;
        for (int i = 0; i < 25; i++) {
            arr.add(start);
            start=start+1;
        }
        res.put("books", bookDao.findAllById(arr));
        return new RetResult(RetCode.SUCCESS.getCode(), res);
    }
    //得到今天的记事本内容
    @GetMapping(value = "getNote")
    public RetResult getNote(@RequestParam(name="time") @DateTimeFormat(pattern = "yyyy-MM-dd") Date time)
    {
        Map<String, Object> res = new HashMap<>();
        res.put("noteList",noteDao.findByTimeAndAndFlag(time,0));
        res.put("doneList",noteDao.findByTimeAndAndFlag(time,1));
        res.put("undoList",noteDao.findByTimeAndAndFlag(time,2));
        return new RetResult(RetCode.SUCCESS.getCode(),res);
    }
    //未完成0 已完成1 已取消2
    @PostMapping(value = "addNote")
    public RetResult addNote(@RequestBody Note body){
        Map<String, Object> res = new HashMap<>();
        Note note=new Note();
        note.setTitle(body.getTitle());
        note.setTime(body.getTime());
        note.setFlag(0);
        noteDao.save(note);
        res.put("notes","ok");
        res.put("id",note.getId());
        return new RetResult(RetCode.SUCCESS.getCode(),res);
    }
    @PostMapping(value = "changeState")
    public RetResult changeState(@RequestParam Integer id,@RequestParam Integer flag){
        Map<String, Object> res = new HashMap<>();
        Optional<Note> note=noteDao.findById(id);
        if(note.isPresent()){
            Note note1=note.get();
            note1.setFlag(flag);
            noteDao.save(note1);
            res.put("change","ok");
        }else{
            res.put("change","The id is not exist");
        }

        return new RetResult(RetCode.SUCCESS.getCode(),res);
    }

    @PostMapping(value = "addStu")
    public String saveUsr(@RequestParam String name, @RequestParam String tel, @RequestParam String gender) {
        Student stu = new Student();
        stu.setName(name);
        stu.setGender(gender);
        stu.setTel(tel);
        usrDao.save(stu);
        return "suc";
    }

    @GetMapping(value = "getState")
    public Iterable<State> getState() {
        return staDao.findAll();
    }

    @GetMapping(value = "getShop")
    public RetResult getShop(){
        Map<String, Object> res = new HashMap<>();
        List<Shop> list=new ArrayList<>();
        list=shopService.getAll();
        res.put("restaurant",list);
        return new RetResult(RetCode.SUCCESS.getCode(), res);
    }

    @GetMapping(value = "getBar")
    public RetResult getBar(@RequestParam Integer id){
        Map<String, Object> res = new HashMap<>();
        List<MenuIn> list=new ArrayList<>();
        list=barService.getMenu(id);
        res.put("menu",list);
        return new RetResult(RetCode.SUCCESS.getCode(), res);
    }

//    小程序相关的代码
//    这段是拿到今天todolist的值
    @GetMapping(value = "getTodo")
    public RetResult getTodo(@DateTimeFormat(pattern = "yyyy-MM-dd") Date time,@RequestParam(name="name") String name)
    {
        Map<String, Object> res = new HashMap<>();
        res.put("p0List",todoDao.findByTimeAndTagAndName(time,0,name));
        res.put("p1List",todoDao.findByTimeAndTagAndName(time,1,name));
        res.put("p2List",todoDao.findByTimeAndTagAndName(time,2,name));
        return new RetResult(RetCode.SUCCESS.getCode(),res);
    }

    @PostMapping(value = "addTodo")
    public RetResult addTodo(@RequestBody Todo body){
        Map<String, Object> res = new HashMap<>();
        Todo todo=new Todo();
        todo.setName(body.getName());
        todo.setTime(body.getTime());
        todo.setDetail(body.getDetail());
        todo.setFlag(body.getFlag());
        todo.setTag(body.getTag());
        todoDao.save(todo);
        res.put("addTodo","ok");
        return new RetResult(RetCode.SUCCESS.getCode(),res);
    }

//    这里的功能 就是点进去当前是几月份 显示当前月份全部的消费记录
//    有修改 增加了整个月的收入支出 和每天的收入支出 新建了一个对象!!
    @GetMapping(value = "getMoney")
    public RetResult getMoney(@RequestParam(name="year") String year,@RequestParam(name="month") String month,@RequestParam(name="usr") String usr)
    {
//        Map<String, Object> res = new HashMap<>();
//        res.put("moneyList",moneyService.getAll(year, month, usr));
        return new RetResult(RetCode.SUCCESS.getCode(),moneyService.getTotal(year, month, usr));
    }

    @PostMapping(value = "addMoney")
    public RetResult addMoney(@RequestBody Money money){
        Map<String,Object> res=new HashMap<>();
        moneyDao.save(money);
        res.put("addMoney","ok");
        return new RetResult(RetCode.SUCCESS.getCode(),res);
    }
//    这里是图表那边申请的接口，返回收入一堆 支出一堆的数据 然后每堆数据之间 根据tag的不同进行汇总分类
    @GetMapping(value = "getFigure")
    public RetResult getFigure(@RequestParam(name="year") String year,@RequestParam(name="month") String month,@RequestParam(name="usr") String usr){
        return new RetResult(RetCode.SUCCESS.getCode(),moneyService.getTotalFigure(year, month, usr));
    }

    @GetMapping(value = "getBud")
    public RetResult getBud(@RequestParam(name="usr") String usr){
        Map<String, Object> res = new HashMap<>();
        res.put("usr",budDao.findByName(usr));
        return new RetResult(RetCode.SUCCESS.getCode(),res);
    }
    @PostMapping(value = "postBud")
    public RetResult postBud(@RequestParam(name="usr") String usr,@RequestParam(name="bud") Integer budget){
        List<Bud> bud=budDao.findByName(usr);
        Map<String,Object> res=new HashMap<>();
        Bud bud1=bud.get(0);
        bud1.setBud(budget);
        budDao.save(bud1);
        res.put("change","ok");
        return new RetResult(RetCode.SUCCESS.getCode(),res);
    }


}

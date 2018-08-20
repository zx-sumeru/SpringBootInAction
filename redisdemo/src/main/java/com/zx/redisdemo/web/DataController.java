package com.zx.redisdemo.web;

import com.zx.redisdemo.dao.PersonDao;
import com.zx.redisdemo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhangXu
 * @date 2018/8/20 下午11:30
 */
@RestController
public class DataController {

    @Autowired
    PersonDao personDao;

    @RequestMapping("/set")
    public Person set(){
        Person person = new Person("1","wyf",32);
        personDao.save(person);
        personDao.stringRedisTemplateDemo();
        return personDao.getPerson(person.getId());
    }

    @RequestMapping("/save/{id}/{name}/{age}")
    public Person save(@PathVariable String id,@PathVariable String name,@PathVariable Integer age){
        return personDao.save(new Person(id,name,age));
    }

    @RequestMapping("/getstr/{key}")
    public String getstr(@PathVariable String key){
        return personDao.getString(key);
    }

    @RequestMapping("/getPerson/{id}")
    public Person getPerson(@PathVariable String id){
        return personDao.getPerson(id);
    }
}

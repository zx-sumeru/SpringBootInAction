package com.zx.mongodemo.controller;

import com.zx.mongodemo.dao.PersonRepository;
import com.zx.mongodemo.domain.Location;
import com.zx.mongodemo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author ZhangXu
 * @date 2018/8/20 下午10:08
 */
@RestController
public class DataController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/save")
    public Person save(){
        Person person = new Person("wyf",32);
        Collection<Location> locations = new LinkedHashSet<>();
        locations.add(new Location("sh","2009"));
        locations.add(new Location("hf","2010"));
        locations.add(new Location("gz","2011"));
        locations.add(new Location("mas","2012"));
        person.setLocations(locations);
        return personRepository.save(person);
    }

    @RequestMapping("/q1")
    public Person q1(String name){
        return personRepository.findByName(name);
    }

    @RequestMapping("/q2")
    public List<Person> q2(Integer age){
        return personRepository.withQueryFindByAge(age);
    }
}

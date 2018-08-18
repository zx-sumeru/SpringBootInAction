package com.zx.ch85cache.service;

import com.zx.ch85cache.entity.Person;
import com.zx.ch85cache.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author ZhangXu
 * @date 2018/8/18 下午11:49
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    PersonRepository personRepository;

    @Override
    @CachePut(value = "people",key = "#person.id")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("为id、key为" + p.getId() + " 做了缓存");
        return p;
    }

    @Override
    @CacheEvict
    public void remove(Person person) {
        System.out.println("删除缓存");
        personRepository.delete(person);
    }

    @Override
    @Cacheable(value = "people", key = "#person.id")
    public Person findOne(Person person) {

        return null;
    }
}

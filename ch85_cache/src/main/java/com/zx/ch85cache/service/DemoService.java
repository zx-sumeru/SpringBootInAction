package com.zx.ch85cache.service;

import com.zx.ch85cache.entity.Person;

/**
 * @author ZhangXu
 * @date 2018/8/18 下午11:48
 */
public interface DemoService {

    Person save(Person person);

    void remove(Person person);

    Person findOne(Person person);
}

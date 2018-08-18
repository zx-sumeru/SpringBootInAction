package com.zx.ch8_4.service;

import com.zx.ch8_4.entity.Person;

/**
 * @author ZhangXu
 * @date 2018/8/18 下午10:17
 */
public interface DemoService {

    Person savePersonWithRollBack(Person person);

    Person savePersonWithoutRollBack(Person person);
}

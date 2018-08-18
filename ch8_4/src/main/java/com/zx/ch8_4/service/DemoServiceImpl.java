package com.zx.ch8_4.service;

import com.zx.ch8_4.entity.Person;
import com.zx.ch8_4.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ZhangXu
 * @date 2018/8/18 下午10:18
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    PersonRepository personRepository;

    @Override
    @Transactional(rollbackFor = IllegalArgumentException.class)
    public Person savePersonWithRollBack(Person person) {
        Person person1 = personRepository.save(person);
        if (person1.getName().equals("wangyunfei")){
            throw new IllegalArgumentException("wangyunfei 已存在， 数据将回滚！");
        }
        return person1;
    }

    @Override
    @Transactional(noRollbackFor = IllegalArgumentException.class)
    public Person savePersonWithoutRollBack(Person person) {
        Person person1 = personRepository.save(person);

        if (person1.getName().equals("wangyunfei")){
            throw new IllegalArgumentException("wangyunfei 已存在，但数据不会回滚！");
        }
        return person1;
    }
}

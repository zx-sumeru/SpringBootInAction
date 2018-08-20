package com.zx.redisdemo.dao;

import com.zx.redisdemo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author ZhangXu
 * @date 2018/8/20 下午10:40
 */
@Repository
public class PersonDao {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> stringValueOperations;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valueOperations;

    public void stringRedisTemplateDemo(){
        stringValueOperations.set("xx","yy");
    }

    public Person save(Person person){
        valueOperations.set(person.getId(),person);
        return (Person) valueOperations.get(person.getId());
    }

    public String getString(String key){
        return stringValueOperations.get(key);
    }

    public Person getPerson(String id){
        return (Person) valueOperations.get(id);
    }
}

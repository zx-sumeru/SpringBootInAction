package com.zx.mongodemo.dao;

import com.zx.mongodemo.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @author ZhangXu
 * @date 2018/8/20 下午10:06
 */
public interface PersonRepository extends MongoRepository<Person, String > {

    Person findByName(String name);

    @Query("{'age':?0}")
    List<Person> withQueryFindByAge(Integer age);
}

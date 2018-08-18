package com.zx.ch85cache.repository;

import com.zx.ch85cache.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ZhangXu
 * @date 2018/8/18 下午11:46
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}

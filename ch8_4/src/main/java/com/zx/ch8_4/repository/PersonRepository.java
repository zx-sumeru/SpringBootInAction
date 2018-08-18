package com.zx.ch8_4.repository;

import com.zx.ch8_4.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ZhangXu
 * @date 2018/8/18 下午10:15
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}

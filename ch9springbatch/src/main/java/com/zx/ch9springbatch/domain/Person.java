package com.zx.ch9springbatch.domain;

import javax.validation.constraints.Size;

/**
 * @author ZhangXu
 * @date 2018/8/22 下午9:43
 */
public class Person {

    @Size(max = 4,min = 1)
    private String name;

    private int age;

    private String nation;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

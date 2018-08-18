package com.zx.ch5.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author ZhangXu
 * @date 2018/8/15 下午8:51
 */

@Component
@ConfigurationProperties(prefix = "author")
@PropertySource("setting.properties")
public class AuthorSetting {

    private String name;
    private Long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}

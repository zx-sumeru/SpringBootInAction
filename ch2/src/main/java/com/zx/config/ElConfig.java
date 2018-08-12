package com.zx.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Zhang Xu
 * @date 2018/8/12 下午11:08
 */
@Configuration
@ComponentScan("com.zx.service")
@PropertySource("test.properties")
public class ElConfig {

    @Value("I love u")
    private String normal;

    //@Value("#{systemProperties['os.name]}")
    //private String osName;

    @Value("${book.name}")
    private String bookName;
}

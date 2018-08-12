package com.zx.main;

import com.zx.config.ElConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Zhang Xu
 * @date 2018/8/12 下午11:13
 */
public class ElMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig elConfig = applicationContext.getBean(ElConfig.class);
        applicationContext.close();
    }


}

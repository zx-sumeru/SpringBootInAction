package com.zx.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ZhangXu
 * @date 2018/8/13 下午8:59
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService awareService = applicationContext.getBean(AwareService.class);
        awareService.outputResult();;
        applicationContext.close();
    }
}

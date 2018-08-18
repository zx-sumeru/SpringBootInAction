package com.zx;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ZhangXu
 * @date 2018/8/15 下午10:32
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {

    public static final String MSG = "world";

    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

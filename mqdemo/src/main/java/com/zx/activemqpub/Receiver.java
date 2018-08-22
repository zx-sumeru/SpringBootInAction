package com.zx.activemqpub;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author ZhangXu
 * @date 2018/8/23 上午12:23
 */
@Component
public class Receiver {

    @JmsListener(destination = "my-destination")
    public void receiveMessage(String message) {
        System.err.println("接收到 ： " + message);
    }
}

package com.zx.activemqpub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhangXu
 * @date 2018/8/23 上午12:29
 */
@RestController
public class DemoController {

    @Autowired
    JmsTemplate jmsTemplate;

    @RequestMapping(value = "/test/{str}")
    public String test(@PathVariable("str") String str){
        jmsTemplate.send("test",new Msg(str));
        return str;
    }

    @JmsListener(destination = "test")
    public void rec(String message){
        System.err.println("test" + message);
    }
}

package com.zx.activemqpub;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author ZhangXu
 * @date 2018/8/23 上午12:20
 */
public class Msg implements MessageCreator {

    private String string = "test";

    public Msg() {
    }

    public Msg(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage(string);
    }
}

package com.zx;

/**
 * @author ZhangXu
 * @date 2018/8/15 下午10:36
 */
public class HelloService {

    private String msg;

    public String sayHello(){
        return "hello " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

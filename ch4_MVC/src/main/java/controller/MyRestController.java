package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.DemoService;

/**
 * @author ZhangXu
 * @date 2018/8/15 上午12:26
 */
@RestController
public class MyRestController {

    @Autowired
    DemoService demoService;

    @RequestMapping(value = "/testRest",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String testRest(){
        return demoService.sayHello();
    }
}

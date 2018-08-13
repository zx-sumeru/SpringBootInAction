package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZhangXu
 * @date 2018/8/13 下午11:47
 */
@Controller
public class HelloController {

    // TODO: by zx 2018/8/14 上午12:10 :: 无法正常访问

    @RequestMapping("/index")
    public String hello(){
        return "index";
    }
}

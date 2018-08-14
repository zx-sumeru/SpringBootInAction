package controller;

import domain.DemoPojo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZhangXu
 * @date 2018/8/14 下午10:28
 */
@Controller
public class AdviceController {

    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoPojo obj){
        throw new IllegalArgumentException("非常抱歉，参数有误/" + "ModelAttribute: " + msg);
    }
}

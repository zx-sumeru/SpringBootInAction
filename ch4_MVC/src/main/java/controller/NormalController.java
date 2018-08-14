package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.DemoService;

/**
 * @author ZhangXu
 * @date 2018/8/15 上午12:24
 */
@Controller
public class NormalController {

    @Autowired
    DemoService demoService;

    @RequestMapping("/normal")
    public String testPage(Model model){
        model.addAttribute("msg", demoService.sayHello());
        return "page";
    }
}

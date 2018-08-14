package controller;

import domain.DemoPojo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZhangXu
 * @date 2018/8/14 下午11:22
 */
@Controller
public class ConverterController {

    @RequestMapping(value = "/convert", produces = "application/x-wisely")
    @ResponseBody
    public DemoPojo convert(@RequestBody DemoPojo demoPojo){
        return demoPojo;
    }
}

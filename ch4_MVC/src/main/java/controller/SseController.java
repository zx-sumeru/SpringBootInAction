package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * @author ZhangXu
 * @date 2018/8/14 下午11:42
 */
@Controller
public class SseController {
    @RequestMapping(value = "/push", produces = "text/event-stream;charset=UTF-8")
    @ResponseBody
    public String push(){
        Random random = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Testing 1,2,3" + random.nextInt() + "\n\n";
    }
}

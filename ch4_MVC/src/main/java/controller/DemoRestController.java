package controller;

import domain.DemoPojo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhangXu
 * @date 2018/8/14 下午9:33
 */
@RestController
@RequestMapping("/rest")
public class DemoRestController {

    // TODO: by zx 2018/8/14 下午9:44 :: 如何保证方法一定会传递过来参数，不会导致obj为空？

    @RequestMapping(value = "/getjson", produces = {"application/json;cahrset=UTF-8"})
    public DemoPojo getJson(DemoPojo obj){
        return new DemoPojo(obj.getId()+1, obj.getName() + "yy");
    }

    @RequestMapping(value = "/getxml",produces = {"application/xml;charset=UTF-8"})
    public DemoPojo getxml(DemoPojo obj){
        return new DemoPojo( obj.getId() + 1, obj.getName() + "yy" ) ;
    }
}

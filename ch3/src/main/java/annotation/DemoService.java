package annotation;

import org.springframework.stereotype.Service;

/**
 * @author ZhangXu
 * @date 2018/8/13 下午10:30
 */
@Service
public class DemoService {

    public void outputResult(){
        System.out.println("组合注解获得bean");
    }
}

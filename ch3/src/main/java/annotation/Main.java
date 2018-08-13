package annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ZhangXu
 * @date 2018/8/13 下午10:31
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(Config.class);
        DemoService demoService = context.getBean(DemoService.class);
        demoService.outputResult();
        context.close();
    }
}

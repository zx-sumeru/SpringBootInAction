package conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ZhangXu
 * @date 2018/8/13 下午10:07
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(Config.class);
        ListService listService = context.getBean(ListService.class);
        System.out.println("os.name : " + context.getEnvironment().getProperty("os.name"));
        System.out.println(listService.showListCmd());
    }


}

package scheduled;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ZhangXu
 * @date 2018/8/13 下午9:42
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ScheduledConfig.class);
        context.close();
    }
}

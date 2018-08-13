package taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ZhangXu
 * @date 2018/8/13 下午9:26
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);

        AsyncTaskService service = context.getBean(AsyncTaskService.class);

        for (int i = 0; i < 10; i++) {
            service.executeAsyncTask(i);
            service.executeAsyncTaskPlus(i);
        }
        context.close();
    }

}

package taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author ZhangXu
 * @date 2018/8/13 下午9:24
 */
@Service
public class AsyncTaskService {

    @Async
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务 ： " + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("executeAsyncTaskPlus : " + i);
    }
}

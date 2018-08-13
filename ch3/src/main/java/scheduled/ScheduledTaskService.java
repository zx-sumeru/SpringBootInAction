package scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZhangXu
 * @date 2018/8/13 下午9:31
 */
@Service
public class ScheduledTaskService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("每个五秒执行一次 "  + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 47 21 ? * *" )
    public void fixTimeExecution(){
        System.out.println("fixTimeExecution " + dateFormat.format(new Date()));
    }
}

package conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZhangXu
 * @date 2018/8/13 下午10:04
 */
@Configuration
public class Config {

    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windowsListService(){
        return new WindowsListService();
    }

    @Bean
    @Conditional(MacCondition.class)
    public ListService macListService(){
        return new MacListService();
    }
}

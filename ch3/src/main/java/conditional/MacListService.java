package conditional;

/**
 * @author ZhangXu
 * @date 2018/8/13 下午10:10
 */
public class MacListService implements ListService {

    @Override
    public String showListCmd() {
        return "ls";
    }
}

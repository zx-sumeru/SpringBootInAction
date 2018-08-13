package conditional;

/**
 * @author ZhangXu
 * @date 2018/8/13 下午10:04
 */
public class WindowsListService implements ListService {

    @Override
    public String showListCmd() {
        return "dir";
    }
}

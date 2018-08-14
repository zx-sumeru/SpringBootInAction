package domain;

/**
 * @author ZhangXu
 * @date 2018/8/14 下午8:57
 */
public class DemoPojo {
    private Long id;
    private String name;

    public DemoPojo() {
        super();
    }

    public DemoPojo(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

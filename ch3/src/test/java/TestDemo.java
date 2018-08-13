import fortest.TestBean;
import fortest.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ZhangXu
 * @date 2018/8/13 下午10:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles("prod")
public class TestDemo {

    @Autowired
    private TestBean testBean;

    @Test
    public void prodBean(){
        String expected = "production profile";
        String actual = testBean.getContent();
        Assert.assertEquals(expected,actual);
    }
}

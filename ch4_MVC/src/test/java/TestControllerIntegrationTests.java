import config.MvcConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import service.DemoService;

/**
 * @author ZhangXu
 * @date 2018/8/15 上午12:08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class})
@WebAppConfiguration("src/main/resources")
public class TestControllerIntegrationTests {

    // TODO: by ZhangXu 2018/8/15 上午12:29 :: 学习熟练spring mvc的集成测试

    private MockMvc mockMvc;

    @Autowired
    private DemoService demoService;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    MockHttpSession session;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void testNormalController() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/normal"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("page"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/classes/views/page.jsp"))
                .andExpect(MockMvcResultMatchers.model().attribute("msg", demoService.sayHello()));
    }

    @Test
    public void testRestController() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/testRest"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string(demoService.sayHello()));
    }
}

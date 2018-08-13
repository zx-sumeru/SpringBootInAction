package com.zx.aware;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author ZhangXu
 * @date 2018/8/13 下午8:40
 */
@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware {

    private String beanName;
    private ResourceLoader loader;


    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void outputResult(){
        System.out.println("Bean 的名称为： " + beanName);
        Resource resource = loader.getResource("test.txt");
        try {
            System.out.println("ResourceLoader加载的文件内容为： "
                    // TODO: by zx 2018/8/13 下午9:03 :: Charset使用StandardCharsets的静态变量设置
                    + IOUtils.toString(resource.getInputStream(),StandardCharsets.UTF_8 ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author ZhangXu
 * @date 2018/8/14 下午10:55
 */
@Controller
public class UploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String upload(MultipartFile file){
        try {
            FileUtils.writeByteArrayToFile(
                    new File("/Users/andrewzh/Desktop/未命名文件夹/" + file.getOriginalFilename() ),
                    file.getBytes()
                    );
            return "ok";
            // TODO: by ZhangXu 2018/8/14 下午11:04 :: SpringBoot怎么设置字符编码过滤器？？？
        } catch (IOException e) {
            e.printStackTrace();
            return "wrong";
        }

    }
}

package messageconverter;

import domain.DemoPojo;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author ZhangXu
 * @date 2018/8/14 下午11:05
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<DemoPojo> {

    public MyMessageConverter() {
        super(new MediaType("application", "x-wisely", Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return DemoPojo.class.isAssignableFrom(clazz);
    }

    @Override
    protected DemoPojo readInternal(Class<? extends DemoPojo> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
        String[] tempArr = temp.split("-");
        return new DemoPojo(Long.valueOf(tempArr[0]), tempArr[1]);
    }

    @Override
    protected void writeInternal(DemoPojo demoPojo, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String out = "hello: " + demoPojo.getId() + "-" +demoPojo.getName();
        outputMessage.getBody().write(out.getBytes());
    }
}

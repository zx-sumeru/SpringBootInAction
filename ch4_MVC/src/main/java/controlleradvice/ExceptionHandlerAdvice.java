package controlleradvice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ZhangXu
 * @date 2018/8/14 下午10:17
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception e, WebRequest request){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", e.getMessage());
        return modelAndView;
    }

    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("msg", "额外信息");
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        //设置忽略id属性
        webDataBinder.setDisallowedFields("id");
    }
}

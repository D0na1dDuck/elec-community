package xyz.esp8266.community.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import xyz.esp8266.community.dto.ResultDTO;
import xyz.esp8266.community.exception.CustomizeErrorCode;
import xyz.esp8266.community.exception.CustomizeException;
import javax.servlet.http.HttpServletRequest;

// 该注解表示开启了全局异常的捕获
@ControllerAdvice
public class CustomizeExceptionHandler {
    // 捕获后统一异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    Object handle(HttpServletRequest request, Throwable e, Model model) {
        String contentType = request.getContentType();
        // 区分同步请求和异步请求
        if ("application/json".equals(contentType)) {
            // 教学视频中出现无法返回 json和页面两种形式，这里可以，视频中后用servlet处理
            if (e instanceof CustomizeException) {
                return ResultDTO.errorOf((CustomizeException) e);
            } else {
                return ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
            }
        } else {
            //错误页面跳转
            if (e instanceof CustomizeException) {
                model.addAttribute("message", e.getMessage());
            } else {
                model.addAttribute("message" ,CustomizeErrorCode.SYS_ERROR.getMessage());
            }
            return new ModelAndView("error");
        }
    }
}
// throw 自定义异常（枚举） -> 全局异常处理.异常处理器 -> 用户

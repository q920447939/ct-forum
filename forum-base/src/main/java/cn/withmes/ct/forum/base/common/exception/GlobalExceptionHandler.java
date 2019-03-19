package cn.withmes.ct.forum.base.common.exception;


import cn.withmes.ct.forum.base.common.utils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenyi
 * 统一异常处理
 * @date 2017/12/29
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(MyException.class)
    public R handleMyException(HttpServletRequest req, MyException e){
        R r = new R();
        r.put("code", e.getCode());
        r.put("msg", e.getMsg());
        r.put("detail",e.getMessage());
        r.put("url",req.getRequestURL().toString());
        return r;
    }
}

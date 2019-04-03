/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年04月03日
 */
package cn.withmes.forum.api.controller.exception;

/**
 * ClassName: GlobalExceptionHandler
 * @Description:
 * @author leegoo
 * @date 2019年04月03日
 */

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;

import cn.withmes.ct.forum.base.common.config.base.enums.ResultCode;
import cn.withmes.ct.forum.base.common.config.base.mode.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by qhong on 2018/5/28 15:51
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 登陆异常
     * @param req
     * @param e
     * @return
     * @throws AuthException
     */
    @ExceptionHandler(value = AuthException.class)
    @ResponseBody
    public ResponseData handleAuthException(HttpServletRequest req, AuthException e) throws AuthException {
        ResponseData r = new ResponseData();
        r.setCode(-1);
        r.setMessage(e.getMessage());
        logger.info("AuthException",e.getMessage());
        return r;
    }

    /**
     * 验证异常
     * @param req
     * @param e
     * @return
     * @throws MethodArgumentNotValidException
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseData handleMethodArgumentNotValidException(HttpServletRequest req, MethodArgumentNotValidException e) throws MethodArgumentNotValidException {
        ResponseData r = new ResponseData();
        BindingResult bindingResult = e.getBindingResult();
        StringBuffer errorMesssage  = new StringBuffer();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMesssage.append(fieldError.getDefaultMessage());
        }
        r.setCode(-1);
        r.setMessage(errorMesssage.toString());
        //logger.info("MethodArgumentNotValidException",e);
        return r;
    }

    /**
     * 全局异常
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value =BindException.class)
    @ResponseBody
    public ResponseData handleBindException(BindException e) throws BindException {
        // ex.getFieldError():随机返回一个对象属性的异常信息。如果要一次性返回所有对象属性异常信息，则调用ex.getAllErrors()
        FieldError fieldError = e.getFieldError();
        StringBuilder sb = new StringBuilder();
        sb.append(fieldError.getField()).append("=[").append(fieldError.getRejectedValue()).append("]")
                .append(fieldError.getDefaultMessage());
        // 生成返回结果
        ResponseData r = new ResponseData();
        r.setCode(-1);
        r.setMessage(fieldError.getDefaultMessage());
        logger.info("BindException", e);
        return r;
    }
}

/**
 * @Project:
 * @Author: liming
 * @Date: 2018年11月09日
 */
package cn.withmes.ct.forum.base.common.config.base.web.error;

import cn.withmes.ct.forum.base.common.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ClassName: MyExceptionHandler
 *
 * @author liming
 * @Description: 自定义异常返回错误页面
 * @date 2018年11月09日
 */
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(value = MyException.class)
    public String MyExceptionHandler() {
        return "error";
    }
}

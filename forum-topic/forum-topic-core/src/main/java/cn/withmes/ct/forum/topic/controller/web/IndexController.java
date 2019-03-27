/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年03月22日
 */
package cn.withmes.ct.forum.topic.controller.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName: IndexController
 *
 * @author leegoo
 * @Description:
 * @date 2019年03月22日
 */

@Controller
public class IndexController {

    @ApiOperation(value = "跳转到首页")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "home";
    }

    @ApiOperation(value = "跳转到主题")
    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public String topics() {
        return "topics";
    }




    @ApiOperation(value = "跳转到登陆")
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin() {
        return "auth/signin";
    }


    @ApiOperation(value = "跳转到注册")
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup() {
        return "auth/signup";
    }

}

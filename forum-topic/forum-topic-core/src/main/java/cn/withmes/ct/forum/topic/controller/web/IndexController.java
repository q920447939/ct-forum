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
        System.out.println(222);
        return "home";
    }

    @ApiOperation(value = "跳转到主题")
    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public String topics() {
        return "topics";
    }

}

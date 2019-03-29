/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年03月26日
 */
package cn.withmes.forum.api.controller.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName: TopicWebController
 * @Description:
 * @author leegoo
 * @date 2019年03月26日
 */
@Controller()
@RequestMapping("/web/topic")
public class TopicWebController {

    @ApiOperation(value = "跳转到主题详情")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String topics() {
        return "topic/detail";
    }
}

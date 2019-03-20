/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年03月20日
 */
package cn.withmes.ct.forum.topic.controller.web;

import cn.withme.forum.topic.api.vo.TopicVO;
import cn.withmes.ct.forum.base.common.config.base.mode.ResponseData;
import cn.withmes.ct.forum.base.common.config.base.utils.common.CopyAttributesUtils;
import cn.withmes.ct.forum.base.common.config.base.utils.mapper.BeanMapper;
import cn.withmes.ct.forum.base.common.config.base.web.BaseRestfulController;
import cn.withmes.ct.forum.topic.entity.bo.TopicBO;
import cn.withmes.ct.forum.topic.entity.domain.Topic;
import cn.withmes.ct.forum.topic.service.TopicService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: TopicController
 *
 * @author leegoo
 * @Description:
 * @date 2019年03月20日
 */
@Controller()
public class TopicController extends BaseRestfulController {

    @Autowired
    private TopicService topicService;

    @ApiOperation(value = "分页主题列表", notes = "撒大声地")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = "查询主题参数", required = false, dataType = "TopicVO"),
            @ApiImplicitParam(name = "draw", value = "查询开始(默认为1)", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "length", value = "每页查询的大小(默认为10)", required = false, dataType = "Integer")
    })
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loadIndex(@RequestBody(required = false) TopicVO param,
                            @RequestParam(value = "draw", defaultValue = "0") Integer draw,
                            @RequestParam(value = "length", defaultValue = "10") Integer length,
                            Model model) {
        log.info("getTbLabelList.draw:{}.length:{}", draw, length);
        Page<TopicBO> page = new Page<>(draw, length);
        IPage<Topic> pageList = topicService.page(page, CopyAttributesUtils.copyAtoB(param, TopicBO.class));
        model.addAttribute("topics", pageList.getRecords());  //设置单个值
        return "home";
    }
}

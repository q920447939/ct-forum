/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年03月22日
 */
package cn.withmes.ct.forum.topic.controller.web;

import cn.withme.forum.topic.api.vo.TopicVO;
import cn.withmes.ct.forum.base.common.config.base.utils.common.CopyAttributesUtils;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName: IndexController
 * @Description:
 * @author leegoo
 * @date 2019年03月22日
 */
@Controller
public class IndexController  extends BaseRestfulController {

    @Autowired
    private TopicService topicService;

    @ApiOperation(value = "分页主题列表(首页)", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = "查询主题参数",  dataType = "TopicVO"),
            @ApiImplicitParam(name = "draw", value = "查询开始(默认为1)", dataType = "Integer"),
            @ApiImplicitParam(name = "length", value = "每页查询的大小(默认为10)", dataType = "Integer")
    })
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loadIndex(@RequestBody(required = false) TopicVO param,
                            @RequestParam(value = "draw", defaultValue = "0") Integer draw,
                            @RequestParam(value = "length", defaultValue = "10") Integer length,
                            Model model) {
        System.out.println("999999999999999999999");
        log.info("getTbLabelList.draw:{}.length:{}", draw, length);
        Page<TopicBO> page = new Page<>(draw, length);
        IPage<Topic> pageList = topicService.page(page, CopyAttributesUtils.copyAtoB(param, TopicBO.class));
        model.addAttribute("topics", pageList.getRecords());  //设置单个值
        return "home";
    }



    @ApiOperation(value = "分页主题列表(主题页)", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = "查询主题参数", dataType = "TopicVO"),
            @ApiImplicitParam(name = "draw", value = "查询开始(默认为1)", dataType = "Integer"),
            @ApiImplicitParam(name = "length", value = "每页查询的大小(默认为10)", dataType = "Integer")
    })
    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public String titleTopic(@RequestBody(required = false) TopicVO param,
                            @RequestParam(value = "draw", defaultValue = "0") Integer draw,
                            @RequestParam(value = "length", defaultValue = "10") Integer length,
                            Model model) {
        log.info("getTbLabelList.draw:{}.length:{}", draw, length);
        Page<TopicBO> page = new Page<>(draw, length);
        IPage<Topic> pageList = topicService.page(page, CopyAttributesUtils.copyAtoB(param, TopicBO.class));
        model.addAttribute("topicPage", pageList.getRecords());  //设置单个值
        return "topics";
    }





}


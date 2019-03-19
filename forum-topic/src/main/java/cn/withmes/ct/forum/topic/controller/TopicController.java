/*
package cn.withmes.ct.forum.topic.controller;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.withmes.ct.service.TopicService;

import cn.withmes.ct.entity.Topic;
import cn.withmes.ct.entity.dto.TopicDTO;
import cn.withmes.ct.entity.vo.TopicAddVO;
import cn.withmes.ct.entity.vo.TopicVO;


import org.springframework.web.bind.annotation.RequestBody;




*/
/**
 *code is far away from bug with the animal protecting
 *  ┏┓　　　┏┓
 *┏┛┻━━━┛┻┓
 *┃　　　　　　　┃ 　
 *┃　　　━　　　┃
 *┃　┳┛　┗┳　┃
 *┃　　　　　　　┃
 *┃　　　┻　　　┃
 *┃　　　　　　　┃
 *┗━┓　　　┏━┛
 *　　┃　　　┃神兽保佑
 *　　┃　　　┃代码无BUG！
 *　　┃　　　┗━━━┓
 *　　┃　　　　　　　┣┓
 *　　┃　　　　　　　┏┛
 *　　┗┓┓┏━┳┓┏┛
 *　　　┃┫┫　┃┫┫
 *　　　┗┻┛　┗┻┛
 *
 *   @description : Topic 控制器
 *   ---------------------------------
 *      @author leegoo
 *   @since 2019-03-19
 *//*

@RestController
@RequestMapping("/topic")
public class TopicController extends BaseRestfulController {

    @Autowired
    public TopicService topicService;

    */
/**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2019-03-19
     *//*

    @PostMapping(value = "/page")
    public ResponseData<IPage<TopicListVO>> getTopicList(
                @RequestBody TopicListVO param ,
                @RequestParam(value = "draw",defaultValue = "0") Integer draw,
                @RequestParam(value = "length") Integer length,
                @RequestParam(value = "start") Integer start) {
            log.info("getTbLabelList.draw:{}.length:{}.start:{}",draw,length,start);
            Page<TopicDTO> page = new Page<>(draw, length);
            IPage<Topic> pageList = topicService.page(page, param);
            IPage<TopicListVO> iPage = CopyAttributesUtils.copyAtoB(pageList, IPage.class);
            return successData(iPage);
    }

    */
/**
     * @description : 通过id获取Topic
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2019-03-19
     *//*

    @GetMapping(value = "/get/{id}")
    public ResponseData<TopicVO> getTopicById(@PathVariable(name = "id") String id) {
        Topic dto = topicService.findById(id);
        return successData(CopyAttributesUtils.copyAtoB(dto,TopicVO.class));
    }

    */
/**
     * @description : 通过id删除Topic
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2019-03-19
     *//*

    @GetMapping(value = "/delete/{id}")
    public ResponseData<Integer> deleteTopicById(@PathVariable(name = "id") String id) {
        log.info("deleteTopicById.id:{}",id);
        return successData( topicService.delete(id));
    }

    */
/**
     * @description : 通过id更新Topic
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2019-03-19
     *//*

    @PostMapping(value = "/update")
    public ResponseData<Integer> updateTopicById(@RequestBody  @Validated(value = UpdateValid.class) TopicUpdateVO param) {
        log.info("updateTopicById.param:{}",param);
        Topic e = CopyAttributesUtils.copyAtoB(param, Topic.class);
        return successData(topicService.update(e));
    }

    */
/**
     * @description : 添加Topic
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2019-03-19
     *//*

    @PostMapping(value = "/add")
    public ResponseData<Integer> addTopic(@RequestBody @Validated(value = AddValid.class) TopicAddVO param) {
        log.info("addTopic.param:{}",param);
         Topic e = CopyAttributesUtils.copyAtoB(param, Topic.class);
        return successData(topicService.add(e));
    }
}*/

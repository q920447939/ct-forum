/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年03月20日
 */
package cn.withmes.ct.forum.topic.controller.back;

import cn.withme.forum.topic.api.vo.TopicVO;
import cn.withmes.ct.forum.base.common.config.base.enums.ResultCode;
import cn.withmes.ct.forum.base.common.config.base.mode.ResponseData;
import cn.withmes.ct.forum.base.common.config.base.utils.common.CopyAttributesUtils;
import cn.withmes.ct.forum.base.common.config.base.web.BaseRestfulController;
import cn.withmes.ct.forum.topic.entity.bo.TopicBO;
import cn.withmes.ct.forum.topic.entity.domain.Topic;
import cn.withmes.ct.forum.topic.service.TopicService;
import cn.withmes.ct.utils.utils.DateUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: TopicController
 *
 * @author leegoo
 * @Description:
 * @date 2019年03月20日
 */
@RestController
@RequestMapping("/topic")
public class TopicController extends BaseRestfulController {

    @Autowired
    private TopicService topicService;


    @ApiOperation(value = "分页主题列表(首页)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = "查询主题参数", dataType = "TopicVO"),
            @ApiImplicitParam(name = "draw", value = "查询开始(默认为1)", dataType = "Integer"),
            @ApiImplicitParam(name = "length", value = "每页查询的大小(默认为10)", dataType = "Integer")
    })
    @GetMapping(value = "/page")
    public ResponseData<IPage<TopicVO>> loadIndex(@RequestBody(required = false) TopicVO param,
                                                  @RequestParam(value = "draw", defaultValue = "0") Integer draw,
                                                  @RequestParam(value = "length", defaultValue = "10") Integer length) {
        log.info("loadIndex.draw:{}.length:{}", draw, length);
        Page<TopicBO> page = new Page<>(draw, length);
        IPage<Topic> pageList = topicService.page(page, CopyAttributesUtils.copyAtoB(param, TopicBO.class));
        @SuppressWarnings("unchecked")
        IPage<TopicVO> vos = CopyAttributesUtils.copyAtoB(pageList, IPage.class);
        vos.setRecords(CopyAttributesUtils.copyAlistToBlist(pageList.getRecords(), TopicVO.class));
        vos.getRecords().forEach(e->e.setReplyTime(DateUtils.formatToShow(e.getCreated())));
        return ResponseData.builder(vos, ResultCode.SUCCESS);
    }

    @ApiOperation(value = "帖子详情(Rest风格穿参数  eg : /topic/1)")
    @PutMapping("/{tid}")
    public ResponseData<TopicVO> detail (@PathVariable(name = "tid") String tid) {
        TopicBO bo = topicService.selectById(tid);
        if (null != bo) return successData(CopyAttributesUtils.copyAtoB(bo, TopicVO.class));
        return ResponseData.builder(ResultCode.BASE_ERROR);
    }

}
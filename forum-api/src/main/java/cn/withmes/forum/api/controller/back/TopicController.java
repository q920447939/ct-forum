/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年03月20日
 */

package cn.withmes.forum.api.controller.back;

import cn.withmes.ct.forum.base.common.config.base.enums.ResultCode;
import cn.withmes.ct.forum.base.common.config.base.mode.ResponseData;
import cn.withmes.ct.forum.base.common.config.base.utils.common.CopyAttributesUtils;
import cn.withmes.ct.forum.base.common.config.base.utils.mapper.BeanMapper;
import cn.withmes.ct.forum.base.common.config.base.web.BaseRestfulController;
import cn.withmes.ct.forum.common.entity.bo.HistoryNowBO;
import cn.withmes.ct.forum.common.entity.bo.TopicBO;
import cn.withmes.ct.forum.common.entity.domain.HistoryNow;
import cn.withmes.ct.forum.common.entity.domain.Topic;
import cn.withmes.ct.forum.member.api.contant.MemberRedisContant;
import cn.withmes.ct.forum.topic.api.contant.TopicRedisConstant;
import cn.withmes.ct.forum.topic.api.service.HistoryNowService;
import cn.withmes.ct.forum.topic.api.service.TopicService;
import cn.withmes.ct.forum.topic.api.vo.HistoryNowVO;
import cn.withmes.ct.forum.topic.api.vo.TopicVO;
import cn.withmes.ct.utils.utils.DateUtil;
import cn.withmes.ct.utils.utils.DateUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.integration.annotation.Default;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * ClassName: TopicController
 *
 * @author leegoo
 * @Description:
 * @date 2019年03月20日
 */

@RestController
@RequestMapping("/back/topic")
public class TopicController extends BaseRestfulController {

    @Reference(version = "${topic.service.version}", check = false, retries = 0, timeout = 10_000)
    private TopicService topicService;

    @Reference(version = "${topic.service.version}", check = false, retries = 0, timeout = 10_000)
    private HistoryNowService historyNowService;

    @Autowired
    private RedisTemplate redisTemplate;


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
        vos.getRecords().forEach(e -> e.setReplyTime(DateUtils.formatToShow(e.getCreated())));
        return ResponseData.builder(vos, ResultCode.SUCCESS);
    }

    @ApiOperation(value = "帖子详情(Rest风格传参数  eg : /topic/1)")
    @GetMapping("/{tid}")
    public ResponseData<TopicVO> detail(@PathVariable(name = "tid") String tid) {
        TopicBO bo = topicService.selectById(tid);
        TopicVO vo = CopyAttributesUtils.copyAtoB(bo, TopicVO.class);
        if (null != vo) {
            if (null != vo.getReplyTime()) {
                //TODO
            }
            return successData(vo);
        }
        return ResponseData.builder(ResultCode.BASE_ERROR);
    }


    @GetMapping("/history/now")
    public ResponseData<HistoryNowVO> findHistoryNowADay() {
        ResponseData<HistoryNowVO> responseData = new ResponseData<>();
        Object value = redisTemplate.opsForList().rightPop(TopicRedisConstant.REDIS_Topic_NOW_A_DAY_KEY_PREFIX + DateUtil.getYmd());
        if (null != value) {
            if (value instanceof ArrayList) {
                List<Object> list = (ArrayList)value;
                int randomIdx = new Random().nextInt(list.size());
                Object obj = list.get(randomIdx);
                return successData(JSON.parseObject(obj.toString(), HistoryNowVO.class));
            }
        }
        ResponseData<List<HistoryNowBO>> data = historyNowService.findHistoryNow();
        if (data.isSuccess()) {
            String key = TopicRedisConstant.REDIS_Topic_NOW_A_DAY_KEY_PREFIX + DateUtil.getYmd();
            data.getData().forEach(e->redisTemplate.opsForList().rightPush(key, JSON.toJSONString(e)));
            redisTemplate.expire(key, MemberRedisContant.REDIS_MEMBER_USER_GET_EXPIRE_HOUR, TimeUnit.HOURS);

            int randomIdx = new Random().nextInt(data.getData().size());
            HistoryNowVO vo = CopyAttributesUtils.copyAtoB(data.getData().get(randomIdx), HistoryNowVO.class);
            BeanMapper.copy(data, responseData);
            responseData.setData(vo);
        }
        return responseData;
    }

}



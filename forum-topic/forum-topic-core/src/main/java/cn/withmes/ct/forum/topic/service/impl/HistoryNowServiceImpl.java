package cn.withmes.ct.forum.topic.service.impl;


import cn.withmes.ct.forum.base.common.config.base.dal.BaseMapper;
import cn.withmes.ct.forum.base.common.config.base.enums.ResultCode;
import cn.withmes.ct.forum.base.common.config.base.mode.ResponseData;
import cn.withmes.ct.forum.base.common.config.base.service.BaseServiceImpl;
import cn.withmes.ct.forum.base.common.config.base.utils.common.CopyAttributesUtils;
import cn.withmes.ct.forum.common.entity.bo.HistoryNowBO;
import cn.withmes.ct.forum.common.entity.domain.HistoryNow;
import cn.withmes.ct.forum.topic.api.service.HistoryNowService;
import cn.withmes.ct.forum.topic.mapper.HistoryNowMapper;
import cn.withmes.ct.utils.utils.DateUtil;
import cn.withmes.ct.utils.utils.DateUtils;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author leegoo
 * @since 2019-04-11
 */
@com.alibaba.dubbo.config.annotation.Service(version = "${topic.service.version}")
@RefreshScope
public class HistoryNowServiceImpl extends BaseServiceImpl<HistoryNow> implements HistoryNowService {

    @Autowired
    private  HistoryNowMapper mapper;


    @Override
    public BaseMapper<HistoryNow> getBaseMapper() {
        return mapper;
    }


    @Override
    public ResponseData<List<HistoryNowBO>> findHistoryNow() {
        List<HistoryNow> historyNows = mapper.findHistoryNow(DateUtils.formatNow());
        if (CollectionUtils.isNotEmpty(historyNows)) {
            return ResponseData.builder(CopyAttributesUtils.copyAlistToBlist(historyNows, HistoryNowBO.class),ResultCode.SUCCESS);
        }
        return ResponseData.builder(ResultCode.BASE_ERROR);
    }

}

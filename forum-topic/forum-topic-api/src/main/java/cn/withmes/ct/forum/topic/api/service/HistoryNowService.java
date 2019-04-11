package cn.withmes.ct.forum.topic.api.service;


import cn.withmes.ct.forum.base.common.config.base.mode.ResponseData;
import cn.withmes.ct.forum.base.common.config.base.service.BaseService;
import cn.withmes.ct.forum.common.entity.bo.HistoryNowBO;
import cn.withmes.ct.forum.common.entity.domain.HistoryNow;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leegoo
 * @since 2019-04-11
 */
public interface HistoryNowService extends BaseService<HistoryNow> {


    /**
     * @Description:查找今天的 历史上的今天
     * @param:
     * @return:
     * @auther: liming
     * @date: 2019/4/11 11:42
     */
    ResponseData<List<HistoryNowBO>> findHistoryNow();

}

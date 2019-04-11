package cn.withmes.ct.forum.topic.mapper;


import cn.withmes.ct.forum.base.common.config.base.dal.BaseMapper;
import cn.withmes.ct.forum.common.entity.domain.HistoryNow;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author leegoo
 * @since 2019-04-11
 */
public interface HistoryNowMapper extends BaseMapper<HistoryNow> {

    List<HistoryNow> findHistoryNow(@Param(value = "time") String time);
}

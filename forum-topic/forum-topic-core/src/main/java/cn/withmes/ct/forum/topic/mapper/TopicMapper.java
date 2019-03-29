
package cn.withmes.ct.forum.topic.mapper;


import cn.withmes.ct.forum.base.common.config.base.dal.BaseMapper;
import cn.withmes.ct.forum.common.entity.domain.Topic;
import org.apache.ibatis.annotations.Param;


/**
 * @author leegoo
 * @Description: 帖子表 Mapper 接口
 * @date 2019-03-19
 */

public interface TopicMapper extends BaseMapper<Topic> {

    Topic selectById(@Param("id") String id);
}


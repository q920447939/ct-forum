
package cn.withmes.ct.forum.topic.service;

import cn.withmes.ct.forum.base.common.config.base.service.BaseService;
import cn.withmes.ct.forum.topic.entity.Topic;
import org.apache.ibatis.annotations.Param;


/**
 * @Description: 帖子表 服务类
 * @author leegoo
 * @date 2019-03-19
 */

public interface TopicService extends BaseService<Topic> {
    Topic selectById(@Param("id") String id);
}


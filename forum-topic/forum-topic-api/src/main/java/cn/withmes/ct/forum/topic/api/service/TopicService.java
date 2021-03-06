
package cn.withmes.ct.forum.topic.api.service;

import cn.withmes.ct.forum.base.common.config.base.service.BaseService;
import cn.withmes.ct.forum.common.entity.bo.TopicBO;
import cn.withmes.ct.forum.common.entity.domain.Topic;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;


/**
 * @author leegoo
 * @Description: 帖子表 服务类
 * @date 2019-03-19
 */

public interface TopicService extends BaseService<Topic> {

    IPage<Topic> page(Page<TopicBO> page, TopicBO bo);

    TopicBO selectById(@Param("id") String id);


}


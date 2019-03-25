
package cn.withmes.ct.forum.topic.service.impl;


import cn.withmes.ct.forum.base.common.config.base.dal.BaseMapper;
import cn.withmes.ct.forum.base.common.config.base.service.BaseServiceImpl;
import cn.withmes.ct.forum.base.common.config.base.utils.common.CopyAttributesUtils;
import cn.withmes.ct.forum.topic.entity.bo.TopicBO;
import cn.withmes.ct.forum.topic.entity.domain.Topic;
import cn.withmes.ct.forum.topic.mapper.TopicMapper;
import cn.withmes.ct.forum.topic.service.TopicService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author leegoo
 * @Description: 帖子表 服务实现类
 * @date 2019-03-19
 */

@Service
public class TopicServiceImpl extends BaseServiceImpl<Topic> implements TopicService {

    @Autowired
    private TopicMapper mapper;

    @Override
    public BaseMapper<Topic> getBaseMapper() {
        return mapper;
    }

    @Override
    public int updateAllColumn(Topic entity) {
        return 0;
    }


    @Override
    @SuppressWarnings("unchecked")
    public IPage<Topic> page(Page<TopicBO> page, TopicBO bo) {
        Topic topic = CopyAttributesUtils.copyAtoB(bo, Topic.class);
        QueryWrapper wrapper = new QueryWrapper();
        // todo wrapper select
        Page<Topic> queryPage = CopyAttributesUtils.copyAtoB(page, Page.class);
        IPage<Topic> pageList = mapper.selectPage(queryPage, wrapper);
        return pageList;
    }

    @Override
    public Topic selectById(String id) {
        return mapper.selectById(id);
    }
}


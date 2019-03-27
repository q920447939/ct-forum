
package cn.withmes.ct.forum.topic.service.impl;


import cn.withmes.ct.forum.base.common.config.base.dal.BaseMapper;
import cn.withmes.ct.forum.base.common.config.base.service.BaseServiceImpl;
import cn.withmes.ct.forum.base.common.config.base.utils.common.CopyAttributesUtils;
import cn.withmes.ct.forum.topic.entity.bo.TopicBO;
import cn.withmes.ct.forum.topic.entity.domain.Comment;
import cn.withmes.ct.forum.topic.entity.domain.Topic;
import cn.withmes.ct.forum.topic.mapper.CommentMapper;
import cn.withmes.ct.forum.topic.mapper.TopicMapper;
import cn.withmes.ct.forum.topic.service.TopicService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author leegoo
 * @Description: 帖子表 服务实现类
 * @date 2019-03-19
 */

@Service
public class TopicServiceImpl extends BaseServiceImpl<Topic> implements TopicService {

    @Autowired
    private TopicMapper mapper;

    @Autowired
    private CommentMapper commentMapper;

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
        QueryWrapper wrapper = new QueryWrapper();
        // todo wrapper select
        Page<Topic> queryPage = CopyAttributesUtils.copyAtoB(page, Page.class);
        return mapper.selectPage(queryPage, wrapper);
    }

    @Override
    public TopicBO selectById(String id) {
        TopicBO topicBO = new TopicBO();
        Topic item = mapper.selectById(id);
        if (null != item) {
            topicBO = CopyAttributesUtils.copyAtoB(item, TopicBO.class);
            QueryWrapper<Comment> wraapper = new QueryWrapper<>();
            wraapper.eq(Comment.TID, item.getTid());
            List<Comment> comments = commentMapper.selectList(wraapper);
            if (!CollectionUtils.isEmpty(comments)) topicBO.setCommentList(comments);
        }
        return topicBO;
    }
}


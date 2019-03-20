
package cn.withmes.ct.forum.topic.service.impl;


import cn.withmes.ct.forum.base.common.config.base.dal.BaseMapper;
import cn.withmes.ct.forum.base.common.config.base.service.BaseServiceImpl;
import cn.withmes.ct.forum.base.common.config.base.utils.common.CopyAttributesUtils;

import cn.withmes.ct.forum.topic.entity.Topic;
import cn.withmes.ct.forum.topic.mapper.TopicMapper;
import cn.withmes.ct.forum.topic.service.TopicService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;




/**
 * @Description: 帖子表 服务实现类
 * @author leegoo
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
	public Topic selectById(String id) {
		return mapper.selectById(id);
	}
}


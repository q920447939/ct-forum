package cn.withmes.ct.forum.member.core.impl;

import cn.withmes.ct.forum.base.common.config.base.dal.BaseMapper;
import cn.withmes.ct.forum.base.common.config.base.service.BaseServiceImpl;
import cn.withmes.ct.forum.base.common.config.base.utils.common.CopyAttributesUtils;
import cn.withmes.ct.forum.member.api.service.MemberService;
import cn.withmes.ct.forum.member.common.entity.bo.MemberBO;
import cn.withmes.ct.forum.member.common.entity.domain.Member;
import cn.withmes.ct.forum.member.core.mapper.MemberMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





/**
 * @Description: 会员表 服务实现类
 * @author leegoo
 * @date 2019-03-29
 */
@Service
public class MemberServiceImpl extends BaseServiceImpl<Member> implements MemberService {

	@Autowired
	private MemberMapper mapper;

	@Override
	public int updateAllColumn(Member entity) {
		return 0;
	}

	@Override
	public BaseMapper<Member> getBaseMapper() {
		return mapper;
	}

	@Override
	public   IPage<Member> page (Page<MemberBO> page ,MemberBO bo ) {
		Member dto = CopyAttributesUtils.copyAtoB(page, Member.class);
        QueryWrapper wrapper = new QueryWrapper();
        // todo wrapper select
        Page<Member> queryPage = CopyAttributesUtils.copyAtoB(page, Page.class);
        IPage<Member> pageList = mapper.selectPage(queryPage, wrapper);
		return pageList;
	}
	
}

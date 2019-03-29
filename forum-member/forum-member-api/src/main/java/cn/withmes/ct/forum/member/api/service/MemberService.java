package cn.withmes.ct.forum.member.api.service;


import cn.withmes.ct.forum.base.common.config.base.service.BaseService;
import cn.withmes.ct.forum.member.common.entity.bo.MemberBO;
import cn.withmes.ct.forum.member.common.entity.domain.Member;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @Description: 会员表 服务类
 * @author leegoo
 * @date 2019-03-29
 */
public interface MemberService extends BaseService<Member> {
        IPage<Member> page(Page<MemberBO> page ,MemberBO bo);
}

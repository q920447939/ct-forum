package cn.withmes.ct.forum.member.core.service.impl;

import cn.withmes.ct.forum.base.common.config.base.dal.BaseMapper;
import cn.withmes.ct.forum.base.common.config.base.enums.ResultCode;
import cn.withmes.ct.forum.base.common.config.base.mode.ResponseData;
import cn.withmes.ct.forum.base.common.config.base.service.BaseServiceImpl;
import cn.withmes.ct.forum.base.common.config.base.utils.UuidUtils;
import cn.withmes.ct.forum.base.common.config.base.utils.common.CopyAttributesUtils;
import cn.withmes.ct.forum.base.common.config.base.utils.mapper.BeanMapper;
import cn.withmes.ct.forum.base.common.contant.BaseContant;
import cn.withmes.ct.forum.base.common.utils.ReUtils;
import cn.withmes.ct.forum.member.api.contant.MemberContant;
import cn.withmes.ct.forum.member.api.enums.MemberResultCode;
import cn.withmes.ct.forum.member.api.service.MemberService;
import cn.withmes.ct.forum.member.common.entity.bo.MemberBO;
import cn.withmes.ct.forum.member.common.entity.domain.Member;
import cn.withmes.ct.forum.member.core.mapper.MemberMapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


/**
 * @author leegoo
 * @Description: 会员表 服务实现类
 * @date 2019-03-29
 */
@com.alibaba.dubbo.config.annotation.Service(version = "${member.service.version}")
@RefreshScope
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
    public IPage<Member> page(Page<MemberBO> page, MemberBO bo) {
        Member dto = CopyAttributesUtils.copyAtoB(page, Member.class);
        QueryWrapper wrapper = new QueryWrapper();
        // todo wrapper select
        Page<Member> queryPage = CopyAttributesUtils.copyAtoB(page, Page.class);
        IPage<Member> pageList = mapper.selectPage(queryPage, wrapper);
        return pageList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseData<MemberBO> insert(MemberBO bo) {
        boolean flg = ReUtils.reContainChinese(bo.getUsername());
        if (flg) return ResponseData.builder(MemberResultCode.MEMBER_USER_NAME_CONTAIN_CHINESE);
        flg = ReUtils.reContainChinese(bo.getPassword());
        if (flg) return ResponseData.builder(MemberResultCode.MEMBER_PASS_WORD_CONTAIN_CHINESE);
        if (!bo.getPassword().equals(bo.getRePassword()))
            return ResponseData.builder(MemberResultCode.PASS_WORD_TWIN_NOT_EQUAL);
        Member member = CopyAttributesUtils.copyAtoB(bo, Member.class);
        //查询用户名是否重复
        Wrapper<Member> query = new QueryWrapper<>();
        ((QueryWrapper<Member>) query).eq(Member.USERNAME, member.getUsername());
        List<Member> userNameList = mapper.selectList(query);
        if (CollectionUtils.isNotEmpty(userNameList))
            return ResponseData.builder(MemberResultCode.MEMBER_USER_NAME_EXISTS);
        member.setId(UuidUtils.generate());
        LocalDateTime now = LocalDateTime.now();
        member.setCreated(now);
        member.setDeleted(BaseContant.DEL_STATE.NOT_DEL);
        member.setState(MemberContant.MEMBER_STAT.UN_ACTIVITY);
        member.setLogined(now);
        member.setUpdated(now);
        try {
            mapper.insert(member);
            bo.setId(member.getId());
            return ResponseData.builder(bo,ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println("--------------"+e);
            return ResponseData.builder(ResultCode.ADD_DATA_IS_ERROR);
        }
    }
}

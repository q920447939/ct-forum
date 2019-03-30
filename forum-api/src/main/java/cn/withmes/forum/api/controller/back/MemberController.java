package cn.withmes.forum.api.controller.back;

import cn.withmes.ct.forum.base.common.config.base.enums.ResultCode;
import cn.withmes.ct.forum.base.common.config.base.mode.ResponseData;
import cn.withmes.ct.forum.base.common.config.base.utils.common.CopyAttributesUtils;
import cn.withmes.ct.forum.base.common.config.base.web.BaseRestfulController;
import cn.withmes.ct.forum.common.entity.bo.TopicBO;
import cn.withmes.ct.forum.common.entity.domain.Topic;
import cn.withmes.ct.forum.member.api.service.MemberService;
import cn.withmes.ct.forum.member.api.vo.MemberVO;
import cn.withmes.ct.forum.member.common.entity.bo.MemberBO;
import cn.withmes.ct.forum.member.common.entity.domain.Member;
import cn.withmes.ct.forum.topic.api.vo.TopicVO;
import cn.withmes.ct.utils.utils.DateUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





/**
 *code is far away from bug with the animal protecting
 *  ┏┓　　　┏┓
 *┏┛┻━━━┛┻┓
 *┃　　　　　　　┃ 　
 *┃　　　━　　　┃
 *┃　┳┛　┗┳　┃
 *┃　　　　　　　┃
 *┃　　　┻　　　┃
 *┃　　　　　　　┃
 *┗━┓　　　┏━┛
 *　　┃　　　┃神兽保佑
 *　　┃　　　┃代码无BUG！
 *　　┃　　　┗━━━┓
 *　　┃　　　　　　　┣┓
 *　　┃　　　　　　　┏┛
 *　　┗┓┓┏━┳┓┏┛
 *　　　┃┫┫　┃┫┫
 *　　　┗┻┛　┗┻┛
 *
 *   @description : Member 控制器
 *   ---------------------------------
 *      @author leegoo
 *   @since 2019-03-29
 */
@RestController
@RequestMapping("/back/member")
public class MemberController extends BaseRestfulController {

    @Reference(version = "${member.service.version}")
    private MemberService memberService;

    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2019-03-29
     */
    @PostMapping(value = "/page")
    public ResponseData<IPage<MemberVO>> getMemberList(@RequestBody(required = false) MemberVO param,
                                                           @RequestParam(value = "draw", defaultValue = "0") Integer draw,
                                                           @RequestParam(value = "length", defaultValue = "10") Integer length) {
        Page<MemberBO> page = new Page<>(draw, length);
        IPage<Member> pageList = memberService.page(page, CopyAttributesUtils.copyAtoB(param, MemberBO.class));
        @SuppressWarnings("unchecked")
        IPage<MemberVO> vos = CopyAttributesUtils.copyAtoB(pageList, IPage.class);
        vos.setRecords(CopyAttributesUtils.copyAlistToBlist(pageList.getRecords(), MemberVO.class));
        //vos.getRecords().forEach(e->e.setReplyTime(DateUtils.formatToShow(e.getCreated())));
        return ResponseData.builder(vos, ResultCode.SUCCESS);
    }

    /**
     * @description : 通过id获取Member
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2019-03-29
     */
    @GetMapping(value = "/get/{id}")
    public ResponseData<MemberVO> getMemberById(@PathVariable(name = "id") String id) {
        Member dto = memberService.findById(id);
        return successData(CopyAttributesUtils.copyAtoB(dto,MemberVO.class));
    }

    /**
     * @description : 通过id删除Member
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2019-03-29
     */
    @GetMapping(value = "/delete/{id}")
    public ResponseData<Integer> deleteMemberById(@PathVariable(name = "id") String id) {
        log.info("deleteMemberById.id:{}",id);
        return successData( memberService.delete(id));
    }

/*    *//**
     * @description : 通过id更新Member
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2019-03-29
     *//*
    @PostMapping(value = "/update")
    public ResponseData<Integer> updateMemberById(@RequestBody  @Validated(value = UpdateValid.class) MemberUpdateVO param) {
        log.info("updateMemberById.param:{}",param);
        Member e = CopyAttributesUtils.copyAtoB(param, Member.class);
        return successData(memberService.update(e));
    }

    *//**
     * @description : 添加Member
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2019-03-29
     *//*
    @PostMapping(value = "/add")
    public ResponseData<Integer> addMember(@RequestBody @Validated(value = AddValid.class) MemberAddVO param) {
        log.info("addMember.param:{}",param);
         Member e = CopyAttributesUtils.copyAtoB(param, Member.class);
        return successData(memberService.add(e));
    }*/
}
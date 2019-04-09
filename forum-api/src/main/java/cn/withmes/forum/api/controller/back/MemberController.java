package cn.withmes.forum.api.controller.back;

import cn.withmes.ct.forum.base.common.config.base.enums.ResultCode;
import cn.withmes.ct.forum.base.common.config.base.mode.ResponseData;
import cn.withmes.ct.forum.base.common.config.base.utils.common.CopyAttributesUtils;
import cn.withmes.ct.forum.base.common.config.base.utils.mapper.BeanMapper;
import cn.withmes.ct.forum.base.common.config.base.web.BaseRestfulController;
import cn.withmes.ct.forum.member.api.contant.MemberRedisContant;
import cn.withmes.ct.forum.member.api.enums.MemberResultCode;
import cn.withmes.ct.forum.member.api.service.MemberService;
import cn.withmes.ct.forum.member.api.vo.MemberAddVO;
import cn.withmes.ct.forum.member.api.vo.MemberLoginVO;
import cn.withmes.ct.forum.member.api.vo.MemberVO;
import cn.withmes.ct.forum.member.common.entity.bo.MemberBO;
import cn.withmes.ct.forum.member.common.entity.domain.Member;
import cn.withmes.ct.utils.utils.EncryptUtil;
import cn.withmes.forum.api.contant.CookieContant;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.jscookie.javacookie.Cookies;
import com.github.jscookie.javacookie.Expiration;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;


/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @author leegoo
 * @description : Member 控制器
 * ---------------------------------
 * @since 2019-03-29
 */
@RestController
@RequestMapping("/back/member")
public class MemberController extends BaseRestfulController {

    @Reference(version = "${member.service.version}", check = false, retries = 0, timeout = 10_000)
    private MemberService memberService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${register.success.href}")
    private String href;

    @Autowired
    private CaptchaController controller;


    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2019-03-29
     */
    @GetMapping(value = "/page")
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
    @Cacheable(value = MemberRedisContant.REDIS_MEMBER_KEY_PREFIX, key = "#id")
    public ResponseData<MemberVO> getMemberById(@PathVariable(name = "id") String id) {
        System.out.println("没有进方法");
        Member dto = memberService.findById(id);
        return successData(CopyAttributesUtils.copyAtoB(dto, MemberVO.class));
    }

    /**
     * @description : 通过id删除Member
     * ---------------------------------
     * @author : leegoo
     * @since : Create in 2019-03-29
     */
    @GetMapping(value = "/delete/{id}")
    public ResponseData<Integer> deleteMemberById(@PathVariable(name = "id") String id) {
        log.info("deleteMemberById.id:{}", id);
        return successData(memberService.delete(id));
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


    /**
     * @Description:注册
     * @param: [param, req, resp]
     * @return: cn.withmes.ct.forum.base.common.config.base.mode.ResponseData<java.lang.Object>
     * @auther: liming
     * @date: 2019/4/8 11:59
     */
    @PostMapping(value = "/signup")
    public ResponseData<Object> insert(@RequestBody @Valid MemberAddVO param, HttpServletRequest req, HttpServletResponse resp) {
        log.info("insert.param:{}", param);
        //判断验证码是否正确
        ResponseData<Boolean> captcha = controller.findCaptcha(req, resp);
        if (!captcha.isSuccess()) {
            return ResponseData.builder(ResultCode.CAPTCHA_IS_EXPIRE_OR_ERROR);
        }
        MemberBO e = CopyAttributesUtils.copyAtoB(param, MemberBO.class);
        ResponseData<MemberBO> data = memberService.insert(e);
        if (data.isSuccess()) {
            //删除redis 验证码
            redisTemplate.delete(req.getParameter("token"));

            //处理成功后的逻辑
            ResponseData<Object> handleSuccess = handleSuccess(data.getData().getId(), req, resp);
            return ResponseData.builder(handleSuccess.getData(), handleSuccess.getCode(), handleSuccess.getMessage());
            // todo 发送邮件
            //return ResponseData.builder( map, ResultCode.SUCCESS, "邮件已经发送到:"+param.getEmail()+",请及时验证");
            //return   ResponseData.builder( map, ResultCode.SUCCESS );
        }
        return ResponseData.builder(data.getData(), ResultCode.SUCCESS, data.getMessage());

    }

    private ResponseData<Object> handleSuccess(String id, HttpServletRequest req, HttpServletResponse resp) {
        Map<String, String> map = new ConcurrentHashMap();
        map.put("href", href);

        //将用户信息保存到redis
        ResponseData<MemberVO> item = getMemberById(id);
        if (!item.isSuccess()) {
            return ResponseData.builder(ResultCode.BASE_ERROR);
        }
        MemberVO itemData = item.getData();
        String key = MemberRedisContant.REDIS_MEMBER_KEY_PREFIX + itemData.getId();
        redisTemplate.opsForValue().set(key, JSON.toJSONString(item.getData()));
        redisTemplate.expire(key, MemberRedisContant.REDIS_MEMBER_USER_GET_EXPIRE_HOUR, TimeUnit.HOURS);

        //增加cookie
        Cookies cookies = Cookies.initFromServlet(req, resp);
        cookies.set(CookieContant.MEMBER_COOKIE_GET_PREFIX, itemData.getId(), Cookies.Attributes.empty()
                .expires(Expiration.days(CookieContant.MEMBER_COOKIE_DAY_EXPIRE))
        );
        return ResponseData.builder(map, ResultCode.SUCCESS);
    }


    /**
     * @Description:注销
     * @param: [memberId]
     * @return: cn.withmes.ct.forum.base.common.config.base.mode.ResponseData<java.lang.Object>
     * @auther: liming
     * @date: 2019/4/8 11:45
     */
    @GetMapping("/logout/{memberId}")
    public ResponseData<Object> logout(@PathVariable(name = "memberId") String memberId) {
        //TODO
        return successData();
    }


    /**
     * @Description:登陆
     * @param: [vo]
     * @return: cn.withmes.ct.forum.base.common.config.base.mode.ResponseData<java.lang.Object>
     * @auther: liming
     * @date: 2019/4/8 15:34
     */
    @PostMapping("/login")
    public ResponseData<Object> login(@RequestBody @Valid MemberLoginVO vo, HttpServletRequest req, HttpServletResponse resp) {
        ResponseData<MemberBO> data = memberService.findByParams(CopyAttributesUtils.copyAtoB(vo, MemberBO.class));
        if (!data.isSuccess()) return ResponseData.builder(data.getData(), data.getCode(), data.getMessage());
        ResponseData<Object> handleSuccess = handleSuccess(data.getData().getId(), req, resp);
        return ResponseData.builder(handleSuccess.getData(), handleSuccess.getCode(), handleSuccess.getMessage());
    }

}
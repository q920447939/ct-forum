package cn.withmes.forum.api.controller.back;

import cn.withmes.ct.forum.base.common.config.base.enums.ResultCode;
import cn.withmes.ct.forum.base.common.config.base.mode.ResponseData;
import cn.withmes.ct.forum.base.common.config.base.web.BaseRestfulController;
import cn.withmes.forum.api.captcha.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * <h3>概要:</h3><p>CaptchaController</p>
 * <h3>功能:</h3><p>CaptchaController</p>
 * <h3>履历:</h3>
 * <li>2017年5月16日  v0.1 版本内容: 新建</li>
 *
 * @author 粱桂钊
 * @since 0.1
 */
@RestController
@RequestMapping(value = "/v0.1/captcha")
public class CaptchaController extends BaseRestfulController {
    @Autowired
    private CaptchaService captchaService;


    /**
     * 生成图片验证码
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public void genCaptcha(HttpServletRequest req, HttpServletResponse resp) {
        String token = req.getParameter("token");
        Assert.hasText(token);
         captchaService.genCaptcha(token, req, resp);
    }

    /**
     * 查询图片验证码
     */
    @RequestMapping(value = "/valid", method = RequestMethod.GET)
    public ResponseData<Boolean> findCaptcha(HttpServletRequest req, HttpServletResponse resp) {
        String token = req.getParameter("token");
        String reqCaptchaCode = req.getParameter("captchaCode");
        boolean isValid = false;
        if (null == reqCaptchaCode) return null;
        reqCaptchaCode = reqCaptchaCode.toLowerCase();
        Assert.hasText(token);
        Assert.hasText(reqCaptchaCode);
        Object captchaCode = captchaService.findCaptcha(token);
        if (null == captchaCode) return ResponseData.builder(ResultCode.CAPTCHA_IS_ERROR);
        if (reqCaptchaCode.equals(captchaCode.toString().toLowerCase())) {
            isValid = true;
        }
        return successData(isValid);
    }
}
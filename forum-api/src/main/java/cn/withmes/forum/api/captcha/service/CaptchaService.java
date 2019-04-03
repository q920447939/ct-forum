package cn.withmes.forum.api.captcha.service;

import cn.withmes.forum.api.compoment.CaptchaComponent;
//import cn.withmes.forum.api.redisdao.RedisBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <h3>概要:</h3><p>CaptchaService</p>
 * <h3>功能:</h3><p>CaptchaService</p>
 * <h3>履历:</h3>
 * <li>2017年1月5日  v0.1 版本内容: 新建</li>
 * @author 粱桂钊
 * @since 0.1
 */
@Service
public class CaptchaService {

    @Autowired
    private CaptchaComponent captchaComponent;

    @Autowired
    private RedisTemplate redisTemplate;

   // @Autowired
   // private RedisBaseDao redisBaseDao;
    /**
     * 生成图片验证码
     * @param token
     * @param req
     * @param resp
     * @return
     */
    public void genCaptcha(String token, HttpServletRequest req, HttpServletResponse resp){
         this.captchaComponent.createCaptcha(token, req, resp);
    }

    /**
     * 查询图片验证码
     * @param token
     * @return
     */
    public Object findCaptcha(String token) {
        return redisTemplate.opsForValue().get(token);
    }

}
package cn.withmes.forum.api.compoment;

import cn.withmes.forum.api.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * <h3>概要:</h3><p>CaptchaComponent</p>
 * <h3>功能:</h3><p>图片认证码工具类</p>
 * <h3>履历:</h3>
 * <li>2017年5月16日  v0.1 版本内容: 新建</li>
 *
 * @author 粱桂钊
 * @since 0.1
 */
@Component
public class CaptchaComponent {

    // 图片的宽度
    private static final int CAPTCHA_WIDTH = 200;
    // 图片的高度
    private static final int CAPTCHA_HEIGHT = 50;
    // 验证码的个数
    private static final int CAPTCHA_CODECOUNT = 4;

    private static final int XX = 15;
    private static final int CAPTCHA_FONT_HEIGHT = 25;
    private static final int CAPTCHA_CODE_Y = 16;
    private static final char[] codeSequence = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G',
            'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    // 过期时间为60秒
    private static final long EXPIRE_MINUS = 5;

    @Autowired
    private RedisTemplate redisTemplate;



    /**
     * @Description:生成验证码
     * @param: [token, req, resp]
     * @return: void
     * @auther: liming
     * @date: 2019/4/1 15:49
     */

    public void createCaptcha(String token, HttpServletRequest req, HttpServletResponse resp) {
        try {
            String code = CaptchaUtil.out(req, resp);
            redisTemplate.opsForValue().set(token.toLowerCase(), code);
            redisTemplate.expire(token.toLowerCase(), EXPIRE_MINUS, TimeUnit.MINUTES);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
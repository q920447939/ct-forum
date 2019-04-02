/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年04月01日
 */
package cn.withmes.forum.api.controller.test;

import cn.withmes.forum.api.entity.redis.Token;
//import cn.withmes.forum.api.service.RedisService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Arrays;
import java.util.UUID;

/**
 * ClassName: TestController
 *
 * @author leegoo
 * @Description:
 * @date 2019年04月01日
 */
@RestController
@RequestMapping("/test")
@Deprecated
public class TestController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/set")
    public void set() {
        User user = new User("aa@126.com", "aa", "aa123456", "aa", "123");
        redisTemplate.opsForValue().set("user-key", JSON.toJSONString(user));
    }

    @GetMapping("/get")
    public Object get() {
        String o = (String) redisTemplate.opsForValue().get("user-key");
        User user = JSON.parseObject(o, User.class);
        System.out.println(user);
        return user;
    }


    @RequestMapping("/getUser")
    //@Cacheable(value="user-key")
    public User getUser() {
        User user = new User("aa@126.com", "aa", "aa123456", "aa", "123");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }


    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }



}

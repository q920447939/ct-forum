/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年03月14日
 */
package cn.withmes.ct.forum.topic.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: UserController
 *
 * @author leegoo
 * @Description:
 * @date 2019年03月14日
 */
@Controller
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/say")
    @ResponseBody
    public String say(Integer id) {
        UserTest userTest = userMapper.selectById(id);
        String s = "hello:" + userTest.getName();
        return s;
    }
}

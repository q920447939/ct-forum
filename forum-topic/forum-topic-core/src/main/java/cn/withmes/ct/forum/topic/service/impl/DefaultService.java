/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年03月28日
 */
package cn.withmes.ct.forum.topic.service.impl;

import cn.withmes.ct.forum.topic.api.service.DemoService;
import cn.withmes.ct.forum.topic.api.vo.User;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;


/**
 * ClassName: DefaultService
 * @Description:
 * @author leegoo
 * @date 2019年03月28日
 */
@Service(version = "${demo.service.version}")
@RefreshScope
public class DefaultService implements DemoService {

    @Value("${name}")
    private String name;

    @Override
    public User sayName(Integer id) {
        if (id == 1) {
            return User.builder().id(1).name("我的名字叫做哇啊哈哈").build();
        }
        return User.builder().id(2).name("我的名字叫做哇大保健").build();
    }
}
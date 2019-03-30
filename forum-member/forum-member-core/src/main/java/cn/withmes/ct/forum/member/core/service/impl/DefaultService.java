/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年03月28日
 */
package cn.withmes.ct.forum.member.core.service.impl;


import cn.withmes.ct.forum.member.api.service.DemoService;
import cn.withmes.ct.forum.member.api.vo.MemberVO;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;


/**
 * ClassName: DefaultService
 * @Description:
 * @author leegoo
 * @date 2019年03月28日
 */
@Service(version = "${member.service.version}")
@RefreshScope
public class DefaultService implements DemoService {

    @Value("${name}")
    private String name;

    @Override
    public MemberVO sayName(Integer id) {
        MemberVO vo = new MemberVO();
        if (id == 1) {
            vo.setId(1);
            vo.setUsername("111");
            return vo;
        }
        vo.setId(2);
        vo.setUsername("22222");
        return vo;
    }
}
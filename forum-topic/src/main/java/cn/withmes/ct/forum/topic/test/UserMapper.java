/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年03月14日
 */
package cn.withmes.ct.forum.topic.test;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * ClassName: UserMapper
 *
 * @author leegoo
 * @Description:
 * @date 2019年03月14日
 */
public interface UserMapper extends BaseMapper<UserTest> {
    Integer demo();
}

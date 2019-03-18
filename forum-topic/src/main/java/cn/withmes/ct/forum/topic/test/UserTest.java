/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年03月14日
 */
package cn.withmes.ct.forum.topic.test;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * ClassName: UserTest
 * @Description:
 * @author leegoo
 * @date 2019年03月14日
 */
@TableName("user")
@Data
public class UserTest {
    @TableField(value = "id")
    private Integer id;

    @TableField(value = "name")
    private String name;

}

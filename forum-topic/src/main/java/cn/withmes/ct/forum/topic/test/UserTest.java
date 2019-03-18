/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年03月14日
 */
package cn.withmes.ct.forum.topic.test;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * ClassName: UserTest
 * @Description:
 * @author leegoo
 * @date 2019年03月14日
 */
@TableName("user")
public class UserTest {
    @TableField(value = "id")
    private Integer id;

    @TableField(value = "name")
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

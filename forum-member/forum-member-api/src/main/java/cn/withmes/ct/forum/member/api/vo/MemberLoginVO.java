package cn.withmes.ct.forum.member.api.vo;


import cn.withmes.ct.forum.base.common.valid.AddVlid;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

;


/**
 * @author leegoo
 * @Description: 会员表
 * @date 2019-03-29
 */
@Data
public class MemberLoginVO implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    @Length(max = 20,min = 1,message = "用户名应该在1-20个字符之间")
    private String username;

    /**
     * 用户密码
     */
    @NotNull(message = "密码不能为空")
    @Length(max = 20,min = 1,message = "密码应该在1-20个字符之间")
    private String password;




    public static final String USERNAME = "username";

    public static final String PASSWORD = "password";


}

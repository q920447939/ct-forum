package cn.withmes.ct.forum.member.api.vo;


import cn.withmes.ct.forum.base.common.valid.AddVlid;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.regex.Matcher;

;


/**
 * @author leegoo
 * @Description: 会员表
 * @date 2019-03-29
 */
@Data
public class MemberAddVO implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 昵称
     */
    @NotNull(message = "昵称不能为空",groups = {AddVlid.class})
    @Length(max = 20,min = 1,message = "昵称应该在1-20个字符之间")
    private String nickName;

    /**
     * 用户名
     */
    @NotNull(message = "昵称不能为空",groups = {AddVlid.class})
    @Length(max = 20,min = 1,message = "用户名应该在1-20个字符之间")
    private String username;

    /**
     * 用户密码
     */
    @NotNull(message = "密码不能为空",groups = {AddVlid.class})
    @Length(max = 20,min = 1,message = "密码应该在1-20个字符之间")
    private String password;

    /**
     * 用户重复密码
     */
    @NotNull(message = "确认密码不能为空",groups = {AddVlid.class})
    @Length(max = 20,min = 1,message = "确认密码应该在1-20个字符之间")
    private String rePassword;

    /**
     * 用户邮箱
     */
    @Pattern(regexp = "^(.+)@(.+)$",message = "邮箱的格式不合法")
    private String email;



    public static final String NICK_NAME = "nick_name";

    public static final String USERNAME = "username";

    public static final String PASSWORD = "password";

    public static final String EMAIL = "email";


   /* public static void main(String[] args) {
        String  str = "hello= thank you";
        String reg = "[^\u2E80-\u9FFF]";
        java.util.regex.Pattern pat = java.util.regex.Pattern.compile(reg);
        Matcher mat = pat.matcher(str);
        System.out.println( mat.find());
        *//*String repickStr = mat.replaceAll("");
        System.out.println("过滤中文后: "+repickStr);*//*
    }
*/

}

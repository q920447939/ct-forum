package cn.withmes.ct.forum.member.api.vo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

;


/**
 * @author leegoo
 * @Description: 会员表
 * @date 2019-03-29
 */
@Data
public class MemberUpdateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private String id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 创建时间
     */
    private LocalDateTime created;

    /**
     * 最后一次登录时间
     */
    private LocalDateTime logined;

    /**
     * 最后一次操作时间
     */
    private LocalDateTime updated;

    /**
     * 用户状态 0:未激活 1:正常 2:停用 3:注销
     */
    private Integer state;

    /**
     * 删除标记
     */
    private Integer deleted;


    public static final String ID = "id";

    public static final String NICK_NAME = "nick_name";

    public static final String USERNAME = "username";

    public static final String PASSWORD = "password";

    public static final String EMAIL = "email";

    public static final String CREATED = "created";

    public static final String LOGINED = "logined";

    public static final String UPDATED = "updated";

    public static final String STATE = "state";

    public static final String DELETED = "deleted";

}

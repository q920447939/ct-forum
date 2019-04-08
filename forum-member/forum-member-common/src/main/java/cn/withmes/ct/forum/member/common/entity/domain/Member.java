package cn.withmes.ct.forum.member.common.entity.domain;


;import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * @Description: 会员表
 * @author leegoo
 * @date 2019-03-29
 */
@Data
@Accessors(chain = true)
@TableName("member")
public class Member implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
	@TableId(value="id")
	private String id;

    /**
     * 昵称
     */
	@TableField("nick_name")
	private String nickName;

    /**
     * 用户名
     */
	@TableField("username")
	private String username;

    /**
     * 用户密码
     */
	@TableField("password")
	private String password;

    /**
     * 用户邮箱
     */
	@TableField("email")
	private String email;

    /**
     * 创建时间
     */
	@TableField("created")
	private LocalDateTime created;

    /**
     * 最后一次登录时间
     */
	@TableField("logined")
	private LocalDateTime logined;

    /**
     * 最后一次操作时间
     */
	@TableField("updated")
	private LocalDateTime updated;

    /**
     * 用户状态 0:未激活 1:正常 2:停用 3:注销
     */
	@TableField("state")
	private Integer state;

    /**
     * 删除标记
     */
	@TableField("deleted")
    @TableLogic
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


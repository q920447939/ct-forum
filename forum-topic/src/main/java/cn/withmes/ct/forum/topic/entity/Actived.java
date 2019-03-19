package cn.withmes.ct.forum.topic.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;



import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Description: 激活码表
 * @author leegoo
 * @date 2019-03-18
 */
@Data
@Accessors(chain = true)

@TableName("actived")
public class Actived implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;

	@TableField("uid")
	private Long uid;

	@TableField("username")
	private String username;

	@TableField("email")
	private String email;

	@TableField("code")
	private String code;

    /**
     * 0未激活 1已激活
     */
	@TableField("state")
	private Integer state;

    /**
     * 创建时间
     */
	@TableField("created")
	private LocalDateTime created;

    /**
     * 过期时间
     */
	@TableField("expired")
	private LocalDateTime expired;



}

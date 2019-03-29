package cn.withmes.ct.forum.common.entity.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Description: 评论表
 * @author leegoo
 * @date 2019-03-26
 */
@Data
@Accessors(chain = true)

@TableName("comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * comment表主键
     */
	@TableId(value="coid", type= IdType.AUTO)
	private Long coid;

    /**
     * post表主键,关联字段
     */
	@TableField("tid")
	private String tid;

    /**
     * 评论作者
     */
	@TableField("author")
	private String author;

    /**
     * 评论所属内容作者id
     */
	@TableField("owner")
	private String owner;

    /**
     * 评论内容
     */
	@TableField("content")
	private String content;

    /**
     * 评论类型
     */
	@TableField("type")
	private String type;

    /**
     * 评论生成时的GMT unix时间戳
     */
	@TableField("created")
	private LocalDateTime created;

	@TableField("state")
	private Integer state;

	@TableLogic
	private Integer deleted;

	public static final String COID = "coid";

	public static final String TID = "tid";

	public static final String AUTHOR = "author";

	public static final String OWNER = "owner";

	public static final String CONTENT = "content";

	public static final String TYPE = "type";

	public static final String CREATED = "created";

	public static final String STATE = "state";


}

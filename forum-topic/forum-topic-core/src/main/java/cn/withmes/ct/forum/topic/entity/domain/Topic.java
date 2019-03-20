package cn.withmes.ct.forum.topic.entity.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Description: 帖子表
 * @author leegoo
 * @date 2019-03-19
 */
@Data
@Accessors(chain = true)

@TableName("topic")
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("tid")
	private String tid;

    /**
     * 所属节点
     */
	@TableField("node_slug")
	private String nodeSlug;

    /**
     * 节点名称
     */
	@TableField("node_title")
	private String nodeTitle;

	@TableField("title")
	private String title;

	@TableField("content")
	private String content;

    /**
     * 创建人
     */
	@TableField("username")
	private String username;

    /**
     * 评论数
     */
	@TableField("comments")
	private Integer comments;

	@TableField("gains")
	private Integer gains;

    /**
     * 是否是精华贴
     */
	@TableField("popular")
	private Integer popular;

    /**
     * 帖子权重
     */
	@TableField("weight")
	private Double weight;

    /**
     * 最后回复人
     */
	@TableField("reply_user")
	private String replyUser;

    /**
     * 最后回复id
     */
	@TableField("reply_id")
	private Long replyId;

    /**
     * 创建时间
     */
	@TableField("created")
	private LocalDateTime created;

    /**
     * 更新时间
     */
	@TableField("updated")
	private LocalDateTime updated;

    /**
     * 最后回复时间
     */
	@TableField("replyed")
	private LocalDateTime replyed;

	@TableLogic
	private Integer deleted;


}

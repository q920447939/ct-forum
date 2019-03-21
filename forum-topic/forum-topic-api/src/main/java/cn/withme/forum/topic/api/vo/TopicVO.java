package cn.withme.forum.topic.api.vo;



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

public class TopicVO implements Serializable {

    private static final long serialVersionUID = 1L;

	private String tid;

    /**
     * 所属节点
     */
	private String nodeSlug;

    /**
     * 节点名称
     */
	private String nodeTitle;

	private String title;

	private String content;

    /**
     * 创建人
     */
	private String username;

    /**
     * 评论数
     */
	private Integer comments;

	private Integer gains;

    /**
     * 是否是精华贴
     */
	private Integer popular;

    /**
     * 帖子权重
     */
	private Double weight;

    /**
     * 最后回复人
     */
	private String replyUser;

    /**
     * 最后回复id
     */
	private Long replyId;

    /**
     * 创建时间
     */
	private LocalDateTime created;

    /**
     * 更新时间
     */
	private LocalDateTime updated;

    /**
     * 最后回复时间
     */
	private LocalDateTime replyed;

	private Integer deleted;
}
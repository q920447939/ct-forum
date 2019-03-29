package cn.withmes.ct.forum.topic.api.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author leegoo
 * @Description: 帖子表
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
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;

    /**
     * 更新时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated;

    /**
     * 最后回复时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")

    private LocalDateTime replyed;

    private Integer deleted;

    private  String replyTime;

    private List<CommentVO> commentList;

}

package cn.withme.forum.topic.api.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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

public class CommentVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * comment表主键
     */
	private Long coid;

    /**
     * post表主键,关联字段
     */
	private String tid;

    /**
     * 评论作者
     */
	private String author;

    /**
     * 评论所属内容作者id
     */
	private String owner;

    /**
     * 评论内容
     */
	private String content;

    /**
     * 评论类型
     */
	private String type;

    /**
     * 评论生成时的GMT unix时间戳
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")

    private LocalDateTime created;

	private Integer state;


}

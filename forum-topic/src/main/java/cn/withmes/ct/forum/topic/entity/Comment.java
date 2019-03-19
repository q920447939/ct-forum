package cn.withmes.ct.forum.topic.entity;

import java.util.Date;
import java.io.Serializable;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description: 评论表
 * @author liming
 * @date 2019-03-18
 */
@Data
@Accessors(chain = true)
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
	private Date created;
	
	private Integer state;
	


	public static final String COID = "coid";

	public static final String TID = "tid";

	public static final String AUTHOR = "author";

	public static final String OWNER = "owner";

	public static final String CONTENT = "content";

	public static final String TYPE = "type";

	public static final String CREATED = "created";

	public static final String STATE = "state";

}

package cn.withmes.ct.forum.topic.entity.bo;


import cn.withmes.ct.forum.topic.entity.domain.Comment;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class CommentBO extends Comment {

}

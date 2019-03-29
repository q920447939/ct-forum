package cn.withmes.ct.forum.common.entity.bo;


import cn.withmes.ct.forum.common.entity.domain.Comment;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

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

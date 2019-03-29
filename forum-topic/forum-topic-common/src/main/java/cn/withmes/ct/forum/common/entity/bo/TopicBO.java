package cn.withmes.ct.forum.common.entity.bo;


import cn.withmes.ct.forum.common.entity.domain.Comment;
import cn.withmes.ct.forum.common.entity.domain.Topic;
import lombok.Data;

import java.util.List;


/**
 * @author leegoo
 * @Description: 帖子表
 * @date 2019-03-19
 */

@Data
public class TopicBO extends Topic {

    private List<Comment> commentList;
}

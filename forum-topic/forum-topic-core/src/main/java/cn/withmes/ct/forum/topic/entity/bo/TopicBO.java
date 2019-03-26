package cn.withmes.ct.forum.topic.entity.bo;


import cn.withmes.ct.forum.topic.entity.domain.Comment;
import cn.withmes.ct.forum.topic.entity.domain.Topic;
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

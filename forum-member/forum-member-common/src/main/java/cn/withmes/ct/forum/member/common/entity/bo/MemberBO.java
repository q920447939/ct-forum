package cn.withmes.ct.forum.member.common.entity.bo;


import cn.withmes.ct.forum.member.common.entity.domain.Member;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

;


/**
 * @Description: 会员表
 * @author leegoo
 * @date 2019-03-29
 */
@Data
@Accessors(chain = true)
public class MemberBO extends Member {

}

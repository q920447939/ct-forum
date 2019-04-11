package cn.withmes.ct.forum.common.entity.bo;

import cn.withmes.ct.forum.common.entity.domain.HistoryNow;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author leegoo
 * @since 2019-04-11
 */
@Data
@Accessors(chain = true)
public class HistoryNowBO extends HistoryNow {

}

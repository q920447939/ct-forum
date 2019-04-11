package cn.withmes.ct.forum.topic.api.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class HistoryNowVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("href")
    private String href;
    @TableField("image_url")
    private String imageUrl;
    @TableField("image_title")
    private String imageTitle;
    /**
     * 创建时间
     */
    @TableField("create_time")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;


    public static final String ID = "id";

    public static final String HREF = "href";

    public static final String IMAGE_URL = "image_url";

    public static final String IMAGE_TITLE = "image_title";

    public static final String CREATE_TIME = "create_time";

}

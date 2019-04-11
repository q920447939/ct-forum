package cn.withmes.ct.forum.common.entity.domain;

import java.util.Date;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class HistoryNow implements Serializable {

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
    private Date createTime;


    public static final String ID = "id";

    public static final String HREF = "href";

    public static final String IMAGE_URL = "image_url";

    public static final String IMAGE_TITLE = "image_title";

    public static final String CREATE_TIME = "create_time";


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

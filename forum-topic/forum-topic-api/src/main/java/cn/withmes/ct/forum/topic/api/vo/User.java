/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年03月29日
 */
package cn.withmes.ct.forum.topic.api.vo;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName: User
 * @Description:
 * @author leegoo
 * @date 2019年03月29日
 */

@Data
@ToString
@Builder
public class User implements Serializable {



    private Integer id;
    private  String name ;

}

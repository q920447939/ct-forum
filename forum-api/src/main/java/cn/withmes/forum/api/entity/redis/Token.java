/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年04月02日
 */
package cn.withmes.forum.api.entity.redis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * ClassName: Token
 * @Description:
 * @author leegoo
 * @date 2019年04月02日
 */
@Data
@Builder
@AllArgsConstructor
public class Token {

    private String token;
    private String code;


}

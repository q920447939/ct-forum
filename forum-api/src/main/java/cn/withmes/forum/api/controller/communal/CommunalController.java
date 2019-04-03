/**
 * @Project: 公共控制器
 * @Author: leegoo
 * @Date: 2019年04月03日
 */
package cn.withmes.forum.api.controller.communal;

import cn.withmes.ct.forum.base.common.config.base.mode.ResponseData;
import cn.withmes.ct.forum.base.common.config.base.utils.SnowflakeId;
import cn.withmes.ct.forum.base.common.config.base.utils.UuidUtils;
import cn.withmes.ct.forum.base.common.config.base.web.BaseRestfulController;
import cn.withmes.ct.utils.utils.UUID;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: CommunalController
 * @Description: 公共控制器
 * @author leegoo
 * @date 2019年04月03日
 */
@RestController
@RequestMapping("/v0.1/communal")
public class CommunalController extends BaseRestfulController {

    /**
     * 随机生成一个uuid
     */
    @GetMapping("/uid")
    public ResponseData<String> randUUid(HttpServletRequest req, HttpServletResponse resp) {
       return successData(UuidUtils.generate());
    }

}

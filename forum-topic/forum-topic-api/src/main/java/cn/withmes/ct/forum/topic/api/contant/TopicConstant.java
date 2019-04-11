/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年04月03日
 */
package cn.withmes.ct.forum.topic.api.contant;

/**
 * ClassName: BaseContant
 *
 * @author leegoo
 * @Description:
 * @date 2019年04月03日
 */
public final class TopicConstant {
    /**
     * 用户状态 1:未激活 2:正常 3:停用 4:注销
     */
    public interface MEMBER_STAT {
        Integer UN_ACTIVITY = 1;
        Integer NORMAL = 2;
        Integer BLOCK = 3;
        Integer CANEL = 4;
    }


}

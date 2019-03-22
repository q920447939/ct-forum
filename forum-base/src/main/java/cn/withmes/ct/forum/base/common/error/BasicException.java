/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年03月22日
 */
package cn.withmes.ct.forum.base.common.error;

/**
 * ClassName: BasicException
 * @Description:
 * @author leegoo
 * @date 2019年03月22日
 */
public class BasicException  extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code = 0;

    public BasicException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
